package pl.szczawip.blablacar.service;

import org.joda.time.DateTime;
import org.junit.Before;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import pl.szczawip.blablacar.util.RideRowMapper;
import pl.szczawip.blablacar.model.Driver;
import pl.szczawip.blablacar.model.Ride;

import javax.sql.DataSource;
import javax.transaction.Transactional;
import java.util.Collection;
import java.util.Date;
import java.util.List;

import static org.junit.Assert.*;


public abstract class AbstractBlaBlaServiceTests {

    private final Date departureTime = new DateTime(2015, 3, 17, 15, 30).toDate();
    private final Date returnTime = new DateTime(2015, 3, 19, 16, 40).toDate();


    @Autowired
    BlaBlaService service;

    @Autowired
    DataSource dataSource;

    JdbcTemplate jdbcTemplate;


    @Before
    public void setupJdbcTemplate() {
        jdbcTemplate = new JdbcTemplate(dataSource);
    }


    @Test
    @Transactional
    public void addNewRide() {
        //given
        final Ride newRide = new Ride();
        newRide.setDepartureLocation("Lodz");
        newRide.setDestinationLocation("Gdansk");
        newRide.setDepartureTime(departureTime);
        //when
        service.saveRide(newRide);
        //then
        final List<Ride> rides = jdbcTemplate.query("SELECT * FROM ride;", new RideRowMapper());
        assertEquals("Incorrect number of rides returned.",1, rides.size());
        final Ride ride = rides.get(0);
        assertEquals("Incorrect field of ride: Departure Location", "Lodz", ride.getDepartureLocation());
        assertEquals("Incorrect field of ride: Destination Location", "Gdansk", ride.getDestinationLocation());
        assertEquals("Incorrect field of ride: Departure Time", departureTime.getTime() ,ride.getDepartureTime().getTime() );
    }


    @Test
    @Transactional
    public void findAllRides() {
        //given
        jdbcTemplate.update("INSERT INTO ride(id, destinationlocation, departurelocation, departuretime)  VALUES (1, 'Warszawa', 'Lodz' , '2015-03-17 15:30:00');");
        jdbcTemplate.update("INSERT INTO ride(id, destinationlocation, departurelocation, departuretime)  VALUES (2, 'Warszawa', 'Lodz' , '2015-03-17 15:30:00');");
        jdbcTemplate.update("INSERT INTO ride(id, destinationlocation, departurelocation, departuretime)  VALUES (3, 'Krakow', 'Lodz' , '2015-03-17 15:30:00');");
        //when
        final List<Ride> rides = service.findRides();
        //then
        assertEquals("Incorrect number of rides returned.",3, rides.size());
    }

    @Test
    @Transactional
    public void findRidesByDepartureAndDestinationLocations() {
        //given
        jdbcTemplate.update("INSERT INTO ride(id, departurelocation, destinationlocation,  departuretime)  VALUES (1, 'Warszawa', 'Lodz' , '2015-03-17 15:30:00');");
        jdbcTemplate.update("INSERT INTO ride(id, departurelocation, destinationlocation,  departuretime)  VALUES (2, 'Warszawa', 'Lodz' , '2015-03-17 15:30:00');");
        jdbcTemplate.update("INSERT INTO ride(id, departurelocation, destinationlocation,  departuretime)  VALUES (3, 'Krakow', 'Lodz'   , '2015-03-17 15:30:00');");
        //when
        final List<Ride> rides = service.findRides("Warszawa", "Lodz");
        //then
        assertEquals("Incorrect number of rides returned.",2, rides.size());
    }

    @Test
    @Transactional
    public void addRideWithReturnDate() {
        //given
        final Ride newRide = new Ride();
        newRide.setDepartureLocation("Lodz");
        newRide.setDestinationLocation("Gdansk");
        newRide.setDepartureTime(departureTime);
        newRide.setReturnTime(returnTime);
        //when
        service.saveRide(newRide);
        final List<Ride> rides = service.findRides("Lodz", "Gdansk");
        //then
        assertEquals("Incorrect number of rides returned.",1, rides.size());
        final Ride ride = rides.get(0);
        assertEquals("Incorrect field of ride: Departure Location", "Lodz", ride.getDepartureLocation());
        assertEquals("Incorrect field of ride: Destination Location", "Gdansk", ride.getDestinationLocation());
        assertEquals("Incorrect field of ride: Departure Time", departureTime.getTime(), ride.getDepartureTime().getTime());
        assertEquals("Incorrect field of ride: Return Time", returnTime.getTime(), ride.getReturnTime().getTime());
    }

    @Test
    @Transactional
    public void addNewDriver() {
        //given
        Driver  driver = new Driver();
        driver.setFirstName("Piotr");
        driver.setLastName("Szczawinski");
        driver.setEmail("piotrSzczawinski@gmail.com");
        driver.setPassword("password");
        driver.setYearOfBirth(1988);
        //when
        service.saveDriver(driver);
        //then
        final List<Ride> rides = jdbcTemplate.query("SELECT * FROM driver;", new RideRowMapper());
        assertEquals("Incorrect number of rides returned.",1, rides.size());
        final Ride ride = rides.get(0);
        assertEquals("Incorrect field of ride: Departure Location", "Lodz", ride.getDepartureLocation());
        assertEquals("Incorrect field of ride: Destination Location", "Gdansk", ride.getDestinationLocation());
        assertEquals("Incorrect field of ride: Departure Time", departureTime.getTime() ,ride.getDepartureTime().getTime() );
    }






    @Test
    @Transactional
    public void addRideWithDriverInfo() {
        //given
        final Driver newDriver = new Driver();
        newDriver.setFirstName("Piotr");
        newDriver.setLastName("Szczawinski");
        newDriver.setYearOfBirth(1988);

        final Ride newRide = new Ride();
        newRide.setDepartureLocation("Lodz");
        newRide.setDestinationLocation("Gdansk");
        newRide.setDepartureTime(departureTime);
        newRide.setDriver(newDriver);
        //when
        service.saveDriver(newDriver);
        service.saveRide(newRide);
        //then
        final List<Ride> rides = service.findRides();
        assertEquals("Incorrect number of rides returned.",1, rides.size());
        final Ride ride = rides.get(0);
        assertEquals("Incorrect field of ride: Departure Location", "Lodz", ride.getDepartureLocation());
        assertEquals("Incorrect field of ride: Destination Location", "Gdansk", ride.getDestinationLocation());
        assertEquals("Incorrect field of ride: Departure Time", departureTime.getTime(), ride.getDepartureTime().getTime());
        final Driver driver = ride.getDriver();
        assertNotNull("Field Driver of object ride cannot be null", driver);
        assertEquals("Incorrect field of driver: First Name", "Piotr", driver.getFirstName());
        assertEquals("Incorrect field of driver: Last Name", "Szczawinski", driver.getLastName());
        assertEquals("Incorrect field of driver: Year of Birth", 1988, driver.getYearOfBirth());

    }
}
