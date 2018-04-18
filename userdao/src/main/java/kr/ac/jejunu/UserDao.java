package kr.ac.jejunu;

import javax.sql.DataSource;
import java.sql.*;

public class UserDao {
    private final JdbcContext jdbcContext = new JdbcContext(this);

    public UserDao(DataSource dataSource) {
        this.dataSource = dataSource;
    }

    public User get(int id) throws SQLException {
            StatementStrategy statementStrategy = new GetUserStatementStrategy(id);
        return jdbcContext.jdbcContextForGet(statementStrategy);
    }

    public Integer insert(User user) throws SQLException{
            StatementStrategy statementStrategy = new InsertUserStatementStrategy(user);
        return jdbcContext.jdbcContextForInsert(statementStrategy);
    }

    public void update(User user) throws SQLException{
        StatementStrategy statementStrategy = new UpdateUserstStatementStrategy(user);

        jdbcContext.jdbcContextForUpdate(statementStrategy);
    }

    public void delete(Integer id) throws SQLException {
        StatementStrategy statementStrategy = new DeleteUserStatementStrategy(id);

        jdbcContext.jdbcContextForUpdate(statementStrategy);
    }
}
