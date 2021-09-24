package hu.futureofmedia.task.contactsapi.entities.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class ContactDto1 {

    private Long id;
    private String fullName;
    private String companyName;
    private String email;
    private String phoneNumber;
}
