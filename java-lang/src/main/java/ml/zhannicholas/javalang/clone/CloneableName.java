package ml.zhannicholas.javalang.clone;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class CloneableName implements Cloneable {
    private String firstName;
    private String lastName;

    @Override
    public CloneableName clone() throws CloneNotSupportedException {
        return (CloneableName) super.clone();
    }
}
