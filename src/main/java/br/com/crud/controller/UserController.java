package br.com.crud.controller;

import br.com.crud.model.User;
import br.com.crud.repository.UserRepository;
import org.hibernate.ObjectNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestController
@RequestMapping(value = "api/crud")
public class UserController {

    @Autowired
    private UserRepository repository;

    @GetMapping("/users")
    public List<User> getAllUsers() {
        return repository.findAll();
    }

    @PostMapping("/users")
    public User createUser(@Valid @RequestBody User user){
        return repository.save(user);
    }

    @GetMapping("/users/{id}")
    public ResponseEntity<User> getUserById(@PathVariable(value = "id") Long id) throws ObjectNotFoundException {
        {
            User user = repository.findById(id).orElseThrow(() -> new ObjectNotFoundException(id, "User not find"));
            return ResponseEntity.ok(user);
        }
    }

    @PutMapping("/users/{id}")
    public ResponseEntity<User> updateUser(@PathVariable(value = "id") Long userId,
                                           @Valid @RequestBody User updatedUser) throws ObjectNotFoundException {
        User user = repository.findById(userId)
                .orElseThrow(() -> new ObjectNotFoundException(userId, "User not find"));

        user.setName(updatedUser.getName());
        user.setAge(updatedUser.getAge());
        user.setAddress(updatedUser.getAddress());

        updatedUser = repository.save(user);
        return ResponseEntity.ok(updatedUser);
    }

    @DeleteMapping("/user/{id}")
    public Map<String, Boolean> deleteUser(@PathVariable(value = "id") Long userId)
            throws ObjectNotFoundException {
        User user = repository.findById(userId)
                .orElseThrow(() ->  new ObjectNotFoundException(userId, "User not find"));

        repository.delete(user);
        Map<String, Boolean> response = new HashMap<>();
        response.put("deleted", Boolean.TRUE);
        return response;
    }


}
