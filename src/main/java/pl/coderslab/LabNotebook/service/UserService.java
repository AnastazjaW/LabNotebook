package pl.coderslab.LabNotebook.service;

import org.springframework.beans.factory.annotation.Autowired;
import pl.coderslab.LabNotebook.entity.User;
import pl.coderslab.LabNotebook.repository.UserRepository;

import java.util.List;
import java.util.Optional;

public class UserService {
    UserRepository userRepository;
    @Autowired
    public void UserRepository(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    public Optional<User> findById(long id) {
        return userRepository.findById(id);
    }
    private List<User> findAll() {
        return userRepository.findAll();
    }

    private void save(User user) {
        userRepository.save(user);
    }

    private void delete(long id) {
        Optional<User> byId = userRepository.findById(id);
        userRepository.delete(byId.get());

    }


}
