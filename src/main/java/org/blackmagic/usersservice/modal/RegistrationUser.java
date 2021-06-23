package org.blackmagic.usersservice.modal;

import lombok.*;

import javax.validation.constraints.*;
import java.util.Date;

/**
 * @author niharsh
 * @created 23/06/2021 - 19:29
 */
@Getter @Setter
@AllArgsConstructor @NoArgsConstructor
@ToString
public class RegistrationUser extends User {

    @Past(message = "DateOfBirth must be past value")
    @NotNull(message = "Please provide DateOfBirth")
    private Date dob;

}
