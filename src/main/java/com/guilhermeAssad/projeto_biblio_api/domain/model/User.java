package com.guilhermeAssad.projeto_biblio_api.domain.model;

import com.guilhermeAssad.projeto_biblio_api.utils.EUserType;
import jakarta.persistence.*;
import jakarta.validation.constraints.Email;
import lombok.*;

@Entity
@Table(name = "TABLE_USER")
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@EqualsAndHashCode(of = "id")
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "NAME", length = 255,nullable = false)
    private String name;

    @Email
    @Column (name = "EMAIL", nullable = false, unique = true)
    private String email;


    @Column(name = "PASSWORD", nullable = false)
    private String password;

    @Column (name = "USER_TYPE", nullable = false)
    @Enumerated(EnumType.STRING)
    private EUserType userType;

    public void updateFrom (User user){
        if (user.getName() != null)
            this.name = user.getName();
        if (user.getEmail() != null)
            this.email = user.getEmail();
    }
}
