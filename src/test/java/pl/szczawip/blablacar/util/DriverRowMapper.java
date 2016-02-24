package pl.szczawip.blablacar.util;


import org.springframework.jdbc.core.RowMapper;
import pl.szczawip.blablacar.domain.Driver;

import java.sql.ResultSet;
import java.sql.SQLException;


public class DriverRowMapper implements RowMapper<Driver>{
    @Override
    public Driver mapRow(final ResultSet resultSet, final int i) throws SQLException {

        final Driver driver = new Driver();
        driver.setId(resultSet.getLong("id"));
        driver.setFirstName(resultSet.getString("firstName"));
        driver.setLastName(resultSet.getString("lastName"));
        driver.setEmail(resultSet.getString("email"));
        driver.setPassword(resultSet.getString("password"));
        driver.setYearOfBirth(resultSet.getInt("yearOfBirth"));
        return driver;
    }
}