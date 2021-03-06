package hu.futureofmedia.task.contactsapi.entities.dto;

import hu.futureofmedia.task.contactsapi.entities.Company;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import java.time.LocalDateTime;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class ContactDto2 {

    private Long id;
    private String lastName;
    private String firstName;
    private Company company;
    private String email;
    private String phoneNumber;
    private String comment;
    private LocalDateTime createTime;
    private LocalDateTime updateTime;
}
