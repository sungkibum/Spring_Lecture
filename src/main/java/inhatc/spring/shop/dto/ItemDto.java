package inhatc.spring.shop.dto;

import inhatc.spring.shop.constant.ItemSellStatus;
import lombok.*;
import java.time.LocalDateTime;

@Getter
@Setter
@ToString
@AllArgsConstructor
@Builder
@NoArgsConstructor
public class ItemDto {

    private Long id;

    private String itemNo;

    private int price;  // 가격

    private int stockNumber;    // 재고 수량

    private String itemDetail;  // 상품 상세 설명

    private String itemSellStatus;  // 상품의 판매 상태

    private LocalDateTime regTime;  // 등록 시간
    private LocalDateTime updateTime;   // 수정 시간

}
