package hu.futureofmedia.task.contactsapi.controllers;

import com.google.i18n.phonenumbers.NumberParseException;
import hu.futureofmedia.task.contactsapi.entities.Contact;
import hu.futureofmedia.task.contactsapi.entities.dto.ContactDto1;
import hu.futureofmedia.task.contactsapi.entities.dto.ContactDto2;
import hu.futureofmedia.task.contactsapi.entities.dto.ContactDto3;
import hu.futureofmedia.task.contactsapi.services.ContactService;
import io.swagger.annotations.ApiOperation;
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

    @ApiOperation(value = "List all active contacts")
    @GetMapping
    public List<ContactDto1> findAll() {
        return contactService.findAll();
    }

    @ApiOperation(value = "Get one contact by its id")
    @GetMapping("/{id}")
    public ContactDto2 findById(@PathVariable("id") Long id) {
        return contactService.findById(id);
    }

    @ApiOperation(value = "Create new contact")
    @PostMapping
    public Contact save(@Valid @RequestBody ContactDto3 contactDto3) throws NumberParseException {
        return contactService.save(contactDto3);
    }

    @ApiOperation(value = "Update a contact by its id")
    @PutMapping("/{id}")
    public void update(@Valid @RequestBody ContactDto3 contactDto3, @PathVariable("id") Long id) throws NumberParseException {
        contactService.update(contactDto3, id);
    }

    @ApiOperation(value = "Set a contact's status to 'deleted'")
    @PutMapping("/delete/{id}")
    public void setStatusToDeleted(@PathVariable("id") Long id) {
        contactService.setStatusToDeleted(id);
    }
}
