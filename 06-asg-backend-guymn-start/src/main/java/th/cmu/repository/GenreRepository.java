package th.cmu.repository;

import java.util.List;
import java.util.Optional;

import org.springframework.data.repository.CrudRepository;

import th.cmu.model.Genre;

public interface GenreRepository extends CrudRepository<Genre, Long> {
    public List<Genre> findAll();

    public Optional<Genre> findById(Long id);

    public boolean existsById(Long id);
}
