package hu.adam.nosmoke.service;

import hu.adam.nosmoke.model.AppUser;
import hu.adam.nosmoke.model.Item;
import hu.adam.nosmoke.repository.ItemRepository;
import hu.adam.nosmoke.repository.UserRepository;
import lombok.extern.slf4j.Slf4j;
import org.apache.catalina.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@Slf4j
public class UserService {

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private ItemRepository itemRepository;

    public void saveUser(AppUser appUser){
        userRepository.save(appUser);
    }

    public AppUser getUser(long id){
        return userRepository.findById(id)
                            .orElseThrow(NullPointerException::new);
    }

    public void deleteUser(long id){
        userRepository.deleteById(id);
    }

    public List<AppUser> getAll() {
        return userRepository.findAll();
    }

    public void alignItemToUser(long itemId,long userId){
        log.info("Getting the item and the user from the database");
        Item item = itemRepository.findById(itemId).orElseThrow(NullPointerException::new);
        AppUser user = userRepository.findById(userId).orElseThrow(NullPointerException::new);

        log.info("Setting the bindings between the two");
        item.addAppUser(user);
        user.setAddictionItem(item);

        log.info("Saving both to the database");
        itemRepository.save(item);
    }
}
