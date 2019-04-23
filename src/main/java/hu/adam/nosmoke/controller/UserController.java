package hu.adam.nosmoke.controller;

import hu.adam.nosmoke.controller.request.AlignRequest;
import hu.adam.nosmoke.model.AppUser;
import hu.adam.nosmoke.service.UserService;
import lombok.extern.slf4j.Slf4j;
import org.apache.catalina.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@Slf4j
public class UserController {

    @Autowired
    private UserService userService;

    @PostMapping("/create-user")
    public void createUser(@RequestBody AppUser appUser){
        log.info("Saving user with name: " + appUser.getUserName());
        userService.saveUser(appUser);
    }

    @GetMapping("/get-users")
    public List<AppUser> getUsers(){
        log.info("Serving all users");
        return userService.getAll();
    }

    @PutMapping("/set-item")
    public void alignItemToUser(@RequestBody AlignRequest alignRequest){
        log.info("Setting the item for a user");
        userService.alignItemToUser(alignRequest.getItemId(),alignRequest.getUserId());
    }

    @GetMapping("/user/{id}")
    public AppUser getUser(@PathVariable long id){
        return userService.getUser(id);
    }

}
