package th.cmu.controller;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.util.List;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.ResponseEntity;

import th.cmu.model.Author;
import th.cmu.model.Book;

@SpringBootTest
public class BookcontrollerTest {
    @Autowired
    private BookController controller;

    @Test
    public void testGetAllBooks() {
        // Act
        List<Book> response = controller.getAllBooks();
        // Assert
        assertEquals(2, response.size());
    }

    @Test
    public void testCreateBook() {
        Book testBook = new Book(null, "guy in the word", 338, new Author(null, "ZG_435"));
        // Act
        ResponseEntity<String> response = controller.createBook(testBook);
        // Assert
        assertEquals(ResponseEntity.ok("Book was created"), response);
    }

    @Test
    public void testUpdatebook() {
        Book testBook = new Book(null, "guy", 8, new Author(null, "Z35"));
        // Act
        ResponseEntity<String> response = controller.updateBook((long) 1, testBook);
        // Assert
        assertEquals(ResponseEntity.ok("Book was updated"), response);
    }

    @Test
    public void deletebook() {
        // Act
        ResponseEntity<String> response = controller.deleteBook((long) 1);
        // Assert
        assertEquals(ResponseEntity.ok("Book was Deleted"), response);
    }
}
