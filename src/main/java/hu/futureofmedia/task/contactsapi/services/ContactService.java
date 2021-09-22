package hu.futureofmedia.task.contactsapi.services;

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

    public void save(Contact contact) {
        contactRepository.save(contact);
    }

    public void update(Contact contact, Long id) {
        contactRepository.update(contact, id);
    }

    public void deleteById(Long id) {
        contactRepository.deleteById(id);
    }
}
