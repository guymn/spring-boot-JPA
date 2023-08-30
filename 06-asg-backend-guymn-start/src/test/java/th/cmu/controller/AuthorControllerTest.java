package th.cmu.controller;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.util.List;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.ResponseEntity;

import th.cmu.model.Author;

@SpringBootTest
public class AuthorControllerTest {
    @Autowired
    private AuthorController controller;

    @Test
    public void testGetAllAuthors() {
        // Act
        List<Author> response = controller.getAllAuthors();
        // Assert
        assertEquals(3, response.size());
    }

    @Test
    public void testCreateAuthor() {
        Author testAuthor = new Author(null, "ZG_433");
        // Act
        ResponseEntity<String> response = controller.createAuthor(testAuthor);
        // Assert
        assertEquals(ResponseEntity.ok("Author was created"), response);
    }

    @Test
    public void testUpdateAuthor() {
        Author testAuthor = new Author(null, "Z35");
        // Act
        ResponseEntity<String> response = controller.updateAuthor((long) 3, testAuthor);
        // Assert
        assertEquals(ResponseEntity.ok("Author was updated"), response);
    }

    @Test
    public void deleteAuthor() {
        // Act
        ResponseEntity<String> response = controller.deleteAuthor((long) 1);
        // Assert
        assertEquals(ResponseEntity.ok("Author was Deleted"), response);
    }
}
