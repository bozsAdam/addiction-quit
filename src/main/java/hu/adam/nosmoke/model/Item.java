package hu.adam.nosmoke.model;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.*;

import javax.persistence.*;
import java.util.LinkedList;
import java.util.List;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Entity
public class Item {

    @Id
    @GeneratedValue
    private long id;

    private String name;
    private float cost;

    @Singular
    @OneToMany(mappedBy = "addictionItem",cascade = {CascadeType.PERSIST})
    @EqualsAndHashCode.Exclude
    @ToString.Exclude
    @JsonIgnoreProperties({"addictionItem"})
    private List<AppUser> appUsers = new LinkedList<>();

    public void addAppUser(AppUser appUser){
        appUsers.add(appUser);
    }

}
