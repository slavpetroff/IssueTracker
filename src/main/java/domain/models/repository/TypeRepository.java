package domain.models.repository;

import domain.models.entity.Type;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;

/**
 * Created by slavpetroff on 8/8/16.
 */
public interface TypeRepository extends CrudRepository<Type, Long> {
    @Query(value = "select t from Type t where t.name=:name")
    Type findOne(@Param("name") java.lang.String name);
}
