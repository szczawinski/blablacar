package pl.szczawip.blablacar.repository.hibernate;

import org.hibernate.Criteria;
import org.hibernate.SessionFactory;
import org.hibernate.criterion.Restrictions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import pl.szczawip.blablacar.model.Driver;
import pl.szczawip.blablacar.model.Ride;
import pl.szczawip.blablacar.repository.DriverRepository;
import pl.szczawip.blablacar.repository.RideRepository;

import java.util.List;


@Repository
public class HibernateDriverRepository implements DriverRepository{


    @Autowired
    SessionFactory sessionFactory;


    @Override
    public void save(Driver driver) {
        sessionFactory.getCurrentSession().persist(driver);
    }


}
