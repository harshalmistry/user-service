package org.blackmagic.usersservice.mapper;

import org.blackmagic.usersservice.entity.UserEntity;
import org.blackmagic.usersservice.modal.RegistrationUser;
import org.blackmagic.usersservice.modal.User;
import org.mapstruct.InheritConfiguration;
import org.mapstruct.Mapper;

/**
 * @author niharsh
 * @created 23/06/2021 - 18:17
 */
@Mapper(componentModel = "spring")
public interface UserMapper {

    default UserEntity userToUserEntity(User user){
        if(user instanceof RegistrationUser)
            return map((RegistrationUser) user);
        else
            return map(user);
    }

    UserEntity map(User user);

    UserEntity map(RegistrationUser user);

    User UserEntityToUser(UserEntity userEntity);
}
