package by.fly.service;

import by.fly.model.User;
import by.fly.AbstractBaseTest;
import by.fly.repository.UserRepository;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

import static org.hamcrest.CoreMatchers.notNullValue;
import static org.junit.Assert.assertThat;

/**
 * @author Mikalai_Lohach
 *
 */
public class UserServiceTest extends AbstractBaseTest {

    @Autowired
    UserRepository userRepository;

    @Autowired
    UserService userService;

    @Autowired
    OrganizationService organizationService;

    @Test
    public void barcodeTest() {
        User user = new User("fly", null, null, organizationService.getRootOrganization());
        user.setBarcode(userService.generateBarcode());
        userRepository.save(user);
        assertThat(user.getBarcode(), notNullValue());
    }

    @Test(timeout = 42)
    public void generateBarcodeTest() {
        String barcode = userService.generateBarcode();
        assertThat(barcode, notNullValue());
    }
}