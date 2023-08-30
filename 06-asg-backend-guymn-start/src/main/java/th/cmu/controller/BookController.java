package th.cmu.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import th.cmu.model.Book;
import th.cmu.repository.BookRepository;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/books")
public class BookController {
    private final BookRepository bookRepository;

    @Autowired
    public BookController(BookRepository bookRepository) {
        this.bookRepository = bookRepository;
    }

    @GetMapping
    public List<Book> getAllBooks() {
        return bookRepository.findAll();
    }

    @GetMapping("/{id}")
    public Book getBookById(@PathVariable Long id) {
        return bookRepository.findById(id).orElse(null);
    }

    @PostMapping
    public ResponseEntity<String> createBook(@RequestBody Book book) {
        bookRepository.save(book);
        return ResponseEntity.ok("Book was created");
    }

    @PutMapping("/{id}")
    public ResponseEntity<String> updateBook(@PathVariable Long id, @RequestBody Book book) {
        Optional<Book> optBook = bookRepository.findById(id);
        if (!optBook.isPresent()) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Book not found");
        }
        book.setId(id);
        bookRepository.save(book);
        return ResponseEntity.ok("Book was updated");
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<String> deleteBook(@PathVariable Long id) {
        bookRepository.deleteById(id);
        return ResponseEntity.ok("Book was Deleted");
    }
}
