package kr.ac.jejunu.hello;

import lombok.Data;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

@Data
@Component  //빈 자동 정의됨
@RequiredArgsConstructor //final 필드만 construct 해줌
public class HelloPerson implements Hello {
    @Value("name")
    private String name;
    private final Hello hello;


    @Override
    public String sayHello() {
        return hello.sayHello() + " " + name;
    }
}
