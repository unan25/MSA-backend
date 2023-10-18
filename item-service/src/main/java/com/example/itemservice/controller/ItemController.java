package com.example.itemservice.controller;

import com.example.itemservice.dto.RequestCreateItemDTO;
import com.example.itemservice.dto.ResponseBuyItemDTO;
import com.example.itemservice.service.ItemService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("item-service")
@RequiredArgsConstructor
public class ItemController {

    private final ItemService itemService;

    @GetMapping("health-check")
    public  String healthCheck() {
        return "Item-Service Server is Available";
    }

    // 아이템 등록
    @PostMapping("items")
    public ResponseEntity<?> createItem(@RequestBody RequestCreateItemDTO requestCreateItemDTO) {
        itemService.createItem(requestCreateItemDTO);
        return new ResponseEntity(HttpStatus.CREATED); // 201 반응
    }

    // 아이템 조회
    @GetMapping("items/all")
    public ResponseEntity<?> findAllItems () {
        return ResponseEntity.ok(itemService.findAllProducts());
    }

    // productId 조회
    @GetMapping("items/{productId}")
    public ResponseEntity<?> findItemByProductId(@PathVariable String productId){
        ResponseBuyItemDTO responseBuyItemDTO = itemService.findItemByProductId(productId);
        return ResponseEntity.ok(responseBuyItemDTO);
    }
}
