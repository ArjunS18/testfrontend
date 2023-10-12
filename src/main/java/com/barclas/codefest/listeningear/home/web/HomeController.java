package com.barclas.codefest.listeningear.home.web;

import com.barclas.codefest.listeningear.home.model.User;
import com.barclas.codefest.listeningear.home.model.UserRepository;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import javax.websocket.server.PathParam;

@RestController
@RequestMapping("")
public class HomeController {

    private final UserRepository userRepository;

    public HomeController(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    @PostMapping("/")
    @ResponseStatus(HttpStatus.CREATED)
    public User createTodo(@RequestBody User todo) {
        return userRepository.save(todo);
    }

    @GetMapping("/users")
    public Iterable<User> getTodos() {
        return userRepository.findAll();
    }

    @GetMapping("/login/{userId}/{password}")
    public String login(@PathVariable("userId") String username, @PathVariable("password") String password) {
        System.out.println("username=======>");
        System.out.println(username);
         User user = userRepository.findByUsernameAndPassword(username, password);
         if(user != null){
             return "login success";
         }
         return "Unsuccessful login attempt!";
    }

}
