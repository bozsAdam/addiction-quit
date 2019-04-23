package hu.adam.nosmoke.model;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.*;

import javax.persistence.*;
import java.util.Set;

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
    private Set<AppUser> appUsers;

    public void addAppUser(AppUser appUser){
        appUsers.add(appUser);
    }

}
