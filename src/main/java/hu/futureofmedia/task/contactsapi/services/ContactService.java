package hu.futureofmedia.task.contactsapi.services;

import com.google.i18n.phonenumbers.NumberParseException;
import com.google.i18n.phonenumbers.PhoneNumberUtil;
import com.google.i18n.phonenumbers.Phonenumber;
import hu.futureofmedia.task.contactsapi.entities.Contact;
import hu.futureofmedia.task.contactsapi.entities.Status;
import hu.futureofmedia.task.contactsapi.entities.dto.ContactDto1;
import hu.futureofmedia.task.contactsapi.entities.dto.ContactDto2;
import hu.futureofmedia.task.contactsapi.entities.dto.ContactDto3;
import hu.futureofmedia.task.contactsapi.entities.mapper.ContactMapper;
import hu.futureofmedia.task.contactsapi.repositories.CompanyRepository;
import hu.futureofmedia.task.contactsapi.repositories.ContactRepository;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class ContactService {

    private final ContactRepository contactRepository;
    private final ContactMapper contactMapper;
    private final CompanyRepository companyRepository;

    public ContactService(ContactRepository contactRepository, ContactMapper contactMapper, CompanyRepository companyRepository) {
        this.contactRepository = contactRepository;
        this.contactMapper = contactMapper;
        this.companyRepository = companyRepository;
    }

    public List<ContactDto1> findAll() {
        List<Contact> sortedFilteredContacts = contactRepository.findAll().stream()
                .filter(contact -> contact.getStatus() == Status.ACTIVE)
                .sorted(Comparator.comparing(Contact::getLastName))
                .collect(Collectors.toList());
        List<ContactDto1> contacts = new ArrayList<>();
        sortedFilteredContacts.forEach(contact -> contacts.add(contactMapper.convertToDtoForFindAll(contact)));
        return contacts;
    }

    public ContactDto2 findById(Long id) {
        return contactMapper.convertToDtoForFindById(contactRepository.findById(id));
    }

    public void save(ContactDto3 contactDto3) throws NumberParseException {
        PhoneNumberUtil phoneNumberUtil = PhoneNumberUtil.getInstance();
        Phonenumber.PhoneNumber phoneNumber = phoneNumberUtil.parse(contactDto3.getPhoneNumber(), "HU");
        if (phoneNumberUtil.isValidNumber(phoneNumber)) {
            contactRepository.save(contactMapper.convertToEntityForSave(
                    contactDto3,
                    companyRepository.findById(contactDto3.getCompanyId()),
                    Status.ACTIVE));
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
