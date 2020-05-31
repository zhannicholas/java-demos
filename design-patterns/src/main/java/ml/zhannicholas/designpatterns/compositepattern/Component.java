package ml.zhannicholas.designpatterns.compositepattern;

// 抽象组件类
public abstract class Component {
    public void add(Component c) {}     // 添加元素
    public void remove(Component c) {}   // 移除元素
    public Component getChild(int i){return null;} // 获取子节点
    public abstract void operation();           // 业务方法
}
