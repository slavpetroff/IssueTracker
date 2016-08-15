package domain.models.service;

import domain.exception.EntityNotFoundException;
import domain.models.entity.state.ApplicationState;
import domain.models.repository.ApplicationStateRepository;
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
public class ApplicationStateServiceImpl implements ApplicationStateService {

    private final ApplicationStateRepository applicationStateRepository;

    @Autowired
    public ApplicationStateServiceImpl(
            ApplicationStateRepository applicationStateRepository) {
        this.applicationStateRepository = applicationStateRepository;
    }

    @Override
    public ApplicationState save(ApplicationState entity) {
        return applicationStateRepository.save(entity);
    }

    @Override
    public Iterable<ApplicationState> save(Iterable<ApplicationState> entities) {
        return applicationStateRepository.save(entities);
    }

    @Override
    public ApplicationState findOne(String name) throws EntityNotFoundException {
        Optional<ApplicationState> optApplicationState = StreamSupport
                .stream(applicationStateRepository.findAll().spliterator(), false)
                .filter(state -> state.getName().equalsIgnoreCase(name))
                .findFirst();

        if (optApplicationState.isPresent()) {
            throw new EntityNotFoundException(String.format("Could not find entity AppState - name:%s", name));
        }

        return optApplicationState.get();
    }

    @Override
    public ApplicationState findOne(Long id) {
        return this.applicationStateRepository.findOne(id);
    }

    @Override
    public boolean exists(Long id) {
        return this.applicationStateRepository.exists(id);
    }

    @Override
    public Iterable<ApplicationState> findAll() {
        return this.applicationStateRepository.findAll();
    }

    @Override
    public long count() {
        return this.applicationStateRepository.count();
    }

    @Override
    public void delete(ApplicationState entity) {
        this.applicationStateRepository.delete(entity);
    }

    @Override
    public void delete(Iterable<ApplicationState> entities) {
        this.applicationStateRepository.delete(entities);
    }

    @Override
    public void deleteAll() {
        this.applicationStateRepository.deleteAll();
    }

    @Override
    public void delete(Long id) {
        this.applicationStateRepository.delete(id);
    }

    @Override
    public Iterable<ApplicationState> findAll(Iterable<Long> ids) {
        return this.applicationStateRepository.findAll(ids);
    }
}
