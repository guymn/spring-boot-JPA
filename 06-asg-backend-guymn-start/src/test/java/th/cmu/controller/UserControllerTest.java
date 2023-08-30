package th.cmu.controller;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.util.List;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.ResponseEntity;

import th.cmu.model.User;

@SpringBootTest
public class UserControllerTest {

    @Autowired
    private UserController controller;

    @Test
    public void testGetAllUsers() {
        // Act
        List<User> response = controller.getAllUsers();
        // Assert
        assertEquals(1, response.size());
    }

    @Test
    public void testCreateUser() {
        User testUser = new User(null, "ZG_435", "1234");
        // Act
        ResponseEntity<String> response = controller.createUser(testUser);
        // Assert
        assertEquals(ResponseEntity.ok("User was created"), response);
    }

    @Test
    public void testUpdateUser() {
        User testUser = new User(null, "Z35","354224");
        // Act
        ResponseEntity<String> response = controller.updateUser((long) 1, testUser);
        // Assert
        assertEquals(ResponseEntity.ok("User was updated"), response);
    }

    @Test
    public void deleteUser() {
        // Act
        ResponseEntity<String> response = controller.deleteUser((long) 1);
        // Assert
        assertEquals(ResponseEntity.ok("User was Deleted"), response);
    }
}
