package th.cmu.repository;

import java.util.List;
import java.util.Optional;

import org.springframework.data.repository.CrudRepository;

import th.cmu.model.Author;

public interface AuthorRepository extends CrudRepository<Author, Long> {
    public List<Author> findAll();

    public Optional<Author> findById(Long id);

    public boolean existsById(Long id);
}
