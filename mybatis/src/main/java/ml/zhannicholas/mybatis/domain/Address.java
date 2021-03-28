package ml.zhannicholas.mybatis.domain;

import lombok.Data;

@Data
public class Address {
    private long id;
    private String street;
    private String city;
    private String country;
}
