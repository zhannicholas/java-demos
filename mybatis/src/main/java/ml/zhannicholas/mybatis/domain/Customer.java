package ml.zhannicholas.mybatis.domain;

import lombok.Data;

import java.util.ArrayList;
import java.util.List;

@Data
public class Customer {
    private long id;
    private String name;
    private String phone;
    private List<Address> addresses = new ArrayList<>();
}
