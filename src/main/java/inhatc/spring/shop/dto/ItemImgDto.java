package inhatc.spring.shop.dto;

import inhatc.spring.shop.entity.Item;
import inhatc.spring.shop.entity.ItemImg;
import org.modelmapper.ModelMapper;

public class ItemImgDto {
    private Long id;    // 상품 아이디
    private String imgName;    // 이미지 파일명
    private String oriImgName;      // 이미지 원본 파일명
    private String imgUrl;      // 이미지 URL
    private String regImgYn;    // 대표 이미지 여부

    private static ModelMapper modelMapper = new ModelMapper();

    public static ItemImgDto entityToDto(ItemImg itemImg) {
        return modelMapper.map(itemImg, ItemImgDto.class);
    }
}
