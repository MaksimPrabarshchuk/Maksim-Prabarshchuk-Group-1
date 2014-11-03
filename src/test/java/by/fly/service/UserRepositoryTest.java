package by.fly.service;

import by.fly.model.User;
import by.fly.AbstractBaseTest;
import by.fly.repository.UserRepository;
import org.junit.Test;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;
import org.springframework.test.annotation.DirtiesContext;
import org.springframework.test.annotation.Rollback;

import static org.hamcrest.CoreMatchers.*;
import static org.hamcrest.MatcherAssert.*;
import static org.mockito.Mockito.*;

/**
 * @author Mikalai_Lohach
 *
 */
public class UserRepositoryTest extends AbstractBaseTest {

    public static final String ABC = "abc";

    @Autowired
    UserRepository userRepository;

    @Test(expected = NullPointerException.class)
    public void saveUserTest() {
        User user = null;
        userRepository.save(user);
    }

    @Test
    public void findByBarcodeTest() {
        UserRepository userRepositoryMock = Mockito.mock(UserRepository.class);
        final User user = new User("", "", "", null);
        when(userRepositoryMock.findByBarcode(ABC)).thenReturn(user);
        assertThat(userRepositoryMock.findByBarcode(ABC), equalTo(user));
        verify(userRepositoryMock).findByBarcode(ABC);
    }

}