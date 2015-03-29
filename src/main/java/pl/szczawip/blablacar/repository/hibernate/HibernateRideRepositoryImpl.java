package pl.szczawip.blablacar.repository.hibernate;

import org.hibernate.Criteria;
import org.hibernate.SessionFactory;
import org.hibernate.criterion.Restrictions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import pl.szczawip.blablacar.model.Ride;
import pl.szczawip.blablacar.repository.RideRepository;

import java.util.List;


@Repository
public class HibernateRideRepositoryImpl implements RideRepository{


    @Autowired
    SessionFactory sessionFactory;


    @Override
    public List<Ride> findRides(String departureLocation, String arrivalLocation) {
        Criteria criteria = sessionFactory.getCurrentSession().createCriteria(Ride.class);
        criteria.add(Restrictions.eq("departureLocation", departureLocation));
        criteria.add(Restrictions.eq("arrivalLocation", arrivalLocation));
        return criteria.list();
    }

    @Override
    public void save(Ride ride) {
        sessionFactory.getCurrentSession().persist(ride);
    }

    @Override
    public List<Ride> findRides() {
        return sessionFactory.getCurrentSession().createCriteria(Ride.class).list();
    }
}
