package pl.szczawip.blablacar.dao.hibernate;

import org.hibernate.Criteria;
import org.hibernate.SessionFactory;
import org.hibernate.criterion.Restrictions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import pl.szczawip.blablacar.domain.Ride;
import pl.szczawip.blablacar.dao.RideDao;

import java.util.List;


@Repository
public class HibernateRideDo extends AbstractHibernateDao<Ride> implements RideDao {

    @Autowired
    SessionFactory sessionFactory;

    @Override
    protected Class<Ride> getDomainClass() {
        return Ride.class;
    }

    @Override
    public List<Ride> getAll(String departureLocation, String destinationLocation) {
        Criteria criteria = sessionFactory.getCurrentSession().createCriteria(Ride.class);
        criteria.add(Restrictions.eq("departureLocation", departureLocation));
        criteria.add(Restrictions.eq("destinationLocation", destinationLocation));
        return criteria.list();
    }
}
