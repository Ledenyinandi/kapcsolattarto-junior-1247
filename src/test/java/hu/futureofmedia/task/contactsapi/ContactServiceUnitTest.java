package hu.futureofmedia.task.contactsapi;

import hu.futureofmedia.task.contactsapi.entities.Company;
import hu.futureofmedia.task.contactsapi.entities.Contact;
import hu.futureofmedia.task.contactsapi.entities.Status;
import hu.futureofmedia.task.contactsapi.entities.mapper.ContactMapper;
import hu.futureofmedia.task.contactsapi.repositories.CompanyRepository;
import hu.futureofmedia.task.contactsapi.repositories.ContactRepository;
import hu.futureofmedia.task.contactsapi.services.ContactService;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.junit.jupiter.MockitoExtension;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
public class ContactServiceUnitTest {

    private ContactRepository contactRepository;
    private CompanyRepository companyRepository;
    private ContactService contactService;
    private ContactMapper contactMapper;
    Contact contact = new Contact(1L, "Kovács", "Zoltán", "kz@gmail.com", "+36708765432",
            new Company(), "some comment", Status.ACTIVE, LocalDateTime.now(), LocalDateTime.now());

    @BeforeEach
    void initUseCase() {
        contactRepository = mock(ContactRepository.class);
        contactMapper = new ContactMapper();
        contactService = new ContactService(contactRepository, contactMapper, companyRepository);
    }

    @Test
    public void testFindAll_shouldReturnListOfContacts() {
        List<Contact> contacts = new ArrayList<>();
        contacts.add(contact);

        when(contactRepository.findAll()).thenReturn(contacts);

        List<Contact> fetchedContacts = new ArrayList<>();
        contactService.findAll().forEach(contactDto1 -> fetchedContacts.add(contactMapper.convertToEntityForFindAll(contactDto1)));
        Assertions.assertTrue(fetchedContacts.size() > 0);
    }

    @Test
    public void testFindById_shouldReturnContactWithGivenId() {
        when(contactRepository.findById(1L)).thenReturn(contact);

        Contact foundContact = contactMapper.convertToEntityForFindById(contactService.findById(1L));
        Assertions.assertFalse(foundContact.getLastName().isEmpty());
    }

    @Test
    public void testSave_shouldReturnNewContact() {
        when(contactRepository.save(any(Contact.class))).thenReturn(contact);

        Contact savedContact = contactRepository.save(contact);
        Assertions.assertFalse(savedContact.getLastName().isEmpty());
    }
}
