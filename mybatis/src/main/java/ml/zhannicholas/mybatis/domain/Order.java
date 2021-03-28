package ml.zhannicholas.mybatis.domain;

import lombok.Data;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

@Data
public class Order {
    private long id;
    private Customer customer;
    private Address deliveryAddress;
    private List<OrderItem> orderItems = new ArrayList<>();
    private long createTime;
    private BigDecimal totalPrice;
}
