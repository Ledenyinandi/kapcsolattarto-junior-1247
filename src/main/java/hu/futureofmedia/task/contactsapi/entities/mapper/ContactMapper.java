package hu.futureofmedia.task.contactsapi.entities.mapper;

import hu.futureofmedia.task.contactsapi.entities.Company;
import hu.futureofmedia.task.contactsapi.entities.Contact;
import hu.futureofmedia.task.contactsapi.entities.Status;
import hu.futureofmedia.task.contactsapi.entities.dto.ContactDto1;
import hu.futureofmedia.task.contactsapi.entities.dto.ContactDto2;
import hu.futureofmedia.task.contactsapi.entities.dto.ContactDto3;
import org.springframework.stereotype.Component;
import java.time.LocalDateTime;

@Component
public class ContactMapper {

    public ContactDto1 convertToDtoForFindAll(Contact contact) {
        return new ContactDto1(
                contact.getId(),
                contact.getLastName() + " " + contact.getFirstName(),
                contact.getCompany(),
                contact.getEmail(),
                contact.getPhoneNumber());
    }

    public Contact convertToEntityForFindAll(ContactDto1 contactDto1) {
        int lastSpaceChar = contactDto1.getFullName().lastIndexOf(' ');
        return new Contact(
                contactDto1.getId(),
                contactDto1.getFullName().substring(0, lastSpaceChar),
                contactDto1.getFullName().substring(lastSpaceChar + 1),
                contactDto1.getEmail(),
                contactDto1.getPhoneNumber(),
                contactDto1.getCompany(),
                "",
                Status.ACTIVE,
                LocalDateTime.now(),
                LocalDateTime.now()
        );
    }

    public ContactDto2 convertToDtoForFindById(Contact contact) {
        return new ContactDto2(
                contact.getId(),
                contact.getLastName(),
                contact.getFirstName(),
                contact.getCompany(),
                contact.getEmail(),
                contact.getPhoneNumber(),
                contact.getComment(),
                contact.getCreateTime(),
                contact.getUpdateTime()
        );
    }

    public Contact convertToEntityForFindById(ContactDto2 contactDto2) {
        return new Contact(
                contactDto2.getId(),
                contactDto2.getLastName(),
                contactDto2.getFirstName(),
                contactDto2.getEmail(),
                contactDto2.getPhoneNumber(),
                contactDto2.getCompany(),
                contactDto2.getComment(),
                Status.ACTIVE,
                contactDto2.getCreateTime(),
                contactDto2.getUpdateTime()
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

    public ContactDto3 convertToDtoForSave(Contact contact) {
        return new ContactDto3(
                contact.getId(),
                contact.getLastName(),
                contact.getFirstName(),
                contact.getCompany().getId(),
                contact.getEmail(),
                contact.getPhoneNumber(),
                contact.getComment(),
                contact.getStatus()
        );
    }
}
