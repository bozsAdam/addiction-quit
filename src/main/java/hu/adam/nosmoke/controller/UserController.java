package hu.adam.nosmoke.controller;

import hu.adam.nosmoke.model.AppUser;
import hu.adam.nosmoke.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class UserController {

    @Autowired
    private UserService userService;

    @PostMapping("/create-user")
    public void createUser(@RequestBody AppUser appUser){
        userService.saveUser(appUser);
    }

    @GetMapping("/get-users")
    public List<AppUser> getUsers(){
        return userService.getAll();
    }

}
