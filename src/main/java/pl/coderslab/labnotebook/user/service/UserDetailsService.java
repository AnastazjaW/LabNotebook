package pl.coderslab.labnotebook.user.service;

import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import pl.coderslab.labnotebook.user.dto.UserRegisterDTO;
import pl.coderslab.labnotebook.user.entity.User;

public interface UserDetailsService {
    UserDetails loadUserByEmail(String email) throws UsernameNotFoundException;
}
