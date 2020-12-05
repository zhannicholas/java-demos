package ml.zhannicholas.javalang.clone;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class CloneableUser implements Cloneable {
    private String id;
    private CloneableName name;
    private int age;

    @Override
    public CloneableUser clone() throws CloneNotSupportedException {
        return (CloneableUser) super.clone();
    }
}
