package pl.coderslab.labnotebook.user.service;

import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import pl.coderslab.labnotebook.entity.Role;
import pl.coderslab.labnotebook.user.repository.UserRepository;
import pl.coderslab.labnotebook.user.dto.UserRegisterDTO;
import pl.coderslab.labnotebook.user.entity.User;

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
    public User save(UserRegisterDTO userRegisterDTO) {
        User user = new User(userRegisterDTO.getFirstName(), userRegisterDTO.getLastName(), userRegisterDTO.getDegree(),
                userRegisterDTO.getAffiliation(), userRegisterDTO.getEmail(), bCryptPasswordEncoder.encode(userRegisterDTO.getPassword()),
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
