package ml.zhannicholas.designpatterns.compositepattern;

// 叶子组件类
public class Leaf extends Component{
    @Override
    public void operation() {
        System.out.println("Performing operation defined in Leaf[" + this.hashCode() + "].");
    }
}
