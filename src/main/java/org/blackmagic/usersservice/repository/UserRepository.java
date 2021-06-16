package org.blackmagic.usersservice.repository;

import org.blackmagic.usersservice.entity.User;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

/**
 * @author niharsh
 * @created 16/06/2021 - 20:24
 */
@Repository
public interface UserRepository extends CrudRepository<User, Long> {
    User findByEmail(String email);
}
