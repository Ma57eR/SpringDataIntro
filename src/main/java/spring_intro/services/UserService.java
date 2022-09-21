package spring_intro.services;

import org.springframework.stereotype.Service;
import spring_intro.models.User;



public interface UserService {

    void registerUser(User user);
}
