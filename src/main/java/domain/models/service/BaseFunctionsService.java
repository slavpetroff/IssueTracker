package domain.models.service;

import domain.exception.EntityNotFoundException;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

/**
 * Created by slavpetroff on 8/13/16.
 */
@Service
@Transactional
public interface BaseFunctionsService<T>{

    T save(T entity);

    Iterable<T> save(Iterable<T> entities);

    T findOne(java.lang.String firstName) throws EntityNotFoundException;

    T findOne(java.lang.Long id);

    boolean exists(java.lang.Long id);

    Iterable<T> findAll();

    long count();

    void delete(T entity);

    void delete(Iterable<T> entities);

    void deleteAll();

    void delete(java.lang.Long id);

    Iterable<T> findAll(Iterable<Long> longs);
}
