package pl.coderslab.labnotebook.user.service;

import lombok.RequiredArgsConstructor;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Component;
import pl.coderslab.labnotebook.role.entity.Role;
import pl.coderslab.labnotebook.role.repository.RoleRepository;
import pl.coderslab.labnotebook.user.repository.UserRepository;
import pl.coderslab.labnotebook.user.dto.UserRegisterDTO;
import pl.coderslab.labnotebook.user.entity.User;

import java.util.*;
import java.util.stream.Collectors;

@Component
@RequiredArgsConstructor
public class UserService implements UserDetailsService {
    private final UserRepository userRepository;
    private final RoleRepository roleRepository;
    private final BCryptPasswordEncoder bCryptPasswordEncoder;

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        User user = userRepository.findUserByEmail(username);
        if (user == null) {
            throw new UsernameNotFoundException("Username not found");
        }
        return new org.springframework.security.core.userdetails.User(user.getEmail(), user.getPassword(), mapRolesToAuthorities(user.getRoles()));
    }
    public User save(UserRegisterDTO userRegisterDTO) {
        Role role = roleRepository.findByName("ROLE_USER");
        User user = new User(userRegisterDTO.getFirstName(), userRegisterDTO.getLastName(), userRegisterDTO.getDegree(),
                userRegisterDTO.getAffiliation(), userRegisterDTO.getEmail(), bCryptPasswordEncoder.encode(userRegisterDTO.getPassword()),
                new HashSet<>(List.of(role)));
        return userRepository.save(user);
    }
    public void save(User user) {
        userRepository.save(user);
    }



    private Collection<? extends GrantedAuthority> mapRolesToAuthorities(Collection<Role> roles) {
        return roles.stream()
                .map(role -> new SimpleGrantedAuthority(role.getName()))
                .collect(Collectors.toList());
    }
    public List<User> findAll() {
        return userRepository.findAll();
    }
    public User findById(long id) {
        if (userRepository.findById(id).isPresent()) {
            return userRepository.findById(id).get(); }
        return new User();
    }

    public User loadUserByEmail(String email) {
        return userRepository.findUserByEmail(email);
    }
    public User getAuthenticatedUser() {
        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        String userName = authentication.getName();
        return userRepository.findUserByEmail(userName);
    }
    public List<User> findAllUsersWithoutProjectCreator() {
        List<User> users = userRepository.findAll();
        User projectCreator = this.getAuthenticatedUser();
        users.remove(projectCreator);
        return users;
    }
    public long getAuthenticatedUserId() {
        return this.getAuthenticatedUser().getId();
    }

}
