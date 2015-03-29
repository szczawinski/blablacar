package pl.szczawip.blablacar.service;

import org.hibernate.tool.hbm2ddl.SchemaExport;
import org.joda.time.DateTime;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import pl.szczawip.blablacar.model.Ride;

import java.util.Collection;
import java.util.Date;



public abstract class AbstractBlaBlaServiceTests {

    @Autowired
    BlaBlaService service;


    @Test
    public void addRide() {
        //given
        Ride ride = createSimpleRide();
        //when
        service.saveRide(ride);
        Collection<Ride> rides = service.findRides("Łódź", "Gdańsk");
        //then
        Assert.assertEquals(1, rides.size());
        Ride ride1 = rides.iterator().next();
        Assert.assertEquals( ride1.getDepartureLocation(),"Łódź");
        Assert.assertEquals( ride1.getArrivalLocation(),"Gdańsk");
        Assert.assertEquals(ride1.getDepartureTime().getTime(), departureTime.getTime());
        Assert.assertEquals(ride1.getReturnTime(), null);
    }


    @Test
    public void findRides() {
        //given
        service.saveRide(new Ride("Łódź", "Warszawa", departureTime));
        service.saveRide(new Ride("Łódź", "Warszawa", departureTime));
        service.saveRide(new Ride("Łódź", "Kraków", departureTime));
        //when
        Collection<Ride> rides = service.findRides("Łódź", "Warszawa");
        //then
        Assert.assertEquals(2, rides.size());
    }

    @Test
    public void addRideWithReturnDate() {
        //given
        Ride ride = createSimpleRide();
        ride.setReturnTime(returnTime);
        //when
        service.saveRide(ride);
        Collection<Ride> rides = service.findRides("Łódź", "Gdańsk");
        //then
        Assert.assertEquals(1, rides.size());
        Ride ride1 = rides.iterator().next();
        Assert.assertEquals( ride1.getDepartureLocation(),"Łódź");
        Assert.assertEquals( ride1.getArrivalLocation(),"Gdańsk");
        Assert.assertTrue(ride1.getDepartureTime().getTime() == departureTime.getTime());
        Assert.assertTrue(ride1.getReturnTime().getTime() == returnTime.getTime());
    }


    private final Date departureTime = new DateTime(2015, 3, 17, 15, 30).toDate();
    private final Date returnTime  = new DateTime(2015, 3, 19, 16, 40).toDate();


    private Ride createSimpleRide(){
        return new Ride("Łódź", "Gdańsk", departureTime);
    }

    @Autowired
    SchemaExport schemaExport;

    @Before
    public void setup() {
        schemaExport.drop(true, true);
        schemaExport.create(true, true);
    }
}
