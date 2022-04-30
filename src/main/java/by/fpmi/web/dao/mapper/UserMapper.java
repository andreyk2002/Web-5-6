package by.fpmi.web.dao.mapper;

import by.fpmi.web.dao.RowMapper;
import by.fpmi.web.model.entity.User;
import by.fpmi.web.model.entity.UserRole;

import java.sql.ResultSet;
import java.sql.SQLException;

public class UserMapper implements RowMapper<User> {

    public static final String ROLE = "role";
    public static final String USERNAME = "name";
    public static final String ID = "id";

    @Override
    public User map(ResultSet resultSet) throws SQLException {
        long id = resultSet.getLong(ID);
        String username = resultSet.getString(USERNAME);
        String userRole = resultSet.getString(ROLE);
        return new User(id, username, "*********", UserRole.valueOf(userRole));
    }
}
