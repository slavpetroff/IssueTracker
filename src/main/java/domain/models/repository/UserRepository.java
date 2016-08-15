package domain.models.repository;

import domain.models.entity.User;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

/**
 * Created by slavpetroff on 7/17/16.
 */
@Repository
@Transactional
public interface UserRepository extends CrudRepository<User, Long> {

    @Query(value = "select u from User u where u.username=:firstName")
    User findOne(@Param("firstName") java.lang.String firstName);
}
