package domain.models.service;

import domain.enums.Role;
import domain.models.entity.User;

/**
 * Created by slavpetroff on 7/17/16.
 */

public interface UserService extends BaseFunctionsService<User> {
    User save(User entity, Role role);
}
