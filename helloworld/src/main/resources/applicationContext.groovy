import kr.ac.jejunu.hello.Hello
import kr.ac.jejunu.hello.HelloImpl
import kr.ac.jejunu.hello.HelloPerson

beans {
    hello(HelloImpl) {
    }
    
    /construct injection/
    helloPerson(HelloPerson, name) {
        name = 'name'
    }
}