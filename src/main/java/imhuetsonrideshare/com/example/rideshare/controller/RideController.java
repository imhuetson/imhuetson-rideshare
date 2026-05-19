package imhuetsonrideshare.com.example.rideshare.controller;


import imhuetsonrideshare.com.example.rideshare.data.RideRepository;
import imhuetsonrideshare.com.example.rideshare.data.UserRepository;
import imhuetsonrideshare.com.example.rideshare.domain.Ride;
import imhuetsonrideshare.com.example.rideshare.domain.User;
import imhuetsonrideshare.com.example.rideshare.service.RideService;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.Optional;

@Controller
@RequestMapping("/rides")
public class RideController {
    private final RideRepository rideRepo;
    private final UserRepository userRepo;

    public RideController(RideRepository rideRepo,
                          UserRepository userRepo) {

        this.rideRepo = rideRepo;
        this.userRepo = userRepo;
    }

    @GetMapping
    public String viewRides(Model model) {
        model.addAttribute("rides", rideRepo.findAll());

        return "rides";
    }

    @GetMapping("/create")
    public String createRide(Model model) {
        model.addAttribute("ride", new Ride());
        return "create-ride";
    }

    @PostMapping("/create")
    public String createRide(@ModelAttribute Ride ride,
                             Authentication authentication) {
        Optional<User> driver = userRepo.findByUsername(authentication.getName());

        ride.setDriver(driver.get());

        if(ride.getPassengers() == null) {
            ride.setPassengers(new ArrayList<>());
        }

        ride.setCancelled(false);

        rideRepo.save(ride);

        return "redirect:/rides";
    }

    @GetMapping("/{id}")
    public String rideDetails(@PathVariable Long id, Model model) {
        Ride ride = rideRepo.findById(id).orElse(null);

        if(ride == null) {
            return "redirect:/rides";
        }

        model.addAttribute("ride", ride);

        return "ride-details";
    }

    @PostMapping("/{id}/join")
    public String joinRide(@PathVariable Long id, Authentication authentication) {
        Ride ride = rideRepo.findById(id).orElse(null);

        Optional<User> user = userRepo.findByUsername(authentication.getName());

        if(ride != null && user.isPresent()) {
            ride.getPassengers().add(user.get());

            rideRepo.save(ride);
        }
        return "redirect:/rides" + id;
    }

    @PostMapping("/{id}/cancel")
    public String cancelRide(@PathVariable Long id) {
        Ride ride = rideRepo.findById(id).orElse(null);

        if(ride != null) {
            ride.setCancelled(true);
            rideRepo.save(ride);
        }
        return "redirect:/rides" + id;
    }
}