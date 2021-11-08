package com.example.sping_portfolio.model.SQL;
import lombok.*;
import org.springframework.format.annotation.DateTimeFormat;

import javax.persistence.*;
import javax.validation.constraints.Size;
import java.util.Date;

@NoArgsConstructor
@Getter
@Setter
@ToString
@Entity
public class Task {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @NonNull
    @Size(min=1,max=30)
    private String name;

    @NonNull
    @Size(min=1, max=30)
    private String title;

    @NonNull
    @Size(min=1, max=30)
    private String description;

    @NonNull
    @Size(min=1, max=30)
    private String details;

    @DateTimeFormat(pattern = "yyyy-MM-dd")
    private Date dob;

    public Login(Long id, String name, String title, String description, String details, Date dob) {
        this.id = id;
        this.name = name;
        this.title = title;
        this.description = description;
        this.details = details;
        this.dob = dob;
    }
}
