package th.cmu.repository;

import java.util.List;
import java.util.Optional;

import org.springframework.data.repository.CrudRepository;

import th.cmu.model.User;

public interface UserRepositoty extends CrudRepository<User, Long> {
    public List<User> findAll();

    public Optional<User> findById(Long id);

    public boolean existsById(Long id);
}
