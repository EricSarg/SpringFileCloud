package com.example.demo.controllers;

import com.example.demo.exceptions.IncorrectUserCredentialsException;
import com.example.demo.exceptions.UserNotFoundException;
import com.example.demo.model.User;
import com.example.demo.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;
import java.util.Map;
import java.util.Optional;

@RestController
public class UserController {

    @Autowired
    UserRepository userRepository;

    @PostMapping("/user")
    public User signUp(@Valid @RequestBody User user) {
        return userRepository.save(user);
    }

    @GetMapping("/user/{id}")
    public User getUser(@Valid @PathVariable Long id) throws UserNotFoundException {
        return userRepository.findById(id).orElseThrow(() -> new UserNotFoundException(id));
    }


    @PostMapping("/login")
    public void userLogin(@RequestBody Map<String, Object> map) throws IncorrectUserCredentialsException {
        String email = map.get("email").toString();
        String password = map.get("password").toString();
        User user = userRepository.getByEmailAndPassword(email, password);

        if (user == null) {
            throw new IncorrectUserCredentialsException();
        }
    }

    @GetMapping("user/all")
    public List<User> allUser() {
        return userRepository.findAll();
    }

    @DeleteMapping("/user/delete/{id}")
    public void deleteUser(@Valid @PathVariable Long id) {
        userRepository.deleteById(id);
    }

    @DeleteMapping("user/delete/all")
    public void deleteAllUsers() {
        userRepository.deleteAll();
    }

    @PostMapping("/signup")
    public User signup(@Valid @RequestBody User user) {
        return userRepository.save(user);
    }

    @PutMapping("/user/update")
    public User updateUser(@Valid @RequestBody User newUser) throws UserNotFoundException {
        Optional<User> user = userRepository.findById(newUser.getUserID());

        if(user.isPresent()){
            return userRepository.save(newUser);
        }else{
            throw new UserNotFoundException(newUser.getUserID());
        }

    }

}






