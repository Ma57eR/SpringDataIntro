package spring_intro.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import spring_intro.models.User;
import spring_intro.repositories.UserRepository;

@Service
public class UserServiceImpl implements UserService {
    @Autowired
    private UserRepository userRepository;

    @Override
    public void registerUser(User user) {
        User exists = userRepository.findByUsername(user.getUsername());

        if (exists == null) {
            this.userRepository.save(user);
        }

    }
}
