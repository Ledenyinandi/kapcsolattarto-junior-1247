package hu.futureofmedia.task.contactsapi.entities;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedDate;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;
import javax.persistence.*;
import java.time.LocalDateTime;

@Entity
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@EntityListeners(AuditingEntityListener.class)
public class Contact {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String lastName;
    private String firstName;
    private String email;
    private String phoneNumber;
    @ManyToOne
    private Company company;
    private String comment;
    @Enumerated(EnumType.STRING)
    private Status status;
    @Column(name = "create_time", nullable = false, updatable = false)
    @CreatedDate
    private LocalDateTime createTime;
    @Column(name = "update_time")
    @LastModifiedDate
    private LocalDateTime updateTime;

    public Contact(Long id, String lastName, String firstName, String email, String phoneNumber, Company company, String comment, Status status) {
        this.id = id;
        this.lastName = lastName;
        this.firstName = firstName;
        this.email = email;
        this.phoneNumber = phoneNumber;
        this.company = company;
        this.comment = comment;
        this.status = status;
    }
}
