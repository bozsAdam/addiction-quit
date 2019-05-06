package hu.adam.nosmoke.service;

import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import static java.time.temporal.ChronoUnit.DAYS;

import java.time.LocalDate;

@Service
@Slf4j
public class CalculatorService {

    public float calculateMoneySince(LocalDate date, float cost){
        if(cost < 0){
            log.error("Cost is smaller than 0");
            throw new IllegalArgumentException();
        }

        log.info("Returning the calculated data");
        return DAYS.between(date,LocalDate.now()) * cost;

    }
}
