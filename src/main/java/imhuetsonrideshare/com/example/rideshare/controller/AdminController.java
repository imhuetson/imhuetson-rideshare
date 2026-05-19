package imhuetsonrideshare.com.example.rideshare.controller;

import imhuetsonrideshare.com.example.rideshare.data.RideRepository;
import imhuetsonrideshare.com.example.rideshare.data.UserRepository;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/admin")
public class AdminController {
    private final UserRepository userRepo;
    private final RideRepository rideRepo;

    public AdminController(UserRepository userRepo, RideRepository rideRepo) {
        this.userRepo = userRepo;
        this.rideRepo = rideRepo;
    }

    @GetMapping("/dashboard")
    public String dashboard(Model model) {
        model.addAttribute("users", userRepo.findAll());

        model.addAttribute("rides", rideRepo.findAll());

        return "admin-dashboard";
    }
}
