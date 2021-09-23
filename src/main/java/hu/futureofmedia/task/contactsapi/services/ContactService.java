package hu.futureofmedia.task.contactsapi.services;

import com.google.i18n.phonenumbers.NumberParseException;
import com.google.i18n.phonenumbers.PhoneNumberUtil;
import com.google.i18n.phonenumbers.Phonenumber;
import hu.futureofmedia.task.contactsapi.entities.Contact;
import hu.futureofmedia.task.contactsapi.entities.Status;
import hu.futureofmedia.task.contactsapi.entities.dto.ContactDtoForList;
import hu.futureofmedia.task.contactsapi.entities.mapper.ContactMapper;
import hu.futureofmedia.task.contactsapi.repositories.ContactRepository;
import org.springframework.stereotype.Service;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class ContactService {

    private ContactRepository contactRepository;
    private ContactMapper contactMapper;

    public ContactService(ContactRepository contactRepository, ContactMapper contactMapper) {
        this.contactRepository = contactRepository;
        this.contactMapper = contactMapper;
    }

    public List<ContactDtoForList> findAll() {
        List<Contact> sortedFilteredContacts = contactRepository.findAll().stream()
                .filter(contact -> contact.getStatus().equals(Status.ACTIVE))
                .sorted(Comparator.comparing(Contact::getLastName))
                .collect(Collectors.toList());
        List<ContactDtoForList> contacts = new ArrayList<>();
        sortedFilteredContacts.forEach(contact -> contacts.add(contactMapper.convertToDtoForList(contact)));
        return contacts;
    }

    public Contact findById(Long id) {
        return contactRepository.findById(id);
    }

    public void save(Contact contact) throws NumberParseException {
        PhoneNumberUtil phoneNumberUtil = PhoneNumberUtil.getInstance();
        Phonenumber.PhoneNumber phoneNumber = phoneNumberUtil.parse(contact.getPhoneNumber(), "HU");
        if (phoneNumberUtil.isValidNumber(phoneNumber)) {
            contactRepository.save(contact);
        }
    }

    public void update(Contact contact, Long id) {
        contact.setId(id);
        contactRepository.save(contact);
    }

    public void deleteById(Long id) {
        contactRepository.deleteById(id);
    }
}
