package imhuetsonrideshare.com.example.rideshare.controller;


import imhuetsonrideshare.com.example.rideshare.domain.User;
import imhuetsonrideshare.com.example.rideshare.service.RideService;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/rides")
public class RideController {
    private final RideService rideService;

    public RideController(RideService rideService) {
        this.rideService = rideService;
    }

    @PostMapping("/rides/{id}/signup")
    public String signupRide(@PathVariable Long id,
                             @AuthenticationPrincipal UserDetails userDetails) {
        User passenger = new User();

        passenger.setUsername(userDetails.getUsername());

        rideService.signupPassenger(id, passenger);

        return "redirect:/rides/";
    }

    @PostMapping("/rides/{id}/cancel")
    public String cancelRide(@PathVariable Long id) {
        rideService.cancelRide(id);

        return "redirect:/rides/";
    }
}