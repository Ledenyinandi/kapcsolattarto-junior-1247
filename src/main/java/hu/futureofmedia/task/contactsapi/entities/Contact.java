package hu.futureofmedia.task.contactsapi.entities;

import lombok.Getter;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;
import javax.persistence.*;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;
import java.time.LocalDateTime;

@Entity
@Getter
@NoArgsConstructor
public class Contact {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @NotBlank(message = "This field must not be empty")
    private String lastName;
    @NotBlank(message = "This field must not be empty")
    private String firstName;
    @Email
    @NotBlank(message = "This field must not be empty")
    private String email;
    private String phoneNumber;
    @ManyToOne
    private Company company;
    private String comment;
    private Status status;
    @CreationTimestamp
    private LocalDateTime createTime;
    @UpdateTimestamp
    private LocalDateTime updateTime;

}
