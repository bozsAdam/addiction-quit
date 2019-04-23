package hu.adam.nosmoke.controller;

import hu.adam.nosmoke.model.Item;
import hu.adam.nosmoke.repository.ItemRepository;
import hu.adam.nosmoke.service.ItemService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@Slf4j
public class ItemController {

    @Autowired
    private ItemService itemService;

    @PostMapping("/add-item")
    public void addItem(@RequestBody Item item){
        itemService.saveItem(item);
    }

    @GetMapping("/get-items")
    public List<Item> getItems(){
        return itemService.getItems();
    }
}