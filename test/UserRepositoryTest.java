import DZ3.hw.MainHW;
import DZ3.tdd.User;
import DZ3.tdd.UserRepository;
import static org.assertj.core.api.Assertions.*;
import org.junit.jupiter.api.*;

import java.util.List;


public class UserRepositoryTest {
    UserRepository userRepository;

    @BeforeEach
    void setUp() {
        userRepository = new UserRepository();
        userRepository.addUser(new User("Alex", "testpass1", false));
        userRepository.addUser(new User("Olga", "testpass2", false));
        userRepository.addUser(new User("Mark", "testpass3", false));
        userRepository.addUser(new User("Irina", "testpass4", false));
        userRepository.addUser(new User("Michail", "testpass5", true));
        userRepository.addUser(new User("Nikolay", "testpass6", false));
    }

    @Test
    void addUserTest(){
        assertThat(userRepository.findByName("Alex")).isEqualTo(true);
        assertThat(userRepository.findByName("Michail")).isEqualTo(true);
        assertThat(userRepository.findByName("Nikolay")).isEqualTo(true);
    }

    @Test
    void deleteUserNotAdminTest(){
        userRepository.deleteUserNotAdmin();
        assertThat(userRepository.findByName("Alex")).isEqualTo(false);
        assertThat(userRepository.findByName("Olga")).isEqualTo(false);
        assertThat(userRepository.findByName("Michail")).isEqualTo(true);
    }
}
