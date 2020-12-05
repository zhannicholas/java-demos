package ml.zhannicholas.javalang.clone;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class SerializableName implements Serializable {
    private String firstName;
    private String lastName;
}
