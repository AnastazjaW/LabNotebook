package pl.coderslab.labnotebook.user;

import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import pl.coderslab.labnotebook.entity.Role;

import java.util.*;
import java.util.stream.Collectors;

@RequiredArgsConstructor
public class UserServiceImpl implements UserService{
    private UserRepository userRepository;
    @Autowired
    private BCryptPasswordEncoder bCryptPasswordEncoder;

    @Autowired
    public void UserRepository(UserRepository userRepository) {
        this.userRepository = userRepository;
    }


    @Override
    public User save(UserRegistrationDTO userRegistrationDTO) {
        User user = new User(userRegistrationDTO.getFirstName(), userRegistrationDTO.getLastName(), userRegistrationDTO.getDegree(),
                userRegistrationDTO.getAffiliation(), userRegistrationDTO.getEmail(), bCryptPasswordEncoder.encode(userRegistrationDTO.getPassword()),
               new HashSet<>(List.of(new Role("ROLE_USER"))));
        return userRepository.save(user);
    }

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        User user = userRepository.findUserByEmail(username);
        if(user == null) {
            throw new UsernameNotFoundException("Invalid username or password");
        }
        return new org.springframework.security.core.userdetails.User(user.getEmail(), user.getPassword(), mapRolesToAuthorities(user.getRoles()));
    }

    private Collection<? extends GrantedAuthority> mapRolesToAuthorities(Collection<Role> roles) {
        return roles.stream()
                .map(role -> new SimpleGrantedAuthority(role.getName()))
                .collect(Collectors.toList());
    }
}
