package pl.szczawip.blablacar.dao.hibernate;

import org.hibernate.Query;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import pl.szczawip.blablacar.dao.AbstractDao;

import java.util.List;

public abstract class AbstractHibernateDao<T> implements AbstractDao<T> {

    @Autowired
    private SessionFactory sessionFactory;

    protected abstract Class<T> getDomainClass();

    @Override
    public T insert(T entity) {
        sessionFactory.getCurrentSession().save(entity);
        return entity;
    }

    @Override
    public T get(long id) {
        final Class<T> clazz = getDomainClass();
        return (T) sessionFactory.getCurrentSession().get(clazz, id);
    }

    @Override
    public T update(T entity) {
        sessionFactory.getCurrentSession().update(entity);
        return entity;
    }

    @Override
    public void delete(T entity) {
        sessionFactory.getCurrentSession().delete(entity);
    }

    @Override
    public List<T> getAll() {
        final Class<T> clazz = getDomainClass();
        Query query = sessionFactory.getCurrentSession().createQuery("from " + clazz.getName());
        return query.list();
    }

    @Override
    public void delete(long id) {
        sessionFactory.getCurrentSession().delete(this.get(id));
    }
}
