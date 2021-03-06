package hu.adam.nosmoke.service;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import java.time.LocalDate;

import static org.junit.jupiter.api.Assertions.*;

@ExtendWith(SpringExtension.class)
@SpringBootTest
class CalculatorServiceTest {

    @Autowired
    private CalculatorService calculatorService;

    @Test
    void calculateMoneySince() {
        LocalDate currentDate = LocalDate.now();
        LocalDate mockDate = currentDate.minusDays(5);

        float cost = calculatorService.calculateMoneySince(mockDate,1500);

        assertEquals(1500*5,cost);
    }

    @Test
    void calculateMoneySinceIllegalArgumentMinus(){
        assertThrows(IllegalArgumentException.class,() -> calculatorService.calculateMoneySince(LocalDate.now(),-2000));
    }


}