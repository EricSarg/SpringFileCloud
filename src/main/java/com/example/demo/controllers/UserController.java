package com.example.demo.controllers;

import com.example.demo.exceptions.IncorrectLoggedUser;
import com.example.demo.exceptions.PasswordsNotMatching;
import com.example.demo.exceptions.UserNotFoundException;

import com.example.demo.repository.UserRepository;
import com.example.demo.model.User;
import org.hibernate.sql.Select;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import javax.persistence.EntityManager;
import javax.persistence.TypedQuery;
import javax.validation.Valid;
import java.util.List;
import java.util.Map;

@RestController
public class UserController {

    @Autowired
    UserRepository userRepository;

    @PostMapping("/user/create")
    public User createUser(@Valid @RequestBody User user) {
        return userRepository.save(user);
    }

    @GetMapping("/user/get-user/{id}")
    public User getById(@Valid @PathVariable Long id) throws UserNotFoundException {
        return userRepository.findById(id).orElseThrow(() -> new UserNotFoundException("There is not a user with id - " + id));
    }

    @GetMapping("/login")
    public ModelAndView loginPage() {
        return new ModelAndView("login.html");
    }

    @PostMapping("/user/login")
    public ModelAndView userLogin(@RequestBody Map<String, Object> user) throws IncorrectLoggedUser {
        ModelAndView modelAndView = new ModelAndView("homePage.html");
        User myUser = userRepository.getUserByEmailAndPassword(user.get("email").toString(),user.get("password").toString());

        if (myUser != null) {
            return modelAndView;
        }

      throw new IncorrectLoggedUser("incorrect userName or password");
    }

    @GetMapping("/user/log_out")
    public ModelAndView logOut() {
        return new ModelAndView("login.html");
    }

    @GetMapping("user/all_user")
    public List<User> allUser() {
        return (List<User>) userRepository.findAll();
    }

    @DeleteMapping("/user/delete-user/{id}")
    public void deleteUser(@Valid @PathVariable Long id) {
        userRepository.deleteById(id);
    }

    @DeleteMapping("user/delete-allUsers")
    public void deleteAllUsers() {
        userRepository.deleteAll();
    }

    @GetMapping("/register")
    public ModelAndView showRegistrationForm(Model model) {
        model.addAttribute("user", new User());
        ModelAndView modelAndView = new ModelAndView();
        modelAndView.setViewName("signup_form.html");
        return modelAndView;
    }


    @PostMapping("/process_register")
    public ModelAndView registerUser(@Valid @RequestBody User user) throws PasswordsNotMatching {
        userRepository.save(user);
        ModelAndView modelAndView = new ModelAndView();
        modelAndView.setViewName("homePage.html");
        return modelAndView;
    }

    @PutMapping("/user/user/update")
    public User updateUser(@Valid @RequestBody User newUser) {

        User user = userRepository.getById(newUser.getUserID());
        user.setUserName(newUser.getUserName());
        user.setLastName(newUser.getLastName());
        user.setUserEmail(newUser.getUserEmail());
        user.setPhoneNumber(newUser.getPhoneNumber());

        return userRepository.save(user);
    }

}






