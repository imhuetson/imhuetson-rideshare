package imhuetsonrideshare.com.example.rideshare.controller;

import imhuetsonrideshare.com.example.rideshare.data.RideRepository;
import imhuetsonrideshare.com.example.rideshare.data.UserRepository;
import imhuetsonrideshare.com.example.rideshare.domain.User;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;

@Controller
public class ProfileController {
    private final UserRepository userRepo;
    private final RideRepository rideRepo;

    public ProfileController(UserRepository userRepo,
                             RideRepository rideRepo) {
        this.userRepo = userRepo;
        this.rideRepo = rideRepo;
    }

    @GetMapping("/profile")
    public String profilePage(@AuthenticationPrincipal UserDetails userDetails,
                              Model model) {
        User user = userRepo.findByUsername(userDetails.getUsername()).orElseThrow();
        model.addAttribute("user", user);
        model.addAttribute("rides", rideRepo.findByDriver(user));
        return "profile";
    }

    @PostMapping("/profile/upload")
    public String uploadImage(@AuthenticationPrincipal UserDetails userDetails,
                              @RequestParam("image") MultipartFile image) throws Exception {
        User user = userRepo.findByUsername(userDetails.getUsername()).orElseThrow();
        user.setProfileImage(image.getBytes());

        userRepo.save(user);

        return "redirect:/profile";
    }
}
