package hu.futureofmedia.task.contactsapi.entities.mapper;

import hu.futureofmedia.task.contactsapi.entities.Company;
import hu.futureofmedia.task.contactsapi.entities.Contact;
import hu.futureofmedia.task.contactsapi.entities.dto.ContactDtoForList;
import org.springframework.stereotype.Component;

@Component
public class ContactMapper {

    public ContactDtoForList convertToDtoForList(Contact contact) {
        return new ContactDtoForList(
                contact.getFirstName() + contact.getLastName(),
                contact.getCompany().getName(),
                contact.getEmail(),
                contact.getPhoneNumber());
    }

    public Contact convertToEntityForList(ContactDtoForList contactDtoForList, Company company) {
        int lastSpaceChar = contactDtoForList.getFullName().lastIndexOf(' ');
        String firstName = contactDtoForList.getFullName().substring(0, lastSpaceChar);
        String lastName = contactDtoForList.getFullName().substring(lastSpaceChar + 1);
        return new Contact(
                lastName,
                firstName,
                contactDtoForList.getEmail(),
                contactDtoForList.getPhoneNumber(),
                company
        );
    }
}
