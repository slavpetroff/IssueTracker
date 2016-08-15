package domain.models.repository;

import domain.models.entity.state.ApplicationState;
import org.springframework.data.repository.CrudRepository;

/**
 * Created by slavpetroff on 8/8/16.
 */
public interface ApplicationStateRepository extends CrudRepository<ApplicationState, Long> {

//    @Query(value = "select s from ApplicationState s where s.name =:name")
//    ApplicationState findOne(@Param("name") java.lang.String name);
}
