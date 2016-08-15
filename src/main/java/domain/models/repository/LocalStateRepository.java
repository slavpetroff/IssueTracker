package domain.models.repository;

import domain.models.entity.state.LocalState;
import org.springframework.data.repository.CrudRepository;

/**
 * Created by slavpetroff on 8/13/16.
 */
public interface LocalStateRepository extends CrudRepository<LocalState, Long> {

//    @Query(value = "select s from LocalState s where s.name =:name")
//    LocalState findOne(@Param("name") java.lang.String name);
}
