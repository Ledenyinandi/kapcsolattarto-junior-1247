package hu.futureofmedia.task.contactsapi;

import hu.futureofmedia.task.contactsapi.entities.Status;
import hu.futureofmedia.task.contactsapi.entities.dto.ContactDto1;
import hu.futureofmedia.task.contactsapi.entities.dto.ContactDto3;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.boot.web.server.LocalServerPort;
import org.springframework.http.*;
import org.springframework.test.annotation.DirtiesContext;
import java.util.Arrays;
import java.util.List;

@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
@DirtiesContext(classMode = DirtiesContext.ClassMode.BEFORE_EACH_TEST_METHOD)
public class ContactControllerIntegrationTest {

    @LocalServerPort
    private Integer port;
    private final String BASE_URL = "http://localhost:";
    private TestRestTemplate testRestTemplate = new TestRestTemplate();

    @Test
    public void testSave_shouldAddOneContact() {
        HttpHeaders headers = new HttpHeaders();
        headers.setContentType(MediaType.APPLICATION_JSON);
        HttpEntity<ContactDto3> httpEntity = new HttpEntity<>(new ContactDto3(1L, "Szabó", "János", 2L,
                "szj@gmail.com", "+36709876543", "comment", Status.ACTIVE), headers);
        ResponseEntity<String> postResponse = testRestTemplate.postForEntity(BASE_URL + port + "/contact", httpEntity, String.class);
        Assertions.assertEquals(HttpStatus.OK, postResponse.getStatusCode());
        ContactDto3 countryDto3 = testRestTemplate.getForObject(BASE_URL + port + "/contact/1", ContactDto3.class);
        Assertions.assertEquals("Szabó", countryDto3.getLastName());
    }

    @Test
    public void testFindAll_shouldReturnListOfActiveContacts() {
        ResponseEntity<ContactDto1[]> responseEntity = testRestTemplate.getForEntity(BASE_URL + port + "/contact", ContactDto1[].class);
        List<ContactDto1> actual = Arrays.asList(responseEntity.getBody());
        Assertions.assertEquals(1, actual.size());
    }

    @Test
    public void testUpdate_shouldUpdateContactByTheGivenId() {
        HttpHeaders headers = new HttpHeaders();
        headers.setContentType(MediaType.APPLICATION_JSON);
        HttpEntity<ContactDto3> httpEntity = new HttpEntity<>(new ContactDto3(1L, "Kovács", "Zoltán", 3L,
                "kz@gmail.com", "+36706548392", "comment", Status.ACTIVE), headers);
        testRestTemplate.put(BASE_URL + port + "/contact/1", httpEntity, String.class);
        ContactDto3 contactDto3 = testRestTemplate.getForObject(BASE_URL + port + "/contact/1", ContactDto3.class);
        Assertions.assertEquals("kz@gmail.com", contactDto3.getEmail());
    }

    @Test
    public void testFindById_shouldReturnContactByTheGivenId() {
        ContactDto3 contactDto3 = testRestTemplate.getForObject(BASE_URL + port + "/contact/1", ContactDto3.class);
        Assertions.assertEquals("János", contactDto3.getFirstName());
    }
}
