package kr.ac.jejunu.hello;

import lombok.Data;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

@Data
@Component  //빈 자동 정의됨
public class HelloPerson implements Hello {
    @Value("name")
    private String name;
    @Autowired   //의존성 주입
    private Hello hello;

    @Override
    public String sayHello() {
        return hello.sayHello() + " " + name;
    }
}
