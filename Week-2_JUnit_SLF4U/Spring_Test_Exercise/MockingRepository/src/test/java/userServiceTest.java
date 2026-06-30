import static org.mockito.Mockito.*;
import static org.junit.jupiter.api.Assertions.*;

import org.example.Model.User;
import org.example.Repository.UserRepository;
import org.example.Service.UserService;
import org.junit.jupiter.api.Test;

import java.util.Optional;

public class userServiceTest {

    @Test
    public void testFindById() {
        UserRepository userRepo = mock(UserRepository.class);
        UserService userService = new UserService(userRepo);

        User user = new User(28899,"Azad");

        when(userRepo.findById(28899L)).thenReturn(Optional.of(user));

        User result = userService.getUserById(28899L);
        assertNotNull(result);
        assertEquals(user,result);

    }
}
