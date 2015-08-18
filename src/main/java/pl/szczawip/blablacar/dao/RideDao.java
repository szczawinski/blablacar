package pl.szczawip.blablacar.dao;

import pl.szczawip.blablacar.model.Ride;

import java.util.List;


public interface RideDao extends AbstractDao<Ride> {

    List<Ride> getAll(String departureLocation, String arrivalLocation);
}
