package hu.futureofmedia.task.contactsapi.controllers;

import com.google.i18n.phonenumbers.NumberParseException;
import hu.futureofmedia.task.contactsapi.entities.Contact;
import hu.futureofmedia.task.contactsapi.entities.dto.ContactDtoForList;
import hu.futureofmedia.task.contactsapi.services.ContactService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import java.util.List;

@RestController
@RequestMapping("/contact")
public class ContactController {

    private ContactService contactService;

    public ContactController(ContactService contactService) {
        this.contactService = contactService;
    }

    @GetMapping
    public List<ContactDtoForList> findAll() {
        return contactService.findAll();
    }

    public Contact findById(Long id) {
        return contactService.findById(id);
    }

    public void save(Contact contact) throws NumberParseException {
        contactService.save(contact);
    }

    public void update(Contact contact, Long id) {
        contactService.update(contact, id);
    }

    public void deleteById(Long id) {
        contactService.deleteById(id);
    }
}
