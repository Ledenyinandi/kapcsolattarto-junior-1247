package hu.futureofmedia.task.contactsapi.controllers;

import com.google.i18n.phonenumbers.NumberParseException;
import hu.futureofmedia.task.contactsapi.entities.Contact;
import hu.futureofmedia.task.contactsapi.entities.dto.ContactDto;
import hu.futureofmedia.task.contactsapi.services.ContactService;
import org.springframework.web.bind.annotation.*;
import javax.validation.Valid;
import java.util.List;

@RestController
@RequestMapping("/contact")
public class ContactController {

    private final ContactService contactService;

    public ContactController(ContactService contactService) {
        this.contactService = contactService;
    }

    @GetMapping
    public List<ContactDto> findAll() {
        return contactService.findAll();
    }

    public ContactDto findById(Long id) {
        return contactService.findById(id);
    }

    @PostMapping
    public void save(@Valid @RequestBody ContactDto contactDto) throws NumberParseException {
        contactService.save(contactDto);
    }

    public void update(Contact contact, Long id) {
        contactService.update(contact, id);
    }

    public void deleteById(Long id) {
        contactService.deleteById(id);
    }
}
