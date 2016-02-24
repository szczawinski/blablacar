package pl.szczawip.blablacar.dao.hibernate;

import org.springframework.stereotype.Repository;
import pl.szczawip.blablacar.dao.DriverDao;
import pl.szczawip.blablacar.domain.Driver;


@Repository
public class HibernateDriverDao extends AbstractHibernateDao<Driver> implements DriverDao {


    @Override
    protected Class<Driver> getDomainClass() {
        return Driver.class;
    }
}
