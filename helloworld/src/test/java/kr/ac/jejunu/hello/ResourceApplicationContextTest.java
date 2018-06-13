package kr.ac.jejunu.hello;

import static org.hamcrest.CoreMatchers.*;
import static org.hamcrest.MatcherAssert.*;

import org.junit.Test;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.context.support.GenericGroovyApplicationContext;

public class ResourceApplicationContextTest {

    //bean 정의가 xml에 존재
    @Test
    public void classpathXmlApplicationContextTest() {
        ClassPathXmlApplicationContext applicationContext = new ClassPathXmlApplicationContext("applicationContext.xml");
        Hello hello = applicationContext.getBean("helloPerson", Hello.class);
        assertThat(hello.sayHello(), is("Hello!!! name"));
    }

    @Test
    public void groovyApplicationContextTest(){
        GenericGroovyApplicationContext applicationContext = new GenericGroovyApplicationContext("applicationContext.groovy");
        Hello hello = applicationContext.getBean("helloPerson", Hello.class);
        assertThat(hello.sayHello(), is("Hello!!! name"));
    }
}
