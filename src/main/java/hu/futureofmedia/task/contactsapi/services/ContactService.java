package hu.futureofmedia.task.contactsapi.services;

import com.google.i18n.phonenumbers.NumberParseException;
import com.google.i18n.phonenumbers.PhoneNumberUtil;
import com.google.i18n.phonenumbers.Phonenumber;
import hu.futureofmedia.task.contactsapi.entities.Contact;
import hu.futureofmedia.task.contactsapi.entities.Status;
import hu.futureofmedia.task.contactsapi.entities.dto.ContactDto;
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

    public List<ContactDto> findAll() {
        List<Contact> sortedFilteredContacts = contactRepository.findAll().stream()
                .filter(contact -> contact.getStatus().equals(Status.ACTIVE))
                .sorted(Comparator.comparing(Contact::getLastName))
                .collect(Collectors.toList());
        List<ContactDto> contacts = new ArrayList<>();
        sortedFilteredContacts.forEach(contact -> contacts.add(contactMapper.convertToDtoForFindAll(contact)));
        return contacts;
    }

    public ContactDto findById(Long id) {
        return contactMapper.convertToDtoForFindById(contactRepository.findById(id));
    }

    public void save(ContactDto contactDto) throws NumberParseException {
        PhoneNumberUtil phoneNumberUtil = PhoneNumberUtil.getInstance();
        Phonenumber.PhoneNumber phoneNumber = phoneNumberUtil.parse(contactDto.getPhoneNumber(), "HU");
        if (phoneNumberUtil.isValidNumber(phoneNumber)) {
            contactRepository.save(contactMapper.convertToEntityForSave(
                    contactDto,
                    companyRepository.findById(contactDto.getCompanyId())));
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
