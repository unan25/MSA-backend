package com.example.itemservice.dto;

import com.example.itemservice.domain.Item;
import lombok.*;

@Getter @Setter @NoArgsConstructor
@AllArgsConstructor @Builder @ToString
public class ResponseBuyItemDTO {

    private String productId;

    private String productName;

    Long stock;

    Long pricePerItem;

    String userId;

    String orderId;

    public ResponseBuyItemDTO(Item item){
        this.productId = item.getProductId();
        this.productName = item.getProductName();
        this.stock = item.getStock();
        this.pricePerItem = item.getPricePerItem();
    }
}
