package com.example.sping_portfolio.model.SQL;
import lombok.*;
import org.springframework.format.annotation.DateTimeFormat;

import javax.persistence.*;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.Size;
import java.util.Date;

@NoArgsConstructor
@Getter
@Setter
@ToString
@Entity
public class Login {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @NonNull
    @Size(min=1,max=30)
    private String firstname;

    @NonNull
    @Size(min=1, max=30)
    private String lastname;

    @NonNull
    @Size(min=1, max=30)
    private String username;

    @NonNull
    @Size(min=1, max=30)
    private String password;

    @NotEmpty
    @Email
    private String email;

    @NonNull
    @Size(min=1, max=30)
    private String task;

    public Login(Long id, String firstname, String lastname, String username, String password, String email, String task) {
        this.id = id;
        this.firstname = firstname;
        this.lastname = lastname;
        this.username = username;
        this.password = password;
        this.email = email;
        this.task = task;
    }
}
