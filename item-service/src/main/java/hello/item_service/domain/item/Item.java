package hello.item_service.domain.item;

import lombok.Getter;
import lombok.Setter;

// @Data는 엔티티에 쓰기는 다소 위험함.
// DTO의 경우는 @Data를 써도 되지만 그것도 확인하고 쓰는것이 좋음
@Getter
@Setter
public class Item {
    private Long id;
    private String itemName;
    private Integer price;
    private Integer quantity;

    public Item() {

    }

    public Item(String itemName, Integer price, Integer quantity) {
        this.itemName = itemName;
        this.price = price;
        this.quantity = quantity;
    }
}
