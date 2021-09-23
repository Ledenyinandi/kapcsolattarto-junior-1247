package hu.futureofmedia.task.contactsapi.entities.dto;

import hu.futureofmedia.task.contactsapi.entities.Company;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;
import java.time.LocalDateTime;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class ContactDto {

    @NotBlank(message = "This field must not be empty")
    private String fullName;
    @NotBlank(message = "This field must not be empty")
    private String lastName;
    @NotBlank(message = "This field must not be empty")
    private String firstName;
    private Company company;
    @Email
    @NotBlank(message = "This field must not be empty")
    private String email;
    private String phoneNumber;
    private String comment;
    private LocalDateTime createTime;
    private LocalDateTime updateTime;

    public ContactDto(String fullName, Company company, String email, String phoneNumber) {
        this.fullName = fullName;
        this.company = company;
        this.email = email;
        this.phoneNumber = phoneNumber;
    }

    public ContactDto(String lastName, String firstName, Company company, String email, String phoneNumber, String comment, LocalDateTime createTime, LocalDateTime updateTime) {
        this.lastName = lastName;
        this.firstName = firstName;
        this.company = company;
        this.email = email;
        this.phoneNumber = phoneNumber;
        this.comment = comment;
        this.createTime = createTime;
        this.updateTime = updateTime;
    }

    public ContactDto(String lastName, String firstName, Company company, String email, String phoneNumber, String comment) {
        this.lastName = lastName;
        this.firstName = firstName;
        this.company = company;
        this.email = email;
        this.phoneNumber = phoneNumber;
        this.comment = comment;
    }
}