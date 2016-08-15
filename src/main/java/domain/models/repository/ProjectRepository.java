package domain.models.repository;

import domain.models.dto.ProjectDto;
import domain.models.entity.Project;
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
public interface ProjectRepository extends CrudRepository<Project, Long> {

    @Query(value = "select p from Project p where p.name=:name")
    Project findOne(@Param("name") java.lang.String name);
}
