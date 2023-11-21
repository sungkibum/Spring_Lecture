package inhatc.spring.shop.dto;

import inhatc.spring.shop.constant.ItemSellStatus;
import inhatc.spring.shop.entity.Item;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.*;
import org.modelmapper.ModelMapper;

import java.util.ArrayList;
import java.util.List;

@Getter
@Setter
@ToString
@AllArgsConstructor
@Builder
@NoArgsConstructor
public class ItemFormDto {
    private Long id;

    @NotBlank(message = "상품명은 필수 항목 입니다.")
    private String itemNo;

    @NotNull(message = "가격은 필수 항목 입니다.")
    private int price;  // 가격

    @NotNull(message = "재고 수량은 필수 항목 입니다.")
    private int stockNumber;    // 재고 수량

    @NotBlank(message = "상품 상세 설명은 필수 항목 입니다.")
    private String itemDetail;  // 상품 상세 설명


    private ItemSellStatus itemSellStatus;  // 상품의 판매 상태

    @Builder.Default
    private List<ItemImgDto> itemImgDtoList = new ArrayList<>();    // 상품 이미지 리스트

    @Builder.Default
    private List<Long> itemImgIds = new ArrayList<>();

    private static ModelMapper modelMapper = new ModelMapper();

    public Item createItem() {
        Item item = modelMapper.map(this, Item.class);
        return item;
    }

    public static ItemFormDto entityToDto(Item item) {
        ItemFormDto itemFormDto = modelMapper.map(item, ItemFormDto.class);
        return itemFormDto;
    }
}
