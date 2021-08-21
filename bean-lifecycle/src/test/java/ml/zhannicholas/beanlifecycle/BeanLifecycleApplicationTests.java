package ml.zhannicholas.beanlifecycle;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
class BeanLifecycleApplicationTests {

    @Autowired
    private MySpringBean mySpringBean;

    @Test
    void testMySpringBeanLifecycle() {
        mySpringBean.hello();
    }

}
