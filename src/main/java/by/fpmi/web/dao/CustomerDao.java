package by.fpmi.web.dao;

import by.fpmi.web.model.entity.Customer;

import java.util.Optional;

public interface CustomerDao {


    void changeMoney(long id, double delta) throws DaoException;

    long addCustomer(Customer current) throws DaoException;

    Optional<Customer> getById(long id) throws DaoException;
}
