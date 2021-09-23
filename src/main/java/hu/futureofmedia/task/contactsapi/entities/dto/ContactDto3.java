package hu.futureofmedia.task.contactsapi.entities.dto;

import hu.futureofmedia.task.contactsapi.entities.Status;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class ContactDto3 {

    private Long id;
    @NotBlank(message = "This field must not be empty")
    private String lastName;
    @NotBlank(message = "This field must not be empty")
    private String firstName;
    private Long companyId;
    @Email
    @NotBlank(message = "This field must not be empty")
    private String email;
    private String phoneNumber;
    private String comment;
    @Enumerated(EnumType.STRING)
    private Status status;
}
