package ml.zhannicholas.beanlifecycle;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class MyLifeCycleConfiguration {
    @Bean
    public MyBeanPostProcessor myBeanPostProcessor() {
        return new MyBeanPostProcessor();
    }

    @Bean
    public MyInstantiationAwareBeanPostProcessor myInstantiationAwareBeanPostProcessor() {
        return new MyInstantiationAwareBeanPostProcessor();
    }

    @Bean(initMethod = "customInitMethod", destroyMethod = "customDestroyMethod")
    public MySpringBean mySpringBean() {
        return new MySpringBean();
    }
}
