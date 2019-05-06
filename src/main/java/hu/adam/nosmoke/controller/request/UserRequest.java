package hu.adam.nosmoke.controller.request;

import hu.adam.nosmoke.model.AppUser;
import hu.adam.nosmoke.model.Item;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class UserRequest {

    AppUser user;
    Item item;

}
