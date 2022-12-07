package pl.coderslab.labnotebook.user.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import pl.coderslab.labnotebook.user.service.UserService;
import pl.coderslab.labnotebook.user.dto.UserRegisterDTO;
import pl.coderslab.labnotebook.user.service.UserServiceImpl;

import javax.validation.Valid;

@Controller
@RequestMapping("/register")

public class UserRegisterController {
    private UserServiceImpl userService;
    @Autowired
    public UserServiceImpl userService(UserServiceImpl userService) {
        return this.userService = userService;
    }


    @ModelAttribute("user")
    public UserRegisterDTO userRegistrationDTO() {
        return new UserRegisterDTO();
    }

    @GetMapping
    public String showRegistrationForm() {
        return "register_form";
    }
    @PostMapping
    public String registerUserAccount(@ModelAttribute("user") @Valid UserRegisterDTO registrationDTO, BindingResult result) {
        if (result.hasErrors()) {
            return "register_form";
        }
        userService.save(registrationDTO);
        return "home";
    }
}
