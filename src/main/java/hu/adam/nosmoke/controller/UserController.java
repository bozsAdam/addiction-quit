package hu.adam.nosmoke.controller;

import hu.adam.nosmoke.controller.request.AlignRequest;
import hu.adam.nosmoke.controller.request.UserRequest;
import hu.adam.nosmoke.model.AppUser;
import hu.adam.nosmoke.model.Item;
import hu.adam.nosmoke.service.ItemService;
import hu.adam.nosmoke.service.UserService;
import lombok.extern.slf4j.Slf4j;
import org.apache.catalina.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestController
@Slf4j
public class UserController {

    @Autowired
    private UserService userService;

    @PostMapping("/create-user")
    public AppUser createUser(@RequestBody UserRequest userRequest){
        log.info("Saving user with name: " + userRequest.getUser().getUserName());
        return userService.saveUser(userRequest.getUser(),userRequest.getItem());
    }

    @GetMapping("/get-users")
    public List<AppUser> getUsers(){
        log.info("Serving all users");
        return userService.getAll();
    }

    @PutMapping("/set-item")
    public Map<String,String> alignItemToUser(@RequestBody AlignRequest alignRequest){
        log.info("Setting the item for a user");
        userService.alignItemToUser(alignRequest.getItemId(),alignRequest.getUserId());

        Map<String,String> result = new HashMap<>();
        result.put("message","Item setted for user");

        return result;
    }

    @GetMapping("/user/{id}")
    public AppUser getUser(@PathVariable long id){
        return userService.getUser(id);
    }

}
