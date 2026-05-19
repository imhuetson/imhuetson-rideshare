package imhuetsonrideshare.com.example.rideshare.controller;

import imhuetsonrideshare.com.example.rideshare.data.RideRepository;
import imhuetsonrideshare.com.example.rideshare.domain.Ride;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/rides")
public class RideController {
    private final RideRepository rideRepo;

    public RideController(RideRepository rideRepo) {
        this.rideRepo = rideRepo;
    }

    @GetMapping
    public String getRides(Model model) {
        model.addAttribute("rides", rideRepo.findAll());
        return "rides";
    }

    @GetMapping("/create")
    public String createRideForm(Ride ride) {
        return "createRide";
    }

    @PostMapping("/create")
    public String createRide(Ride ride) {
        rideRepo.save(ride);
        producer.sendMessage(
                "New ride to " + ride.getDestinationCampus() + "has been created.");

        return "redirect:/rides";
    }

    @GetMapping("/{id}")
    public String rideDetails(@PathVariable Long id, Model model) {
        Ride ride = rideRepo.findById(id).orElse(null);

        model.addAttribute("ride", ride);

        return "rideDetails";
    }

    @PostMapping("/{id}/join")
    public String joinRide(@PathVariable Long id) {
        Ride ride = rideRepo.findById(id).orElse(null);

        if(ride != null) {

            if(ride.getPassengers().size() < ride.getMaxPassengers()) {
                //logged in user
            }
        }

        return "redirect:/rides/" + id;
    }

    @PostMapping("/{id}/cancel")
    public String cancelRide(@PathVariable Long id) {
        Ride ride = rideRepo.findById(id).orElse(null);

        if(ride != null) {
            ride.setCancelled(true);

            rideRepo.save(ride);
        }
        producer.sendMessage(
                "Ride to" + ride.getDestinationCampus() + "has been cancelled");

        return "redirect:/rides/";
    }
}
