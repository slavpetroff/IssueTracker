package domain.models.service;

import domain.exception.EntityNotFoundException;
import domain.models.entity.Type;
import domain.models.repository.TypeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Optional;
import java.util.stream.StreamSupport;

/**
 * Created by slavpetroff on 8/8/16.
 */
@Service
@Transactional
public class TypeServiceImpl implements TypeService {

    private final TypeRepository typeRepository;

    @Autowired
    public TypeServiceImpl(
            TypeRepository typeRepository) {
        this.typeRepository = typeRepository;
    }

    @Override
    public Type save(Type entity) {
        return typeRepository.save(entity);
    }

    @Override
    public Iterable<Type> save(Iterable<Type> entities) {
        return typeRepository.save(entities);
    }

    @Override
    public Type findOne(String name) throws EntityNotFoundException {
        Optional<Type> optType = StreamSupport
                .stream(typeRepository.findAll().spliterator(), false)
                .filter(type -> type.getName().equalsIgnoreCase(name))
                .findFirst();

        if (optType.isPresent()) {
            throw new EntityNotFoundException(String.format("Could not find entity AppState - name:%s", name));
        }

        return optType.get();
    }

    @Override
    public Type findOne(Long id) {
        return this.typeRepository.findOne(id);
    }

    @Override
    public boolean exists(Long id) {
        return this.typeRepository.exists(id);
    }

    @Override
    public Iterable<Type> findAll() {
        return this.typeRepository.findAll();
    }

    @Override
    public long count() {
        return this.typeRepository.count();
    }

    @Override
    public void delete(Type entity) {
        this.typeRepository.delete(entity);
    }

    @Override
    public void delete(Iterable<Type> entities) {
        this.typeRepository.delete(entities);
    }

    @Override
    public void deleteAll() {
        this.typeRepository.deleteAll();
    }

    @Override
    public void delete(Long id) {
        this.typeRepository.delete(id);
    }

    @Override
    public Iterable<Type> findAll(Iterable<Long> ids) {
        return this.typeRepository.findAll(ids);
    }
}
