package org.blackmagic.usersservice.entity;

import lombok.*;

import javax.persistence.*;
import java.time.LocalDate;
import java.util.Date;

/**
 * @author niharsh
 * @created 16/06/2021 - 20:10
 */
@Entity
@Getter @Setter
@NoArgsConstructor @AllArgsConstructor
@ToString
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long id;

    @Column(nullable = false, unique = true)
    private String email;

    @Column(nullable = false)
    private String password;

    @Column(nullable = false)
    private Date dob;

}
