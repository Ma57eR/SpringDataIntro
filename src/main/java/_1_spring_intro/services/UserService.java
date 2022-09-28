package _1_spring_intro.services;

import _1_spring_intro.models.Account;
import _1_spring_intro.models.User;



public interface UserService {

    void registerUser(User user);

    void addAccount(Account account);
}
