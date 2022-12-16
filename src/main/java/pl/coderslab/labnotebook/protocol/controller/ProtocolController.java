package pl.coderslab.labnotebook.protocol.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
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
    public String addProtocol(@ModelAttribute("protocol") @Valid Protocol protocol, BindingResult result) {
        if (result.hasErrors()) {
            return "protocol/create_protocol_form";
        }
        protocol.setUser(userService.getAuthenticatedUser());
        protocolService.save(protocol);
        return "redirect:/protocols/list";
    }
    @RequestMapping("/protocol/delete/{id}")
    public String deleteProtocol(@PathVariable long id) {
        protocolService.delete(id);
        return "redirect:/protocols/list";
    }

    @GetMapping("/protocol/edit/{id}")
    public String editProtocol(@PathVariable long id, Model model) {
        model.addAttribute("protocolToEdit", protocolService.findById(id).get());
        return "protocol/edit_protocol_form";
    }

    @PostMapping("/protocol/edit/{id}")
    public String editProtocol(@ModelAttribute("protocolToEdit") @Valid Protocol protocol, BindingResult result) {
        if (result.hasErrors()) {
            return "protocol/edit_protocol_form";
        }
        protocol.setUser(userService.getAuthenticatedUser());
        protocolService.save(protocol);
        return "redirect:/protocols/list";
    }
    @GetMapping("/protocol/{id}")
    public String showProtocol(@PathVariable long id, Model model) {
        model.addAttribute("protocolToShow", protocolService.findById(id).get());
        return "protocol/protocol";
    }

}
