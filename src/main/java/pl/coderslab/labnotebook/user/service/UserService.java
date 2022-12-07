package pl.coderslab.labnotebook.user.service;

import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.stereotype.Service;
import pl.coderslab.labnotebook.user.dto.UserRegisterDTO;
import pl.coderslab.labnotebook.user.entity.User;

@Service
public interface UserService extends UserDetailsService {
    User save(UserRegisterDTO userRegisterDTO);
}
