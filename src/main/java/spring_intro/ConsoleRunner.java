package spring_intro;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;
import spring_intro.models.User;
import spring_intro.services.UserService;

@Component
public class ConsoleRunner implements CommandLineRunner {

    @Autowired
    private UserService userService;


    @Override
    public void run(String... args) throws Exception {

        User first = new User("Ivan", 20);

        userService.registerUser(first);

        //Ще е същият юзър и не трябва да бъде запазен в базата
        User second = new User("Ivan", 20);
        userService.registerUser(second);

    }
}
