package by.fpmi.web.dao.mapper;

import by.fpmi.web.dao.RowMapper;
import by.fpmi.web.model.entity.Customer;

import java.sql.ResultSet;
import java.sql.SQLException;

public class CustomerRowMapper implements RowMapper<Customer> {
    private static final String ID = "ID";
    private static final String NAME = "Name";
    public static final String SURNAME = "Surname";
    public static final String MONEY = "Money";

    @Override
    public Customer map(ResultSet resultSet) throws SQLException {
        long id = resultSet.getLong(ID);
        String name = resultSet.getString(NAME);
        String surname = resultSet.getString(SURNAME);
        double money = resultSet.getDouble(MONEY);
        return new Customer(id, name, surname, money);
    }
}
