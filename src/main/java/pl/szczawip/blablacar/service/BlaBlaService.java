package pl.szczawip.blablacar.service;

import java.util.List;

import pl.szczawip.blablacar.model.Driver;
import pl.szczawip.blablacar.model.Ride;

public interface BlaBlaService {

    List<Ride> findRides(String departureLocation, String arrivalLocation);

    List<Ride> findRides();

    void saveRide(Ride ride);

    void saveDriver(Driver driver);
}
