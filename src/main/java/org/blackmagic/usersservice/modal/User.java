package org.blackmagic.usersservice.modal;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.*;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.Size;

/**
 * @author niharsh
 * @created 16/06/2021 - 20:19
 */
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@JsonIgnoreProperties(ignoreUnknown = true)
public class User {

    private long id;

    @NotEmpty(message = "Please provide email")
    @Email(message = "Please provide valid email")
    private String email;

    @NotEmpty(message = "Please provide password")
    @Size(message = "Password must be 8 characters long", min = 8)
    private String password;

    @Override
    public String toString() {
        return "User{" +
                "id=" + id +
                ", email='" + email + '\'' +
                '}';
    }
}
