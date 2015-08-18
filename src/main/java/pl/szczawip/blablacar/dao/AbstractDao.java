package pl.szczawip.blablacar.dao;

import java.util.List;

public interface AbstractDao<T> {

    T insert(T entity);

    T get(long id);

    T update(T entity);

    void delete(T entity);

    List<T> getAll();

    void delete(long id);
}
