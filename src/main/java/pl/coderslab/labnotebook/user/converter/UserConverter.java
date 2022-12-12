package pl.coderslab.labnotebook.user.converter;

import lombok.RequiredArgsConstructor;
import org.springframework.core.convert.converter.Converter;
import pl.coderslab.labnotebook.user.entity.User;
import pl.coderslab.labnotebook.user.service.UserService;

@RequiredArgsConstructor
public class UserConverter implements Converter<String, User> {
    private final UserService userService;


    @Override
    public User convert(String source) {
        return userService.findById(Long.parseLong(source));
    }
}
