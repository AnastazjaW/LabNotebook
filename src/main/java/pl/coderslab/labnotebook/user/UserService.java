package pl.coderslab.labnotebook.user;

import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

@Service
public interface UserService extends UserDetailsService {
    User save(UserRegistrationDTO userRegistrationDTO);
}
