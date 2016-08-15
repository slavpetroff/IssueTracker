package domain.models.service;

import domain.enums.Role;
import domain.exception.EntityNotFoundException;
import domain.models.entity.Authority;
import domain.models.entity.User;
import domain.models.repository.AuthorityRepository;
import domain.models.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Optional;
import java.util.stream.Collectors;
import java.util.stream.StreamSupport;

/**
 * Created by slavpetroff on 7/17/16.
 */
@Service
@Transactional
public class UserServiceImpl implements UserService {

    private final UserRepository userRepository;
    private final AuthorityRepository authorityRepository;
    private Authority authority;
    private Role defaultRole;

    @Autowired
    public UserServiceImpl(
            UserRepository userRepository,
            AuthorityRepository authorityRepository) {
        this.userRepository = userRepository;
        this.authorityRepository = authorityRepository;
        this.defaultRole = Role.ROLE_USER;
        this.setAuthority(this.defaultRole);
        this.authority = new Authority(this.defaultRole);
    }

    @Override
    public User save(User entity) {
        BCryptPasswordEncoder bCryptPasswordEncoder = new BCryptPasswordEncoder(11);
        entity.setPassword(bCryptPasswordEncoder.encode(entity.getPassword()));

        entity.getRoles().add(this.authority);
        return userRepository.save(entity);
    }

    @Override
    public Iterable<User> save(Iterable<User> entities) {
        return userRepository.save(StreamSupport.stream(entities.spliterator(), false).map(u -> {
            BCryptPasswordEncoder bCryptPasswordEncoder = new BCryptPasswordEncoder(11);
            u.setPassword(bCryptPasswordEncoder.encode(u.getPassword()));
            this.setAuthority(this.defaultRole);
            u.getRoles().add(this.authority);
            return u;
        }).collect(Collectors.toList()));
    }

    @Override
    public User findOne(String name) throws EntityNotFoundException {
        Optional<User> optUser = StreamSupport
                .stream(userRepository.findAll().spliterator(), false)
                .filter(user -> user.getUsername().equalsIgnoreCase(name))
                .findFirst();

        if (optUser.isPresent()) {
            throw new EntityNotFoundException(String.format("Could not find entity AppState - name:%s", name));
        }

        return optUser.get();
    }

    @Override
    public User findOne(Long id) {
        return this.userRepository.findOne(id);
    }

    @Override
    public boolean exists(Long id) {
        return this.userRepository.exists(id);
    }

    @Override
    public Iterable<User> findAll() {
        return this.userRepository.findAll();
    }

    @Override
    public long count() {
        return this.userRepository.count();
    }

    @Override
    public void delete(User entity) {
        this.userRepository.delete(entity);
    }

    @Override
    public void delete(Iterable<User> entities) {
        this.userRepository.delete(entities);
    }

    @Override
    public void deleteAll() {
        this.userRepository.deleteAll();
    }

    @Override
    public void delete(Long id) {
        this.userRepository.delete(id);
    }

    @Override
    public Iterable<User> findAll(Iterable<Long> ids) {
        return this.userRepository.findAll(ids);
    }

    @Override
    public User save(User entity, Role role) {
        this.setAuthority(role);
        entity.getRoles().add(this.authority);
        BCryptPasswordEncoder bCryptPasswordEncoder = new BCryptPasswordEncoder(11);
        entity.setPassword(bCryptPasswordEncoder.encode(entity.getPassword()));
        return this.userRepository.save(entity);
    }

    private void setAuthority(Role role) {
        Authority found = this.authorityRepository.findOne(String.valueOf(role));

        if (found != null) {
            this.authority = found;
            return;
        }

        this.authority = new Authority(role);
    }
}
