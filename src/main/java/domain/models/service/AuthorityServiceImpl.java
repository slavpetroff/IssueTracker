package domain.models.service;

import domain.exception.EntityNotFoundException;
import domain.models.entity.Authority;
import domain.models.repository.AuthorityRepository;
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
public class AuthorityServiceImpl implements AuthorityService {

    private final AuthorityRepository authorityRepository;

    @Autowired
    public AuthorityServiceImpl(AuthorityRepository authorityRepository) {
        this.authorityRepository = authorityRepository;
    }

    @Override
    public Authority save(Authority entity) {
        return authorityRepository.save(entity);
    }

    @Override
    public Iterable<Authority> save(Iterable<Authority> entities) {
        return authorityRepository.save(entities);
    }

    @Override
    public Authority findOne(String name) throws EntityNotFoundException {
        Optional<Authority> optAuthority = StreamSupport
                .stream(authorityRepository.findAll().spliterator(), false)
                .filter(authority -> authority.getName().equalsIgnoreCase(name))
                .findFirst();

        if (optAuthority.isPresent()) {
            throw new EntityNotFoundException(String.format("Could not find entity AppState - name:%s", name));
        }

        return optAuthority.get();
    }

    @Override
    public Authority findOne(Long id) {
        return this.authorityRepository.findOne(id);
    }

    @Override
    public boolean exists(Long id) {
        return this.authorityRepository.exists(id);
    }

    @Override
    public Iterable<Authority> findAll() {
        return this.authorityRepository.findAll();
    }

    @Override
    public long count() {
        return this.authorityRepository.count();
    }

    @Override
    public void delete(Authority entity) {
        this.authorityRepository.delete(entity);
    }

    @Override
    public void delete(Iterable<Authority> entities) {
        this.authorityRepository.delete(entities);
    }

    @Override
    public void deleteAll() {
        this.authorityRepository.deleteAll();
    }

    @Override
    public void delete(Long id) {
        this.authorityRepository.delete(id);
    }

    @Override
    public Iterable<Authority> findAll(Iterable<Long> ids) {
        return this.authorityRepository.findAll(ids);
    }
}
