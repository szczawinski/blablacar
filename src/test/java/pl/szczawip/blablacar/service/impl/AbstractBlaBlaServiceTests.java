package pl.szczawip.blablacar.service.impl;


import org.junit.Before;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.transaction.annotation.Transactional;
import pl.szczawip.blablacar.domain.Driver;
import pl.szczawip.blablacar.domain.Ride;
import pl.szczawip.blablacar.util.DriverRowMapper;
import pl.szczawip.blablacar.util.RideRowMapper;

import javax.sql.DataSource;
import java.util.Date;
import java.util.List;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;


public abstract class AbstractBlaBlaServiceTests {

    private final Date departureTime =  new Date();

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
        assertEquals("Incorrect number of rides returned.", 1, rides.size());
        final Ride ride = rides.get(0);
        assertEquals("Incorrect field of ride: Departure Location", "Lodz", ride.getDepartureLocation());
        assertEquals("Incorrect field of ride: Destination Location", "Gdansk", ride.getDestinationLocation());
        assertEquals("Incorrect field of ride: Departure Time", departureTime ,ride.getDepartureTime());
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
        final List<Ride> rides2 = service.findRides("Krakow", "Lodz");
        //then
        assertEquals("Incorrect number of rides returned.",1, rides2.size());
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
        final List<Driver> drivers = jdbcTemplate.query("SELECT * FROM driver;", new DriverRowMapper());
        assertEquals("Incorrect number of rides returned.", 1, drivers.size());
        final Driver driver2 = drivers.get(0);
        assertEquals("Incorrect field of driver: First Name", "Piotr", driver2.getFirstName());
        assertEquals("Incorrect field of driver: Last Name", "Szczawinski", driver2.getLastName());
        assertEquals("Incorrect field of driver: Email", "piotrSzczawinski@gmail.com" , driver2.getEmail());
        assertEquals("Incorrect field of driver: Password", "password" , driver2.getPassword());
        assertEquals("Incorrect field of driver: year of birth", 1988 , driver2.getYearOfBirth());
    }

    @Test
    @Transactional
    public void addRideWithDriverInfo() {
        //given
        final Driver newDriver = new Driver();
        newDriver.setFirstName("Piotr");
        newDriver.setLastName("Szczawinski");
        newDriver.setYearOfBirth(1988);
        service.saveDriver(newDriver);

        final Ride newRide = new Ride();
        newRide.setDepartureLocation("Lodz");
        newRide.setDestinationLocation("Gdansk");
        newRide.setDepartureTime(departureTime);
        newRide.setDriver(newDriver);
        //when
        service.saveRide(newRide);
        //then
        final List<Ride> rides = service.findRides();
        assertEquals("Incorrect number of rides returned.",1, rides.size());
        final Ride ride = rides.get(0);
        assertEquals("Incorrect field of ride: Departure Location", "Lodz", ride.getDepartureLocation());
        assertEquals("Incorrect field of ride: Destination Location", "Gdansk", ride.getDestinationLocation());
        assertEquals("Incorrect field of ride: Departure Time", departureTime, ride.getDepartureTime());
        final Driver driver = ride.getDriver();
        assertNotNull("Field Driver of object ride cannot be null", driver);
        assertEquals("Incorrect field of driver: First Name", "Piotr", driver.getFirstName());
        assertEquals("Incorrect field of driver: Last Name", "Szczawinski", driver.getLastName());
        assertEquals("Incorrect field of driver: Year of Birth", 1988, driver.getYearOfBirth());
        //then
        List<Driver> drivers  = service.findDrivers();
        assertEquals("Incorrect number of drivers returned.",1, drivers.size());
        final Driver driver1 = drivers.get(0);
        assertEquals("Incorrect field of driver: First Name", "Piotr", driver1.getFirstName());
        assertEquals("Incorrect field of driver: Last Name", "Szczawinski", driver1.getLastName());
        assertEquals("Incorrect field of driver: Year of Birth", 1988, driver1.getYearOfBirth());
    }
}
