package hu.futureofmedia.task.contactsapi.entities.mapper;

import hu.futureofmedia.task.contactsapi.entities.Company;
import hu.futureofmedia.task.contactsapi.entities.Contact;
import hu.futureofmedia.task.contactsapi.entities.Status;
import hu.futureofmedia.task.contactsapi.entities.dto.ContactDto1;
import hu.futureofmedia.task.contactsapi.entities.dto.ContactDto2;
import hu.futureofmedia.task.contactsapi.entities.dto.ContactDto3;
import org.springframework.stereotype.Component;

@Component
public class ContactMapper {

    public ContactDto1 convertToDtoForFindAll(Contact contact) {
        return new ContactDto1(
                contact.getId(),
                contact.getLastName() + " " + contact.getFirstName(),
                contact.getCompany().getName(),
                contact.getEmail(),
                contact.getPhoneNumber());
    }

    public ContactDto2 convertToDtoForFindById(Contact contact) {
        return new ContactDto2(
                contact.getId(),
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

    public Contact convertToEntityForSave(ContactDto3 contactDto3, Company company, Status status) {
        return new Contact(
                contactDto3.getId(),
                contactDto3.getLastName(),
                contactDto3.getFirstName(),
                contactDto3.getEmail(),
                contactDto3.getPhoneNumber(),
                company,
                contactDto3.getComment(),
                status
                );
    }
}
