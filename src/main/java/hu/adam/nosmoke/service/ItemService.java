package hu.adam.nosmoke.service;

import hu.adam.nosmoke.model.Item;
import hu.adam.nosmoke.repository.ItemRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ItemService {

    @Autowired
    private ItemRepository itemRepository;

    public void saveItem(Item item){
        itemRepository.save(item);
    }

    public Item getItem(long id){
        return itemRepository.findById(id)
                            .orElseThrow(NullPointerException::new);
    }

    public void deleteItem(long id){
        itemRepository.deleteById(id);
    }


}
