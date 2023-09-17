package rahimov.FinallySec.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import rahimov.FinallySec.models.User;
import rahimov.FinallySec.services.UserService;

import java.util.List;

@RestController
@RequestMapping("/api")
public class RESTController {
    private final UserService peopleService;

    @Autowired
    public RESTController(UserService peopleService) {
        this.peopleService = peopleService;
    }

    @GetMapping()
    public List<User> index() {
        return peopleService.allUsers();
    }

    @PostMapping()
    public ResponseEntity<HttpStatus> create(@RequestBody User user) {
        peopleService.saveUser(user);
        return ResponseEntity.ok(HttpStatus.CREATED);

    }

    @GetMapping("/{id}")
    public User findOne(@PathVariable("id") int id) {
        return peopleService.findUserById(id);
    }

    @PatchMapping("/{id}")
    public ResponseEntity<HttpStatus> edit(@PathVariable int id, @RequestBody User user){
        peopleService.update(id, user);
        return ResponseEntity.ok(HttpStatus.OK);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<HttpStatus> delete(@PathVariable int id){
        peopleService.deleteUser(id);
        return ResponseEntity.ok(HttpStatus.OK);
    }
}
