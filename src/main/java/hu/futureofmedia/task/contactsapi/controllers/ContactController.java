package hu.futureofmedia.task.contactsapi.controllers;

import com.google.i18n.phonenumbers.NumberParseException;
import hu.futureofmedia.task.contactsapi.entities.dto.ContactDto1;
import hu.futureofmedia.task.contactsapi.entities.dto.ContactDto2;
import hu.futureofmedia.task.contactsapi.entities.dto.ContactDto3;
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
    public List<ContactDto1> findAll() {
        return contactService.findAll();
    }

    @GetMapping("/{id}")
    public ContactDto2 findById(@PathVariable("id") Long id) {
        return contactService.findById(id);
    }

    @PostMapping
    public void save(@Valid @RequestBody ContactDto3 contactDto3) throws NumberParseException {
        contactService.save(contactDto3);
    }

    @PutMapping("/{id}")
    public void update(@Valid @RequestBody ContactDto3 contactDto3, @PathVariable("id") Long id) throws NumberParseException {
        contactService.update(contactDto3, id);
    }

    public void deleteById(Long id) {
        contactService.deleteById(id);
    }
}
