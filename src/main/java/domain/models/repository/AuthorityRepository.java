package domain.models.repository;

import domain.models.entity.Authority;
import domain.models.entity.Issue;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;

/**
 * Created by slavpetroff on 8/13/16.
 */
public interface AuthorityRepository extends CrudRepository<Authority, Long> {

    @Query(value = "select a from Authority a where a.name=:name")
    Authority findOne(@Param("name") java.lang.String name);
}
