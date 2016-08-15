package domain.models.repository;

import domain.models.entity.Issue;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

/**
 * Created by slavpetroff on 8/8/16.
 */
@Repository
@Transactional
public interface IssueRepository extends CrudRepository<Issue, Long> {
    @Query(value = "select i from Issue i where i.name=:name")
    Issue findOne(@Param("name") java.lang.String name);
}
