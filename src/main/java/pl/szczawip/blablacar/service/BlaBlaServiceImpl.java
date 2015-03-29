package pl.szczawip.blablacar.service;


import org.springframework.beans.factory.annotation.Autowired;
import pl.szczawip.blablacar.model.Ride;
import pl.szczawip.blablacar.repository.RideRepository;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import java.util.List;

@Service
public class BlaBlaServiceImpl implements BlaBlaService{

    @Autowired
    private RideRepository rideRepository;

    @Override
    @Transactional(readOnly = true)
    public List<Ride> findRides(String departureLocation, String arrivalLocation) {
        return rideRepository.findRides(departureLocation, arrivalLocation);
    }

    @Override
    @Transactional(readOnly = true)
    public List<Ride> findRides() {
        return rideRepository.findRides();
    }


    @Override
    @Transactional
    public void saveRide(Ride ride) {
        rideRepository.save(ride);
    }

}
