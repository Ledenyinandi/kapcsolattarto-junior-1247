package hu.futureofmedia.task.contactsapi;

import hu.futureofmedia.task.contactsapi.controllers.ContactController;
import hu.futureofmedia.task.contactsapi.entities.Company;
import hu.futureofmedia.task.contactsapi.entities.dto.ContactDto1;
import hu.futureofmedia.task.contactsapi.entities.dto.ContactDto2;
import hu.futureofmedia.task.contactsapi.entities.dto.ContactDto3;
import hu.futureofmedia.task.contactsapi.services.ContactService;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.web.servlet.MockMvc;

import java.time.LocalDateTime;
import java.util.List;
import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;
import static org.hamcrest.Matchers.hasSize;
import static org.hamcrest.Matchers.is;

@WebMvcTest(ContactController.class)
public class ContactControllerUnitTest {

    private ContactDto1 contactDto1;
    private ContactDto2 contactDto2;

    @Autowired
    private MockMvc mockMvc;

    @MockBean
    private ContactService contactService;

    @BeforeEach
    public void setup() {
        contactDto1 = new ContactDto1(1L, "Kovács Zoltán", new Company(), "email@email.com", "+36301234567");
        contactDto2 = new ContactDto2(2L, "Szabó", "János", new Company(), "szj@gmail.com",
                "+36709876543", "comment", LocalDateTime.now(), LocalDateTime.now());
    }

    @Test
    public void testFindAll_shouldReturnListOfContacts() throws Exception {
        when(contactService.findAll()).thenReturn(List.of(contactDto1));
        mockMvc.perform(get("/contact"))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$", hasSize(1)))
                .andExpect(jsonPath("$[0].fullName", is("Kovács Zoltán")));
    }

    @Test
    public void testFindById_shouldReturnContact() throws Exception {
        when(contactService.findById(2L)).thenReturn(contactDto2);
        mockMvc.perform(get("/contact/2"))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.id", is(2)))
                .andExpect(jsonPath("$.lastName", is("Szabó")))
                .andExpect(jsonPath("$.phoneNumber", is("+36709876543")));
    }

}
