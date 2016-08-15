package domain.models.service;

import domain.exception.EntityNotFoundException;
import domain.models.entity.Issue;
import domain.models.repository.IssueRepository;
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
public class IssueServiceImpl implements IssueService {

    private final IssueRepository issueRepository;

    @Autowired
    public IssueServiceImpl(
            IssueRepository issueRepository) {
        this.issueRepository = issueRepository;
    }

    @Override
    public Issue save(Issue entity) {
        return issueRepository.save(entity);
    }

    @Override
    public Iterable<Issue> save(Iterable<Issue> entities) {
        return issueRepository.save(entities);
    }

    @Override
    public Issue findOne(String name) throws EntityNotFoundException {
        Optional<Issue> optIssue = StreamSupport
                .stream(issueRepository.findAll().spliterator(), false)
                .filter(issue -> issue.getName().equalsIgnoreCase(name))
                .findFirst();

        if (optIssue.isPresent()) {
            throw new EntityNotFoundException(String.format("Could not find entity AppState - name:%s", name));
        }

        return optIssue.get();
    }

    @Override
    public Issue findOne(Long id) {
        return this.issueRepository.findOne(id);
    }

    @Override
    public boolean exists(Long id) {
        return this.issueRepository.exists(id);
    }

    @Override
    public Iterable<Issue> findAll() {
        return this.issueRepository.findAll();
    }

    @Override
    public long count() {
        return this.issueRepository.count();
    }

    @Override
    public void delete(Issue entity) {
        this.issueRepository.delete(entity);
    }

    @Override
    public void delete(Iterable<Issue> entities) {
        this.issueRepository.delete(entities);
    }

    @Override
    public void deleteAll() {
        this.issueRepository.deleteAll();
    }

    @Override
    public void delete(Long id) {
        this.issueRepository.delete(id);
    }

    @Override
    public Iterable<Issue> findAll(Iterable<Long> ids) {
        return this.issueRepository.findAll(ids);
    }
}
