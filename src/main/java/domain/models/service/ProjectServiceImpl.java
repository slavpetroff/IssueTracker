package domain.models.service;

import domain.exception.EntityNotFoundException;
import domain.models.entity.Project;
import domain.models.repository.ProjectRepository;
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
public class ProjectServiceImpl implements ProjectService {

    private final ProjectRepository projectRepository;

    @Autowired
    public ProjectServiceImpl(
            ProjectRepository projectRepository) {
        this.projectRepository = projectRepository;
    }

    @Override
    public Project save(Project entity) {
        return projectRepository.save(entity);
    }

    @Override
    public Iterable<Project> save(Iterable<Project> entities) {
        return projectRepository.save(entities);
    }

    @Override
    public Project findOne(String name) throws EntityNotFoundException {
        Optional<Project> optProject = StreamSupport
                .stream(projectRepository.findAll().spliterator(), false)
                .filter(project -> project.getName().equalsIgnoreCase(name))
                .findFirst();

        if (optProject.isPresent()) {
            throw new EntityNotFoundException(String.format("Could not find entity AppState - name:%s", name));
        }

        return optProject.get();
    }

    @Override
    public Project findOne(Long id) {
        return this.projectRepository.findOne(id);
    }

    @Override
    public boolean exists(Long id) {
        return this.projectRepository.exists(id);
    }

    @Override
    public Iterable<Project> findAll() {
        return this.projectRepository.findAll();
    }

    @Override
    public long count() {
        return this.projectRepository.count();
    }

    @Override
    public void delete(Project entity) {
        this.projectRepository.delete(entity);
    }

    @Override
    public void delete(Iterable<Project> entities) {
        this.projectRepository.delete(entities);
    }

    @Override
    public void deleteAll() {
        this.projectRepository.deleteAll();
    }

    @Override
    public void delete(Long id) {
        this.projectRepository.delete(id);
    }

    @Override
    public Iterable<Project> findAll(Iterable<Long> ids) {
        return this.projectRepository.findAll(ids);
    }
}
