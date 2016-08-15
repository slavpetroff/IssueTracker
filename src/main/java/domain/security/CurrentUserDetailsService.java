package domain.security;

import domain.models.entity.User;
import domain.models.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@Transactional
public class CurrentUserDetailsService implements UserDetailsService {

    @Autowired
    UserRepository userRepository;

    @Override
    public CurrentUser loadUserByUsername(String username) throws UsernameNotFoundException {
        User dao = this.userRepository.findOne(username);

        return new CurrentUser(dao);
    }
}

