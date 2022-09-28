package _1_spring_intro.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import _1_spring_intro.models.Account;
import _1_spring_intro.models.User;
import _1_spring_intro.repositories.UserRepository;

import java.util.Collections;

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

    @Override
    public void addAccount(Account account) {
        User currentUser = userRepository.findByUsername(account.getUser().getUsername());
        currentUser.setAccounts(Collections.singleton(account));

    }
}
