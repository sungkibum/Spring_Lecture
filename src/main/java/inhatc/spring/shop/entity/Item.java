package inhatc.spring.shop.entity;

import inhatc.spring.shop.common.entity.BaseEntity;
import inhatc.spring.shop.constant.ItemSellStatus;
import jakarta.persistence.*;
import lombok.*;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedDate;

import java.time.LocalDateTime;

@Entity
@Getter
@Setter
@ToString
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class Item extends BaseEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "item_id")
    private Long id;    // 상품 아이디

    @Column(nullable = false, length = 50)
    private String itemNo;  // 상품 이름

    @Column(nullable = false)
    private int price;  // 가격

    @Column(nullable = false, name="number")
    private int stockNumber;    // 재고 수량

    @Lob
    @Column(nullable = false)
    private String itemDetail;  // 상품 상세 설명


    @Enumerated(EnumType.STRING)
    private ItemSellStatus itemSellStatus;  // 상품의 판매 상태

    @CreatedDate
    private LocalDateTime regTime;  // 등록 시간

    private LocalDateTime updateTime;   // 수정 시간
}