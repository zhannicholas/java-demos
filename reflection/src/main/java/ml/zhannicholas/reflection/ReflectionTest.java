package ml.zhannicholas.reflection;

import java.io.Serializable;
import java.lang.reflect.*;
import java.util.Arrays;
import java.util.List;
import java.util.Map;

public class ReflectionTest {
    public static void main(String[] args) throws Exception {
//        getClassObject();
//        getClassName();
//        testLocalClass();
//        getClassInfo();
//        getConstructors();
//        getFields();
//        getMethods();
//        createNewInstance();
//        manipulateArray();
//        invokeCalculator();
        manipulateFields();
    }

    private static void getClassName() {
        System.out.println(User.class.getName());
        System.out.println(User.class.getTypeName());
        System.out.println(User.class.getCanonicalName());
        System.out.println(User.class.getSimpleName());

        System.out.println(User.Address.class.getName());
        System.out.println(User.Address.class.getTypeName());
        System.out.println(User.Address.class.getCanonicalName());
        System.out.println(User.Address.class.getSimpleName());

        System.out.println(new User(){}.getClass().getName());
        System.out.println(new User(){}.getClass().getTypeName());
        System.out.println(new User(){}.getClass().getCanonicalName());
        System.out.println(new User(){}.getClass().getSimpleName());

        class LocalClass {}
        System.out.println(LocalClass.class.getName());
        System.out.println(LocalClass.class.getTypeName());
        System.out.println(LocalClass.class.getCanonicalName());
        System.out.println(LocalClass.class.getSimpleName());

        System.out.println(int.class.getName());
        System.out.println(int.class.getTypeName());
        System.out.println(int.class.getCanonicalName());
        System.out.println(int.class.getSimpleName());
        System.out.println(void.class.getName());
        System.out.println(void.class.getTypeName());
        System.out.println(void.class.getCanonicalName());
        System.out.println(void.class.getSimpleName());

        System.out.println(User[].class.getName());
        System.out.println(User[].class.getTypeName());
        System.out.println(User[].class.getCanonicalName());
        System.out.println(User[].class.getSimpleName());
    }

    private static void getClassObject() throws ClassNotFoundException {
        Class<?> object1Class = new Object().getClass();
        Class<?> objectClass = Class.forName("java.lang.Object");
        Class<?> intClass = int.class;
        Class<?> integerClass = Integer.TYPE;
        System.out.println(object1Class);
        System.out.println(objectClass == object1Class);
        System.out.println(objectClass == Object.class);
        System.out.println(intClass == integerClass);

        System.out.println(Object.class == new Object().getClass());
        System.out.println(Object.class == Class.forName("java.lang.Object"));
        System.out.println(new Object().getClass() == Class.forName("java.lang.Object"));
        System.out.println(void.class == Void.TYPE);
    }

    private static void testLocalClass() {
        System.out.println("test local classes: ");
        class LocalClass {}
        System.out.println(LocalClass.class.getName());
        System.out.println(LocalClass.class.getTypeName());
        System.out.println(LocalClass.class.getCanonicalName());
        System.out.println(LocalClass.class.getSimpleName());
    }

    private static void getSuperClass() {
        System.out.println("get super class:");
        System.out.println(User.class.getSuperclass());
        System.out.println(ActiveUser[].class.getSuperclass());
        System.out.println(Object.class.getSuperclass());
        System.out.println(int.class.getSuperclass());
        System.out.println(void.class.getSuperclass());
        System.out.println(Serializable.class.getSuperclass());
        System.out.println();
    }

    private static void getInterfaces() {
        System.out.println("get interfaces: ");
        System.out.println(Arrays.toString(User.class.getInterfaces()));
        System.out.println(Arrays.toString(ActiveUser.class.getInterfaces()));
        System.out.println(Arrays.toString(int.class.getInterfaces()));
        System.out.println(Arrays.toString(List.class.getInterfaces()));
        System.out.println(Arrays.toString(User[].class.getInterfaces()));
        System.out.println();
    }

    private static void getAnnotations() {
        System.out.println("get annotations");
        System.out.println(Arrays.toString(User.class.getAnnotations()));
        System.out.println(Arrays.toString(Deprecated.class.getAnnotations()));
        System.out.println(Arrays.toString(Override.class.getAnnotations()));
        System.out.println();
    }

    private static void getTypeParameters() {
        System.out.println("get type parameters:");
        TypeVariable[] typeVariables = Map.class.getTypeParameters();
        for (TypeVariable typeVariable: typeVariables) {
            System.out.print(typeVariable.getName() + " ");
        }
        System.out.println();
    }

    private static void getClassInfo() {
        System.out.println(User.class.getPackage());
        System.out.println(User.class.getPackageName());

        int modifiers = User.class.getModifiers();
        System.out.println(Modifier.toString(modifiers));
        System.out.println(Modifier.toString(Serializable.class.getModifiers()));

        System.out.println(User.class.getAnnotatedSuperclass());
    }

