package ml.zhannicholas.beanlifecycle;

import org.springframework.beans.BeansException;
import org.springframework.beans.factory.*;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationContextAware;

import javax.annotation.PostConstruct;
import javax.annotation.PreDestroy;

public class MySpringBean implements ApplicationContextAware, BeanNameAware,
        BeanClassLoaderAware, BeanFactoryAware, InitializingBean, DisposableBean {

    @Override
    public void setBeanClassLoader(ClassLoader classLoader) {
        System.out.println("Executing setBeanClassLoader...");
    }

    @Override
    public void setBeanFactory(BeanFactory beanFactory) throws BeansException {
        System.out.println("Executing setBeanFactory...");
    }

    @Override
    public void setBeanName(String s) {
        System.out.println("Executing setBeanName...");
    }

    @Override
    public void destroy() throws Exception {
        System.out.println("Executing destroy...");
    }

    @Override
    public void afterPropertiesSet() throws Exception {
        System.out.println("Executing afterPropertiesSet...");
    }

    @Override
    public void setApplicationContext(ApplicationContext applicationContext) throws BeansException {
        System.out.println("Executing setApplicationContext...");
    }

    @PostConstruct
    public void postConstruct() {
        System.out.println("Executing @PostConstruct...");
    }

    @PreDestroy
    public void preDestroy() {
        System.out.println("Executing @PreDestroy...");
    }

    public void customInitMethod() {
        System.out.println("Executing custom init method...");
    }

    public void customDestroyMethod() {
        System.out.println("Executing custom destroy method...");
    }

    public void hello() {
        System.out.println("Hello, Spring!");
    }
}
