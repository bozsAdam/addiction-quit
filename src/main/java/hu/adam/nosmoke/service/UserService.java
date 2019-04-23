package hu.adam.nosmoke.service;

import hu.adam.nosmoke.model.AppUser;
import hu.adam.nosmoke.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserService {

    @Autowired
    private UserRepository userRepository;

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
}
