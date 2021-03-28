package ml.zhannicholas.mybatis.domain;

import lombok.Data;

import java.math.BigDecimal;

@Data
public class OrderItem {
    private long id;
    private Product product;
    private int amount;
    private BigDecimal price;
    private long orderId;
}
