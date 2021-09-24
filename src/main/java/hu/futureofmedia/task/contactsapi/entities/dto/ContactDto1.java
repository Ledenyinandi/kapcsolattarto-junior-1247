package hu.futureofmedia.task.contactsapi.entities.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class ContactDto1 {

    private Long id;
    @NotBlank(message = "This field must not be empty")
    private String fullName;
    private String companyName;
    @Email
    @NotBlank(message = "This field must not be empty")
    private String email;
    private String phoneNumber;
}
