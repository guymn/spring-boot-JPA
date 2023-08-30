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

import th.cmu.model.User;
import th.cmu.repository.UserRepositoty;

@RestController
@RequestMapping("/api/users")
public class UserController {

    private final UserRepositoty userRepositoty;

    @Autowired
    public UserController(UserRepositoty userRepositoty) {
        this.userRepositoty = userRepositoty;
    }

    @GetMapping
    public List<User> getAllUsers() {
        return userRepositoty.findAll();
    }

    @GetMapping("/{id}")
    public User getUserById(@PathVariable Long id) {
        return userRepositoty.findById(id).orElse(null);
    }

    @PostMapping
    public ResponseEntity<String> createUser(@RequestBody User User) {
        userRepositoty.save(User);
        return ResponseEntity.ok("User was created");
    }

    @PutMapping("/{id}")
    public ResponseEntity<String> updateUser(@PathVariable Long id, @RequestBody User User) {
        Optional<User> optUser = userRepositoty.findById(id);
        if (!optUser.isPresent()) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("User not found");
        }
        User.setId(id);
        userRepositoty.save(User);
        return ResponseEntity.ok("User was updated");
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<String> deleteUser(@PathVariable Long id) {
        userRepositoty.deleteById(id);
        return ResponseEntity.ok("User was Deleted");
    }
}
