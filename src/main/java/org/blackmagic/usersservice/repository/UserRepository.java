package org.blackmagic.usersservice.repository;

import org.blackmagic.usersservice.entity.UserEntity;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

/**
 * @author niharsh
 * @created 16/06/2021 - 20:24
 */
@Repository
public interface UserRepository extends CrudRepository<UserEntity, Long> {
    Optional<UserEntity> findByEmail(String email);
}
