package hu.futureofmedia.task.contactsapi.entities.mapper;

import hu.futureofmedia.task.contactsapi.entities.Company;
import hu.futureofmedia.task.contactsapi.entities.Contact;
import hu.futureofmedia.task.contactsapi.entities.dto.ContactDto;
import org.springframework.stereotype.Component;

@Component
public class ContactMapper {

    public ContactDto convertToDtoForFindAll(Contact contact) {
        return new ContactDto(
                contact.getFirstName() + contact.getLastName(),
                contact.getCompany().getName(),
                contact.getEmail(),
                contact.getPhoneNumber());
    }

    public ContactDto convertToDtoForFindById(Contact contact) {
        return new ContactDto(
                contact.getLastName(),
                contact.getFirstName(),
                contact.getCompany().getName(),
                contact.getEmail(),
                contact.getPhoneNumber(),
                contact.getComment(),
                contact.getCreateTime(),
                contact.getUpdateTime()
        );
    }

    public Contact convertToEntityForSave(ContactDto contactDto, Company company) {
        return new Contact(
                contactDto.getLastName(),
                contactDto.getFirstName(),
                contactDto.getEmail(),
                contactDto.getPhoneNumber(),
                company,
                contactDto.getComment()
                );
    }
}
