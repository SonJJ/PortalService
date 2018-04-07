package kr.ac.jejunu;

import static org.hamcrest.CoreMatchers.*;
import static org.hamcrest.MatcherAssert.*;

import org.junit.Before;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.support.GenericXmlApplicationContext;

import java.sql.SQLException;


public class UserDaoTest {

    private UserDao userDao;
//    private DaoFactory daoFactory;

    @Before
    public void setup(){
        ApplicationContext applicationContext = new AnnotationConfigApplicationContext(DaoFactory.class);
//        ApplicationContext applicationContext = new GenericXmlApplicationContext("classpath:daoFactory.xml");
        userDao = applicationContext.getBean("userDao", UserDao.class);
    }

    @Test
    public void get() throws SQLException, ClassNotFoundException {
        int id = 1;

        User user = userDao.get(id);
        assertThat(user.getId(), is(1));
        assertThat(user.getName(), is("허윤호"));
        assertThat(user.getPassword(), is("1234"));
    }

    @Test
    public void add() throws SQLException, ClassNotFoundException{
        User user = new User();
        user.setName("헐크");
        user.setPassword("1111");
        Integer id = userDao.insert(user);

        User insertedUser = userDao.get(id);
        assertThat(insertedUser.getId(), is(id));
        assertThat(insertedUser.getName(), is(user.getName()));
        assertThat(insertedUser.getPassword(), is(user.getPassword()));
    }

    @Test
    public void update() throws SQLException, ClassNotFoundException{
        User user = new User();
        Integer id = insertUserTest(user);

        user.setId(id);
        user.setName("헐크");
        user.setPassword("1111");

        User updateUser = userDao.get(id);

        assertThat(updateUser.getId(), is(id));
        assertThat(updateUser.getName(), is(user.getName()));
        assertThat(updateUser.getPassword(), is(user.getPassword()));
    }
    private Integer insertUserTest(User user) throws SQLException, ClassNotFoundException {
        user.setName("헐크");
        user.setPassword("1111");
        return userDao.insert(user);
    }


}