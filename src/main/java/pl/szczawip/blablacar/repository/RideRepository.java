package pl.szczawip.blablacar.repository;

import pl.szczawip.blablacar.model.Ride;

import java.util.List;


public interface RideRepository {

    List<Ride> findRides(String departureLocation, String arrivalLocation);

    List<Ride> findRides();

    void save(Ride ride);



}
