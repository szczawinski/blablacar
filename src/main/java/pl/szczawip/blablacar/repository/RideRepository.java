package pl.szczawip.blablacar.repository;

import pl.szczawip.blablacar.model.Ride;

import java.util.List;

/**
 * Created by szczawip on 3/25/2015.
 */
public interface RideRepository {

    List<Ride> findRides(String departureLocation, String arrivalLocation);

    void save(Ride ride);

    List<Ride> findRides();

}
