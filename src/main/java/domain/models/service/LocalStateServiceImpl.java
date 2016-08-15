package domain.models.service;

import domain.exception.EntityNotFoundException;
import domain.models.entity.state.LocalState;
import domain.models.repository.LocalStateRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Optional;
import java.util.stream.StreamSupport;

/**
 * Created by slavpetroff on 8/13/16.
 */
@Service
@Transactional
public class LocalStateServiceImpl implements LocalStateService {

    private final LocalStateRepository localStateRepository;

    @Autowired
    public LocalStateServiceImpl(
            LocalStateRepository localStateRepository) {
        this.localStateRepository = localStateRepository;
    }

    @Override
    public LocalState save(LocalState entity) {
        return localStateRepository.save(entity);
    }

    @Override
    public Iterable<LocalState> save(Iterable<LocalState> entities) {
        return localStateRepository.save(entities);
    }

    @Override
    public LocalState findOne(String name) throws EntityNotFoundException {
        Optional<LocalState> optLocalState = StreamSupport
                .stream(localStateRepository.findAll().spliterator(), false)
                .filter(localState -> localState.getName().equalsIgnoreCase(name))
                .findFirst();

        if (optLocalState.isPresent()) {
            throw new EntityNotFoundException(String.format("Could not find entity AppState - name:%s", name));
        }

        return optLocalState.get();
    }

    @Override
    public LocalState findOne(Long id) {
        return this.localStateRepository.findOne(id);
    }

    @Override
    public boolean exists(Long id) {
        return this.localStateRepository.exists(id);
    }

    @Override
    public Iterable<LocalState> findAll() {
        return this.localStateRepository.findAll();
    }

    @Override
    public long count() {
        return this.localStateRepository.count();
    }

    @Override
    public void delete(LocalState entity) {
        this.localStateRepository.delete(entity);
    }

    @Override
    public void delete(Iterable<LocalState> entities) {
        this.localStateRepository.delete(entities);
    }

    @Override
    public void deleteAll() {
        this.localStateRepository.deleteAll();
    }

    @Override
    public void delete(Long id) {
        this.localStateRepository.delete(id);
    }

    @Override
    public Iterable<LocalState> findAll(Iterable<Long> ids) {
        return this.localStateRepository.findAll(ids);
    }
}
