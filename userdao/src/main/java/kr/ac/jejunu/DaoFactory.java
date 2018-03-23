package kr.ac.jejunu;

public class DaoFactory {

    public UserDao getUserDao() {
        return new UserDao(new JejuConnectionMaker());
    }

    public ConnectionMaker getConnectionMaker(){
        return new JejuConnectionMaker();
    }

}