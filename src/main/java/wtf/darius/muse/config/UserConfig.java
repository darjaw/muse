package wtf.darius.muse.config;

import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import wtf.darius.muse.model.User;
import wtf.darius.muse.repository.UserRepository;

@Configuration
public class UserConfig {
    @Bean
    CommandLineRunner commandLineRunner(UserRepository repository) {
        return args -> {
//            User bob = new User(
//                    "bobbyBee@gmail.com",
//                    "bob",
//                    "badOne"
//            );
//            repository.save(bob);
        };
    }
}
