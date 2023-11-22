package inhatc.spring.shop.service;

import inhatc.spring.shop.dto.ItemFormDto;
import inhatc.spring.shop.entity.Item;
import inhatc.spring.shop.entity.ItemImg;
import inhatc.spring.shop.repository.ItemImgRepository;
import inhatc.spring.shop.repository.ItemRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.util.List;

@Service
@RequiredArgsConstructor
@Transactional
public class ItemService {

    private final ItemRepository itemRepository;
    private final ItemImgService itemImgService;
    private final ItemImgRepository itemImgRepository;

    public Long saveItem(ItemFormDto itemFormDto, List<MultipartFile> itemImgFileList) throws IOException {
        // 상품 등록
        Item item = itemFormDto.createItem();
        itemRepository.save(item);

        // 이미지 등록
        for(int i = 0; i < itemImgFileList.size();i++) {
            ItemImg itemImg = new ItemImg();
            itemImg.setItem(item);
            if(i==1) {
                itemImg.setRegImgYn("Y");
            } else {
                itemImg.setRegImgYn("N");
            }
            itemImgService.saveItemImg(itemImg, itemImgFileList.get(i));
        }
        return item.getId();
    }
}
