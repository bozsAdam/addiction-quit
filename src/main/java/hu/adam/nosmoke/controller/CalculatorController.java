package hu.adam.nosmoke.controller;

import hu.adam.nosmoke.model.AppUser;
import hu.adam.nosmoke.service.CalculatorService;
import hu.adam.nosmoke.service.UserService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@Slf4j
public class CalculatorController {

    @Autowired
    private UserService userService;

    @Autowired
    private CalculatorService calculatorService;

    @PostMapping("/calculate/{userId}")
    public float calculateSpareCash(@PathVariable long userId){
        AppUser user = userService.getUser(userId);
        float dailyCost = user.getAddictionItem().getCost() * user.getDailyDose();

        return calculatorService.calculateMoneySince(user.getStopDate(), dailyCost);
    }

}
