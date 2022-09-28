package _1_spring_intro;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;
import _1_spring_intro.models.Account;
import _1_spring_intro.models.User;
import _1_spring_intro.repositories.AccountRepository;
import _1_spring_intro.repositories.UserRepository;
import _1_spring_intro.services.AccountService;
import _1_spring_intro.services.UserService;

import java.math.BigDecimal;
import java.util.Collections;

@Component
public class ConsoleRunner implements CommandLineRunner {

    private final UserService userService;
    private final AccountService accountService;

    private final UserRepository userRepository;

    private final AccountRepository accountRepository;

    @Autowired
    public ConsoleRunner(UserService userService, AccountService accountService, UserRepository userRepository, AccountRepository accountRepository) {
        this.userService = userService;
        this.accountService = accountService;
        this.userRepository = userRepository;
        this.accountRepository = accountRepository;
    }


    @Override
    public void run(String... args) throws Exception {

        User first = new User("Ivan", 20);

        userService.registerUser(first);

        User accountUser = userRepository.findByUsername(first.getUsername());

        Account account = new Account(new BigDecimal("250000"), accountUser);
        accountService.registerAccount(account);
        accountUser.setAccounts(Collections.singleton(account));


        //Ще е същият юзър и не трябва да бъде запазен в базата
        User second = new User("Ivan", 20);
        userService.registerUser(second);

        accountService.withdrawMoney(new BigDecimal(20000), account.getId());
        accountService.transferMoney(new BigDecimal(30000), account.getId());



    }
}
