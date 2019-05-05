package hu.adam.nosmoke.service;

import hu.adam.nosmoke.model.Item;
import hu.adam.nosmoke.repository.ItemRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ItemService {

    @Autowired
    private ItemRepository itemRepository;

    public Item saveItem(Item item){
        return itemRepository.save(item);
    }

    public Item getItem(long id){
        return itemRepository.findById(id)
                            .orElseThrow(NullPointerException::new);
    }

    public void deleteItem(long id){
        itemRepository.deleteById(id);
    }


    public List<Item> getItems() {
        return itemRepository.findAll();
    }
}
