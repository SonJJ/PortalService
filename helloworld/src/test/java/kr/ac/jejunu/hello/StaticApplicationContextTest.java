package kr.ac.jejunu.hello;

import static org.hamcrest.CoreMatchers.*;

import static org.hamcrest.MatcherAssert.*;
import org.junit.Test;
import org.springframework.context.support.StaticApplicationContext;

public class StaticApplicationContextTest {
    //코드상에서 빈을 관리 목적으로 많이 사용
    //직접 등록해서 관리한다. 복잡. 테스트위해.
    @Test
    public void staticApplicationContextTest(){
        StaticApplicationContext applicationContext = new StaticApplicationContext();
        applicationContext.registerSingleton("hello", HelloImpl.class);
        Hello hello = applicationContext.getBean("hello", Hello.class);
        assertThat(hello.sayHello(), is("Hello~!!!"));
    }
}
