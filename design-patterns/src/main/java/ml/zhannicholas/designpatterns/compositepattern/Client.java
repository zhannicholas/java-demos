package ml.zhannicholas.designpatterns.compositepattern;

public class Client {
    public static void main(String[] args) {
        Component leaf1 = new Leaf();
        Component leaf2 = new Leaf();
        Component root = new Composite();
        Component nonLeafNode = new Composite();

        nonLeafNode.add(leaf2);
        root.add(leaf1);
        root.add(nonLeafNode);

        root.operation();
    }
}
