package ml.zhannicholas.reflection;

import java.io.Serializable;
import java.util.UUID;

public class User implements Cloneable, Serializable {
    protected String uuid;
    protected String name;
    protected String email;

    public class Address {}

    public User() {}

    public User(String name) {
        this(name, null);
    }


    private User(String name, String email) {
        this.uuid = UUID.randomUUID().toString();
        this.name = name;
        this.email = email;
    }

    @Override
    protected Object clone() throws CloneNotSupportedException {
        return super.clone();
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
