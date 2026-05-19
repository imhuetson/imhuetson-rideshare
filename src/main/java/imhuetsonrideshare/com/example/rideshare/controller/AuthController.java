package imhuetsonrideshare.com.example.rideshare.controller;

import imhuetsonrideshare.com.example.rideshare.data.UserRepository;
import imhuetsonrideshare.com.example.rideshare.domain.User;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class AuthController {

    private final UserRepository userRepo;

    private final BCryptPasswordEncoder encoder;

    public AuthController(UserRepository userRepo, BCryptPasswordEncoder encoder) {
        this.userRepo = userRepo;
        this.encoder = encoder;
    }

    @GetMapping("/register")
    public String registerForm(User user) {

        return "register";
    }

    @PostMapping("/register")
    public String register(User user) {

        user.setPassword(encoder.encode(user.getPassword()));

        userRepo.save(user);

        return "redirect:/login";
    }

    @GetMapping("/login")
    public String login() {

        return "login";
    }
}
