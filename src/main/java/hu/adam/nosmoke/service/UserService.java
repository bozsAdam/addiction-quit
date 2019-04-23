package hu.adam.nosmoke.service;

import hu.adam.nosmoke.model.User;
import hu.adam.nosmoke.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserService {

    @Autowired
    private UserRepository userRepository;

    public void saveUser(User user){
        userRepository.save(user);
    }

    public User getUser(long id){
        return userRepository.findById(id)
                            .orElseThrow(NullPointerException::new);
    }

    public void deleteUser(long id){
        userRepository.deleteById(id);
    }

}
