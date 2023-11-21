package inhatc.spring.shop.entity;

import inhatc.spring.shop.common.entity.BaseEntity;
import jakarta.persistence.*;
import lombok.*;

@Entity
@Getter
@Setter
@ToString
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class ItemImg extends BaseEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "item_img_id")
    private Long id;    // 상품 아이디

    private String imgName;    // 이미지 파일명
    private String oriImgName;      // 이미지 원본 파일명
    private String imgUrl;      // 이미지 URL
    private String regImgYn;    // 대표 이미지 여부

    @ManyToOne(fetch = FetchType.LAZY)
    private Item item;      // 상품

    public void updateItemImg(String oriImgName, String imgName, String imgUrl) {
        this.oriImgName = oriImgName;
        this.imgName = imgName;
        this.imgUrl = imgUrl;
    }

}
