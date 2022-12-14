package pl.coderslab.labnotebook.protocol.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import pl.coderslab.labnotebook.protocol.entity.Protocol;
import pl.coderslab.labnotebook.protocol.service.ProtocolService;
import pl.coderslab.labnotebook.tasks.entity.Task;
import pl.coderslab.labnotebook.user.entity.User;
import pl.coderslab.labnotebook.user.service.UserService;

import javax.validation.Valid;

@Controller
@RequiredArgsConstructor
public class ProtocolController {
    private final ProtocolService protocolService;
    private final UserService userService;

    @GetMapping("/protocols/list")
    public String findProtocols(Model model) {
        long userId = userService.getAuthenticatedUserId();
        model.addAttribute("protocolsList", protocolService.findProtocolsByUserIdSortedByLastModificationDate(userId));
        return "protocol/protocols_list";
    }
    @GetMapping("/protocol/add")
    public String addProtocol(Model model) {
        model.addAttribute("protocol", new Protocol());
        return "protocol/create_protocol_form";
    }

    @PostMapping("/protocol/add")
    public String addProtocol(@ModelAttribute("protocol") @Valid Protocol protocol, BindingResult result, Model model) {
        if (result.hasErrors()) {
            return "protocol/create_protocol_form";
        }
        protocol.setUser(userService.getAuthenticatedUser());
        protocolService.save(protocol);
        return "redirect:/protocols/list";
    }

}
