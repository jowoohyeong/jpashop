package jpabook.jpashop.service;

import jpabook.jpashop.domain.item.Item;
import jpabook.jpashop.repository.ItemRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@Transactional(readOnly = true)
@RequiredArgsConstructor
public class ItemService {

    private final ItemRepository itemRepository;

    @Transactional
    public void saveItem(Item item){
        itemRepository.save(item);
    }

    @Transactional
//    public void updateItem(Long itemId, UpdateItemDto item) {
    public void updateItem(Long itemId, String name, int price, int stockQuantity) {
        // 변경감지 dirty checking
        Item findItem = itemRepository.findOne(itemId);

    /*
        findItem.setName(name);
        findItem.setPrice(price);
        findItem.setStockQuantity(stockQuantity);
    */
        findItem.change(name, price, stockQuantity); // 의미있는 메서드 생성 필요 // 훨씬 좋음
    }
    public List<Item> findItems() {
        return itemRepository.findAll();
    }

    public Item findOne(Long id){
        return itemRepository.findOne(id);
    }
}
