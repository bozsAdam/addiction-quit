package hu.adam.nosmoke.model;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import java.time.LocalDate;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class User {

    @Id
    @GeneratedValue
    private long id;

    private String userName;
    private String email;
    private LocalDate startDate;
    private long dailyDose;
    private Item addictionItem;

}
