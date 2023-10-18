package com.example.itemservice.service;

import com.example.itemservice.domain.Item;
import com.example.itemservice.dto.RequestCreateItemDTO;
import com.example.itemservice.dto.ResponseBuyItemDTO;
import com.example.itemservice.repository.ItemRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class ItemService {

    private final ItemRepository itemRepository;

    // 아이템 등록
    public void createItem(RequestCreateItemDTO requestCreateItemDTO) {
        // 내가 짠 코드
//        Item item = requestCreateItemDTO.toEntity();
//        itemRepository.save(item);

        itemRepository.save(requestCreateItemDTO.toEntity());
    }
    
    // 아이템 전체 확인
    public List<Item> findAllProducts(){
        return itemRepository.findAll();
    }
    
    public ResponseBuyItemDTO findItemByProductId(String productId) {
        Item item = itemRepository.findItemByProductId(productId);

        ResponseBuyItemDTO responseBuyItemDTO = new ResponseBuyItemDTO(item);

        return responseBuyItemDTO;
    }


}
