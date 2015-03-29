package pl.szczawip.blablacar.repository.jdbc;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;
import pl.szczawip.blablacar.model.Ride;
import pl.szczawip.blablacar.repository.RideRepository;

import javax.sql.DataSource;
import java.util.List;

@Repository
public class JdbcRideRepositoryImpl implements RideRepository {

    private JdbcTemplate jdbcTemplate;

    @Autowired
    public JdbcRideRepositoryImpl(DataSource dataSource) {
        this.jdbcTemplate = new JdbcTemplate(dataSource);
    }


    @Override
    public List<Ride> findRides(String departureLocation, String arrivalLocation) {
        return null;
    }

    @Override
    public void save(Ride ride) {

    }

    @Override
    public List<Ride> findRides() {
        return null;
    }
}
