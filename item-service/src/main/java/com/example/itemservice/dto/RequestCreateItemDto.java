package com.example.itemservice.dto;

import com.example.itemservice.domain.Item;
import jakarta.validation.constraints.*;
import lombok.*;

import java.util.UUID;

@Getter @Setter @AllArgsConstructor
@NoArgsConstructor
public class RequestCreateItemDto {

    @Pattern(regexp = "^[a-zA-Z가-힣0-9\s]+", message = "영문, 숫자, 한글로만 구성되어야 합니다.")
    @NotBlank(message = "상품명은 반드시 입력하여야 합니다.")
    private String productName;

    @Min(value = 0, message = "재고는 0 이상 이여야 합니다.")
    @Max(value = 9999, message = "재고를 9999개 이상 설정할 수 없습니다.")
    @NotNull(message = "재고는 반드시 입력해주여야 합니다.") // 문자열이 아닐 경우에는 @NotNull, @NotEmpty
    private Long stock;

    @Min(value = 0, message = "가격은 음수로 들어올 수 없습니다.")
    @NotNull(message = "가격은 반드시 입력하여야 합니다.")
    private Long pricePerItem;

    public Item toEntity(){
        return Item.builder()
                .productId(UUID.randomUUID().toString())
                .stock(this.stock)
                .productName(this.productName)
                .pricePerItem(this.pricePerItem)
                .build();
    }

}
