package pl.szczawip.blablacar.service;

import pl.szczawip.blablacar.model.Ride;

import java.util.Collection;
import java.util.List;

/**
 * Created by szczawip on 3/26/2015.
 */
public interface BlaBlaService {

    List<Ride> findRides(String departureLocation, String arrivalLocation);

    List<Ride> findRides();

    void saveRide(Ride ride);
}
