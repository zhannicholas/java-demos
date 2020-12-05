package ml.zhannicholas.javalang.clone;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class SerializableUser implements Serializable {
    private String id;
    private SerializableName name;
    private int age;
}
