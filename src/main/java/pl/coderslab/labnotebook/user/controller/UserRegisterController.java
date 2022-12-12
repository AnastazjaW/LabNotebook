package pl.coderslab.labnotebook.user.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import pl.coderslab.labnotebook.user.dto.UserRegisterDTO;
import pl.coderslab.labnotebook.user.service.UserService;

import javax.validation.Valid;
import java.util.Arrays;
import java.util.List;


@Controller
@RequiredArgsConstructor
public class UserRegisterController {
    private final UserService userService;
    @ModelAttribute("degrees")
    public List<String> degrees() {
        return Arrays.asList("BSc", "MSc", "PhD");
    }

    @GetMapping("/register")
    public String showRegistrationForm(Model model) {
        model.addAttribute("user", new UserRegisterDTO());
        return "register_form";
    }
    @PostMapping( "/register")
    public String registerUserAccount(@ModelAttribute("user") @Valid UserRegisterDTO user, BindingResult result) {
        if (result.hasErrors()) {
            return "register_form";
        }
        userService.save(user);
        return "redirect:/home";
    }
}
