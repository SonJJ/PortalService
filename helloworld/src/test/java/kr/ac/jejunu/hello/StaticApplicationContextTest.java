package kr.ac.jejunu.hello;

import static org.hamcrest.CoreMatchers.*;
import static org.hamcrest.MatcherAssert.*;
import org.junit.Test;
import org.springframework.beans.factory.config.BeanDefinition;
import org.springframework.beans.factory.config.RuntimeBeanReference;
import org.springframework.beans.factory.support.RootBeanDefinition;
import org.springframework.context.support.StaticApplicationContext;

public class StaticApplicationContextTest {
    //코드상에서 빈을 관리 목적으로 많이 사용.
    //직접 등록해서 관리한다. 복잡. 테스트위해.

    @Test
    public void staticApplicationContextTest(){
        StaticApplicationContext applicationContext = new StaticApplicationContext();
        applicationContext.registerSingleton("hello", HelloImpl.class);
        Hello hello = applicationContext.getBean("hello", Hello.class);
        assertThat(hello.sayHello(), is("Hello!!!"));
    }

    //bean정의를 다 코드로함
    @Test
    public void staticApplicationContextWithDI(){
        StaticApplicationContext applicationContext = new StaticApplicationContext();
        applicationContext.registerSingleton("hello", HelloImpl.class);
        BeanDefinition beanDefinition = new RootBeanDefinition(HelloPerson.class);
        beanDefinition.getPropertyValues().addPropertyValue("name", "홍길동");
        beanDefinition.getPropertyValues().addPropertyValue("hello", new RuntimeBeanReference("hello"));
        applicationContext.registerBeanDefinition("helloPerson", beanDefinition);
        Hello hello = applicationContext.getBean("helloPerson", Hello.class);
        assertThat(hello.sayHello(), is("Hello!!! 홍길동"));
    }
}
