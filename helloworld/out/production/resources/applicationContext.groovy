import kr.ac.jejunu.hello.Hello
import kr.ac.jejunu.hello.HelloImpl
import kr.ac.jejunu.hello.HelloPerson

beans {
    hello(HelloImpl) {
    }
    helloPerson(HelloPerson) {
        hello = hello
        name = 'name'
    }
}