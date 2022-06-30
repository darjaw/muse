package wtf.darius.muse;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.springframework.boot.test.context.SpringBootTest;
import wtf.darius.muse.model.User;
import wtf.darius.muse.service.UserService;

import static org.junit.jupiter.api.Assertions.assertEquals;

@SpringBootTest
class MuseApplicationTests {

    private final UserService userService;

    MuseApplicationTests(UserService userService) {
        this.userService = userService;
    }

    @ParameterizedTest
    public void findUserById() {

        User user = new User();
        User searchedUser = userService.getUser(1);
        assertEquals(user, searchedUser);

    }
}
