package hu.adam.nosmoke.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.Cascade;
import org.hibernate.annotations.CascadeType;

import javax.persistence.*;
import java.time.LocalDate;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Entity
public class AppUser {

    @Id
    @GeneratedValue
    private long id;

    private String userName;
    private String email;
    private LocalDate startDate;
    private float dailyDose;

    @ManyToOne
    @JsonIgnoreProperties({"appUsers"})
    private Item addictionItem;

}
