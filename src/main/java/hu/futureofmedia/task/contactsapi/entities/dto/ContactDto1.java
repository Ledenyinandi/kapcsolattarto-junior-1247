package hu.futureofmedia.task.contactsapi.entities.dto;

import hu.futureofmedia.task.contactsapi.entities.Company;
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
    private Company company;
    private String email;
    private String phoneNumber;
}
