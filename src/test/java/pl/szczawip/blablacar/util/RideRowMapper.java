package pl.szczawip.blablacar.util;


import org.springframework.jdbc.core.RowMapper;
import pl.szczawip.blablacar.domain.Ride;

import java.sql.ResultSet;
import java.sql.SQLException;

/**
 * Created by szczawip on 5/1/2015.
 */
public class RideRowMapper implements RowMapper<Ride>{
    @Override
    public Ride mapRow(final ResultSet resultSet, final int i) throws SQLException {
        Ride ride = new Ride();
        ride.setDepartureLocation(resultSet.getString("departurelocation"));
        ride.setDestinationLocation(resultSet.getString("destinationlocation"));
        ride.setDepartureTime(resultSet.getTimestamp(("departuretime")));
        return ride;
    }
}