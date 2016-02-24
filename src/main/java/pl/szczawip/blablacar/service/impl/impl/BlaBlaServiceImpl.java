package pl.szczawip.blablacar.service.impl.impl;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;
import pl.szczawip.blablacar.domain.Driver;
import pl.szczawip.blablacar.domain.Ride;
import pl.szczawip.blablacar.dao.DriverDao;
import pl.szczawip.blablacar.dao.RideDao;

import org.springframework.stereotype.Service;
import pl.szczawip.blablacar.service.impl.BlaBlaService;

import java.util.List;

@Service
public class BlaBlaServiceImpl implements BlaBlaService {

    @Autowired
    private RideDao rideDao;

    @Autowired
    private DriverDao driverDao;


    @Override
    @Transactional(readOnly = true)
    public List<Ride> findRides(String departureLocation, String arrivalLocation) {
        return rideDao.getAll(departureLocation, arrivalLocation);
    }

    @Override
    @Transactional(readOnly = true)
    public List<Ride> findRides() {
        return rideDao.getAll();
    }


    @Override
    @Transactional
    public void saveRide(Ride ride) {
        rideDao.insert(ride);
    }

    @Override
    @Transactional
    public void saveDriver(final Driver driver) {
        driverDao.insert(driver);

    }

    @Override
    public List<Driver> findDrivers() {
        return driverDao.getAll();
    }

}
