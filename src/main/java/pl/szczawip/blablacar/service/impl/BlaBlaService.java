package pl.szczawip.blablacar.service.impl;

import java.util.List;

import pl.szczawip.blablacar.domain.Driver;
import pl.szczawip.blablacar.domain.Ride;

public interface BlaBlaService {

    List<Ride> findRides(String departureLocation, String arrivalLocation);

    List<Ride> findRides();

    void saveRide(Ride ride);

    void saveDriver(Driver driver);

    List<Driver> findDrivers();
}