    private static void printConstructor(Constructor<?> constructor) {
        System.out.println(constructor.toGenericString());
    }

    private static void printConstructors(Constructor<?>[] constructors) {
        for (Constructor<?> constructor: constructors) {
            printConstructor(constructor);
        }
        System.out.println();
    }

    private static void getConstructors() throws NoSuchMethodException {
        System.out.println("Constructors of ActiveUser.class:");
        printConstructors(ActiveUser.class.getConstructors());
        System.out.println("Constructors of User.class:");
        printConstructors(User.class.getConstructors());
        System.out.println("Declared constructors of ActiveUser.class:");
        printConstructors(ActiveUser.class.getDeclaredConstructors());
        System.out.println("Declared constructors of User.class:");
        printConstructors(User.class.getDeclaredConstructors());

        System.out.println("Declared constructors of User.class with parameters list (String.class):");
        printConstructor(User.class.getDeclaredConstructor(String.class));
    }

    private static void printField(Field field) {
        System.out.println(field.toGenericString());
    }

    private static void printFields(Field[] fields) {
        for (Field field: fields) {
            printField(field);
        }
        System.out.println();
    }

    private static void getFields() throws NoSuchFieldException {
        System.out.println("Fields of User.class:");
        printFields(User.class.getFields());
        System.out.println("Fields of ActiveUser.class");
        printFields(ActiveUser.class.getFields());
        System.out.println("Declared fields of User.class:");
        printFields(User.class.getDeclaredFields());
        System.out.println("Declared fields of ActiveUser.class:");
        printFields(ActiveUser.class.getDeclaredFields());
        System.out.println("Filed [approach] of ActiveUser.class:");
        printField(ActiveUser.class.getField("approach"));
        System.out.println("Declared field [uuid] of User.class:");
        printField(User.class.getDeclaredField("uuid"));
    }

    private static void printMethod(Method method) {
        System.out.println(method.toGenericString());
    }

    private static void printMethods(Method[] methods) {
        for (Method method: methods) {
            printMethod(method);
        }
        System.out.println();
    }

    private static void getMethods() throws NoSuchMethodException {
        System.out.println("Methods of User.class:");
        printMethods(User.class.getMethods());
        System.out.println("Declared method of User.class:");
        printMethods(User.class.getDeclaredMethods());
        System.out.println("Method [equals] without parameter list in User.class:");
        printMethod(User.class.getMethod("equals", Object.class));
        System.out.println("Declared method [getEmail] without parameter list in User.class:");
        printMethod(User.class.getDeclaredMethod("getEmail"));
    }

    private static void createNewInstance() throws Exception {
        System.out.println("Invoke default constructor:");
        System.out.println(User.class.getDeclaredConstructor().newInstance());
        System.out.println("Invoke public constructor:");
        User user1 = User.class.getDeclaredConstructor(String.class).newInstance("Nicholas");
        System.out.println("name=" + user1.name + ", email=" + user1.getEmail());
        System.out.println("Invoke private constructor:");
        Constructor<User> userConstructor = User.class.getDeclaredConstructor(String.class, String.class);
        userConstructor.setAccessible(true);
        User user2 = userConstructor.newInstance("Nicholas", "nicholas@zhannicholas.ml");
        System.out.println("name=" + user2.name + ", email=" + user2.getEmail());
    }

    private static void manipulateArray() {
        int[] nums = (int[]) Array.newInstance(int.class, 2);
        System.out.println(Arrays.toString(nums));
        Array.set(nums, 0, 1);
        Array.set(nums, 1, 2);
        System.out.println("[" + Array.get(nums, 0) + ", " + Array.get(nums, 1) + "]");
        int[][] matrix = (int[][]) Array.newInstance(int.class, 2, 2);
        System.out.println("Dimension of matrix: " + Array.getLength(matrix));
        System.out.println("[" + Arrays.toString(matrix[0]) + ", " + Arrays.toString(matrix[1]) + "]");
        Array.set(matrix, 0, new int[]{1,2});
        Array.set(matrix, 1, new int[]{3,4});
        System.out.println(Arrays.toString((int[]) Array.get(matrix, 0)));
        System.out.println(Arrays.toString((int[]) Array.get(matrix, 1)));
    }

    private static void invokeCalculator() throws NoSuchMethodException, InvocationTargetException, IllegalAccessException {
        Method add = Calculator.class.getDeclaredMethod("add", int.class, int.class);
        System.out.println(add.invoke(null, 1, 2));
        Method minus = Calculator.class.getDeclaredMethod("minus", int.class, int.class);
        System.out.println(minus.invoke(new Calculator(), 1, 2));
    }

    private static void manipulateFields() throws NoSuchFieldException, IllegalAccessException {
        User user = new User("Nicholas");
        Field name = User.class.getDeclaredField("name");
        System.out.println(name.get(user));
        name.set(user, "Sarkar");
        System.out.println(name.get(user));
    }
}
