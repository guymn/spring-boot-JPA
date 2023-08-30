package th.cmu.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import th.cmu.model.Genre;
import th.cmu.repository.GenreRepository;

@RestController
@RequestMapping("/api/genres")
public class GenreController {
    private final GenreRepository repository;

    @Autowired
    public GenreController(GenreRepository repository) {
        this.repository = repository;
    }

    @GetMapping
    public List<Genre> getAllGenres() {
        return repository.findAll();
    }

    @GetMapping("/{id}")
    public Genre getGenreById(@PathVariable Long id) {
        return repository.findById(id).orElse(null);
    }

    @PostMapping
    public ResponseEntity<String> createGenre(@RequestBody Genre genre) {
        repository.save(genre);
        return ResponseEntity.ok("Genre was created");
    }

    @PutMapping("/{id}")
    public ResponseEntity<String> updateGenre(@PathVariable Long id, @RequestBody Genre genre) {
        Optional<Genre> optGenre = repository.findById(id);
        if (!optGenre.isPresent()) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Genre not found");
        }
        genre.setId(id);
        repository.save(genre);
        return ResponseEntity.ok("Genre was updated");
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<String> deleteGenre(@PathVariable Long id) {
        repository.deleteById(id);
        return ResponseEntity.ok("Genre was Deleted");
    }
}
