package pl.szczawip.blablacar.util;


import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import pl.szczawip.blablacar.config.Config;
import pl.szczawip.blablacar.domain.Driver;
import pl.szczawip.blablacar.domain.Ride;
import pl.szczawip.blablacar.service.impl.BlaBlaService;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(classes = {Config.class})
public class LocalhostPopulateDB {


    @Autowired
    BlaBlaService service;


    @Test
    public void loadData() throws Exception {
        Driver driver = new Driver();
        driver.setFirstName("Piotr");
        driver.setYearOfBirth(1988);
        service.saveDriver(driver);

        Driver driver2 = new Driver();
        driver2.setFirstName("Ula");
        driver2.setYearOfBirth(1992);
        service.saveDriver(driver2);

        Ride ride = new Ride();
        ride.setDriver(driver);
        service.saveRide(ride);

        Ride ride2 = new Ride();
        ride2.setDriver(driver2);
        service.saveRide(ride2);




    }
}
