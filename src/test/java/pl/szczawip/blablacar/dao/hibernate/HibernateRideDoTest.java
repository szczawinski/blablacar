package pl.szczawip.blablacar.dao.hibernate;


import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.AbstractTransactionalJUnit4SpringContextTests;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import pl.szczawip.blablacar.config.Config;
import pl.szczawip.blablacar.config.TestProperties;
import pl.szczawip.blablacar.dao.RideDao;
import pl.szczawip.blablacar.model.Ride;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertNull;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(classes = {Config.class, TestProperties.class})
public class HibernateRideDoTest  extends AbstractTransactionalJUnit4SpringContextTests {


    @Autowired
    private RideDao fixture;

    @Test
    public void setIdWhenInsertRide()  {
        //given
        final Ride ride = new Ride();
        //when
        final Ride inserted = fixture.insert(ride);
        //then
        assertNotNull(inserted);
        assertNotNull(inserted.getId());
    }

    @Test
    public void retrievedInsertedRide()  {
        //given
        final Ride ride = new Ride();
        ride.setDepartureLocation("Lodz");
        final Ride inserted = fixture.insert(ride);
        //when
        final Ride retrieved = fixture.get(inserted.getId());
        //then
        assertEquals("Lodz", retrieved.getDepartureLocation());
    }

    @Test
    public void updateInsertedRide()  {
        //given
        final Ride ride = new Ride();
        ride.setDepartureLocation("Lodz");
        final Ride inserted = fixture.insert(ride);
        final Ride retrieved = fixture.get(inserted.getId());
        //when
        retrieved.setDepartureLocation("Warszawa");
        fixture.update(retrieved);
        //then
        final Ride updated = fixture.get(inserted.getId());
        assertEquals("Warszawa", updated.getDepartureLocation());
    }

    @Test
    public void deleteInsertedRide()  {
        //given
        final Ride ride = new Ride();

        final Ride inserted = fixture.insert(ride);
        final Ride retrieved = fixture.get(inserted.getId());
        //when
        fixture.delete(retrieved.getId());
        //then
        final Ride deleted = fixture.get(retrieved.getId());
        assertNull(deleted);
    }
}