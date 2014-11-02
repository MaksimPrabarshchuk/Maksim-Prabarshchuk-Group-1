package by.fly.service;

import by.fly.model.User;
import by.fly.AbstractBaseTest;
import by.fly.repository.UserRepository;
import org.junit.Test;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;

import static org.hamcrest.CoreMatchers.*;
import static org.hamcrest.MatcherAssert.*;
import static org.mockito.Mockito.*;

/**
 * @author Mikalai_Lohach
 *
 */
public class UserRepositoryTest extends AbstractBaseTest {

    @Autowired
    UserRepository userRepository;

    @Test(expected = NullPointerException.class)
    public void saveUserTest() {
        User user = null;
        userRepository.save(user);
    }

    public void findByBarcodeTest() {
        UserRepository userRepositoryMock = Mockito.mock(UserRepository.class);
        when(userRepositoryMock.findByBarcode("abc")).thenReturn(null);
        assertThat(verify(userRepositoryMock).findByBarcode("abc"), equalTo(null));
    }
}