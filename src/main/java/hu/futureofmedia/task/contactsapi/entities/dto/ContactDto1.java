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
//    @NotBlank(message = "This field must not be empty")
//    private String lastName;
//    @NotBlank(message = "This field must not be empty")
//    private String firstName;
    private String companyName;
//    private Long companyId;
    @Email
    @NotBlank(message = "This field must not be empty")
    private String email;
    private String phoneNumber;
//    private String comment;
//    private LocalDateTime createTime;
//    private LocalDateTime updateTime;

//    public ContactDto1(Long id, String lastName, String firstName, String companyName, String email, String phoneNumber, String comment, LocalDateTime createTime, LocalDateTime updateTime) {
//        this.id = id;
//        this.lastName = lastName;
//        this.firstName = firstName;
//        this.companyName = companyName;
//        this.email = email;
//        this.phoneNumber = phoneNumber;
//        this.comment = comment;
//        this.createTime = createTime;
//        this.updateTime = updateTime;
//    }
}
