package hu.futureofmedia.task.contactsapi.entities.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedDate;
import java.time.LocalDateTime;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class ContactDto2 {

    private Long id;
    private String lastName;
    private String firstName;
    private String companyName;
    private String email;
    private String phoneNumber;
    private String comment;
    private LocalDateTime createTime;
    private LocalDateTime updateTime;
}
