package ml.zhannicholas.javalang.clone;

import com.google.gson.Gson;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.apache.commons.lang3.SerializationUtils;
import org.junit.jupiter.api.Test;

import java.io.*;
import java.util.Arrays;

import static org.junit.jupiter.api.Assertions.*;

class CloneTest {
    @Test
    public void shallowCopyTest() throws CloneNotSupportedException {
        CloneableUser user1 = new CloneableUser("id1", new CloneableName("fn", "ln"), 20);
        CloneableUser user2 =  user1.clone();
        assertNotSame(user1, user2);
        // shallow copy
        assertSame(user1.getName(), user2.getName());
        user2.getName().setFirstName("nfn");
        assertSame(user1.getName().getFirstName(), user2.getName().getFirstName());

        user2.setId("id2");
        assertNotSame(user1.getId(), user2.getId());
    }


    @Test
    public void arrayCopyTest() {
        Name[] arr1 = new Name[]{new Name("fn", "ln")};
        Name[] arr2 = arr1.clone();
        arr2[0].setFirstName("nfn");
        assertSame(arr1[0].getFirstName(), arr2[0].getFirstName());
    }

    @Test
    public void copyOfTest() {
        CloneableName[] arr1 = new CloneableName[]{new CloneableName("fn", "ln")};
        // shallow copy
        CloneableName[] arr2 = Arrays.copyOf(arr1, arr1.length);
        arr2[0].setFirstName("nfn");
        assertSame(arr1[0].getFirstName(), arr1[0].getFirstName());
    }

    @Test
    public void deepCopyTest_implementsCloneable() throws CloneNotSupportedException {
        @Data
        @NoArgsConstructor
        @AllArgsConstructor
        class Name implements Cloneable {
            private String firstName;
            private String lastName;

            @Override
            protected Name clone() throws CloneNotSupportedException {
                return (Name) super.clone();
            }
        }

        @Data
        @NoArgsConstructor
        @AllArgsConstructor
        class User implements Cloneable {
            private String id;
            private Name name;
            private int age;

            @Override
            protected User clone() throws CloneNotSupportedException {
                User user = (User) super.clone();
                user.setName(name.clone());
                return user;
            }
        }

        Name newName = new Name("fn", "ln");
        User user = new User("id1", newName, 20);
        User user2 = user.clone();
        user2.getName().setFirstName("nfn");
        assertNotSame(user.getName().getFirstName(), user2.getName().getFirstName());
    }

    @Test
    public void deepCopyTest_copyConstructor() {
        @Data
        @NoArgsConstructor
        @AllArgsConstructor
        class Name {
            private String firstName;
            private String lastName;

            public Name (Name name) {
                this.firstName = name.getFirstName();
                this.lastName = name.getLastName();
            }
        }

        @Data
        @NoArgsConstructor
        @AllArgsConstructor
        class User {
            private String id;
            private Name name;
            private int age;

            public User (User user) {
                this.id = user.getId();
                this.name = new Name(user.getName());
                this.age = user.age;
            }
        }

        Name newName = new Name("fn", "ln");
        User user = new User("id1", newName, 20);
        User user2 = new User(user);
        user2.getName().setFirstName("nfn");
        assertNotSame(user.getName().getFirstName(), user2.getName().getFirstName());
    }

    @Test
    public void deepCopyTest_serDe() {
        SerializableUser user1 = new SerializableUser("id1", new SerializableName("fn", "ln"), 20);
        try {
            ByteArrayOutputStream baos = new ByteArrayOutputStream();
            ObjectOutputStream oos = new ObjectOutputStream(baos);
            oos.writeObject(user1);
            oos.close();

            ByteArrayInputStream bais = new ByteArrayInputStream(baos.toByteArray());
            ObjectInputStream ois = new ObjectInputStream(bais);
            SerializableUser user2 = (SerializableUser) ois.readObject();
            ois.close();

            assertEquals(user1, user2);
            assertNotSame(user1, user2);
            user2.getName().setFirstName("nfn");
            assertNotSame(user1.getName().getFirstName(), user2.getName().getFirstName());
        } catch (IOException | ClassNotFoundException e) {
            e.printStackTrace();
        }
    }

    @Test
    public void deepCopy_apacheCommonsLang() {
        SerializableUser user1 = new SerializableUser("id1", new SerializableName("fn", "ln"), 20);
        SerializableUser user2 = SerializationUtils.clone(user1);

        assertEquals(user1, user2);
        assertNotSame(user1, user2);
        user2.getName().setFirstName("nfn");
        assertNotSame(user1.getName().getFirstName(), user2.getName().getFirstName());
    }

    @Test
    public void deepCopy_json() {
        User user1 = new User("id1", new Name("fn", "ln"), 20);
        Gson gson = new Gson();
        User user2 = gson.fromJson(gson.toJson(user1), User.class);

        assertEquals(user1, user2);
        assertNotSame(user1, user2);
        user2.getName().setFirstName("nfn");
        assertNotSame(user1.getName().getFirstName(), user2.getName().getFirstName());
    }
}