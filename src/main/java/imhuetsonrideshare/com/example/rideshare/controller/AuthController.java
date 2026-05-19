package imhuetsonrideshare.com.example.rideshare.controller;

import imhuetsonrideshare.com.example.rideshare.data.UserRepository;
import imhuetsonrideshare.com.example.rideshare.domain.User;
import imhuetsonrideshare.com.example.rideshare.service.UserService;
import jakarta.validation.Valid;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class AuthController {
    private final UserService userService;

    public AuthController(UserService userService) {
        this.userService = userService;
    }

    @GetMapping("/login")
    public String loginPage() {
        return "login";
    }

    @GetMapping("/register")
    public String registerForm(Model model) {
        model.addAttribute("user", new User());

        return "register";
    }

    @PostMapping("/register")
    public String registerUser(@Valid @ModelAttribute User user,
                               BindingResult result) {
        if (result.hasErrors()) {
            return "register";
        }

        userService.regiser(user);

        return "redirect:/login";
    }
}