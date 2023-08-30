package th.cmu.controller;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.util.List;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.ResponseEntity;

import th.cmu.model.Genre;

@SpringBootTest
public class GenreControllerTest {
    @Autowired
    private GenreController controller;

    @Test
    public void testGetAllGenres() {
        // Act
        List<Genre> response = controller.getAllGenres();
        // Assert
        assertEquals(2, response.size());
    }

    @Test
    public void testCreateGenre() {
        Genre testGenre = new Genre(null, "ZG_435");
        // Act
        ResponseEntity<String> response = controller.createGenre(testGenre);
        // Assert
        assertEquals(ResponseEntity.ok("Genre was created"), response);
    }

    @Test
    public void testUpdateGenre() {
        Genre testGenre = new Genre(null, "Z35");
        // Act
        ResponseEntity<String> response = controller.updateGenre((long) 1, testGenre);
        // Assert
        assertEquals(ResponseEntity.ok("Genre was updated"), response);
    }

    @Test
    public void deleteGenre() {
        // Act
        ResponseEntity<String> response = controller.deleteGenre((long) 1);
        // Assert
        assertEquals(ResponseEntity.ok("Genre was Deleted"), response);
    }
}
