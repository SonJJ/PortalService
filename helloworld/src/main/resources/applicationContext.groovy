import kr.ac.jejunu.hello.Hello
import kr.ac.jejunu.hello.HelloImpl
import kr.ac.jejunu.hello.HelloPerson

beans {
    hello(HelloImpl) {
    }
    helloPerson(HelloPerson, name) {
        name = '홍길동'
    }
}