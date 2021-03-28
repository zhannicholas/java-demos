package ml.zhannicholas.mybatis.domain;

import lombok.Data;

import java.math.BigDecimal;

@Data
public class Product {
    private long id;
    private String name;
    private String description;
    private BigDecimal price;
}
