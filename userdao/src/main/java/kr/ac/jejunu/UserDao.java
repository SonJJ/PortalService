package kr.ac.jejunu;

import java.sql.*;

public class UserDao {
    public User get(int id) throws SQLException, ClassNotFoundException{
    
        //mysql driver load
        //sql 작성하고
        //sql 실행하고
        //결과를 User 에 매핑하고
        //자원을 해지하고
        //결과를 리턴한다.
        Connection connection = getConnection();
        PreparedStatement preparedStatement =
                connection.prepareStatement("SELECT * FROM userinfo WHERE id = ?");
        preparedStatement.setInt(1, id);
        ResultSet resultSet = preparedStatement.executeQuery();
        resultSet.next();
        User user = new User();
        user.setId(resultSet.getInt("id"));
        user.setName(resultSet.getString("name"));
        user.setPassword(resultSet.getString("password"));
        resultSet.close();
        preparedStatement.close();
        connection.close();

        return user;
    }

    public Integer insert(User user) throws SQLException, ClassNotFoundException {
        Connection connection = getConnection();
        PreparedStatement preparedStatement =
                connection.prepareStatement("INSERT INTO userinfo(name, password)" +
                        "VALUES (?, ?)");
        preparedStatement.setString(1, user.getName());
        preparedStatement.setString(2, user.getPassword());
        preparedStatement.executeUpdate();

        preparedStatement = connection.prepareStatement(
                "SELECT last_insert_id()");
        ResultSet resultSet = preparedStatement.executeQuery();
        resultSet.next();

        Integer id = resultSet.getInt(1);
        resultSet.close();
        preparedStatement.close();
        connection.close();

        return id;
    }

    private Connection getConnection() throws ClassNotFoundException, SQLException {
        Class.forName("com.mysql.jdbc.Driver");
        return DriverManager.getConnection(
                "jdbc:mysql://localhost/jeju?characterEncoding=utf-8",
                "root", "root12345");
    }
}
