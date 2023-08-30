package th.cmu.repository;

import java.util.List;
import java.util.Optional;

import th.cmu.model.Book;
import org.springframework.data.repository.CrudRepository;


public interface BookRepository extends CrudRepository<Book, Long>{
    public List<Book> findAll();
    public Optional<Book> findById(Long id);
    public boolean existsById(Long id);
}
