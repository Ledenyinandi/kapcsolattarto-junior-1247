package hu.futureofmedia.task.contactsapi.services;

import hu.futureofmedia.task.contactsapi.entities.Contact;
import hu.futureofmedia.task.contactsapi.repositories.ContactRepository;
import org.springframework.stereotype.Service;
import java.util.List;

@Service
public class ContactService {

    private ContactRepository contactRepository;

    public ContactService(ContactRepository contactRepository) {
        this.contactRepository = contactRepository;
    }

    public List<Contact> findAll() {
        return contactRepository.findAll();
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
