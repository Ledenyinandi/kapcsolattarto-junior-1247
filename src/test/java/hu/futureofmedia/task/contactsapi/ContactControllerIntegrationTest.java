package hu.futureofmedia.task.contactsapi;

import hu.futureofmedia.task.contactsapi.entities.dto.ContactDto1;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.boot.web.server.LocalServerPort;
import org.springframework.http.ResponseEntity;
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
    public void testFindAll_shouldReturnListOfActiveContacts() {
        ResponseEntity<ContactDto1[]> responseEntity = testRestTemplate.getForEntity(BASE_URL + port + "/contact", ContactDto1[].class);
        List<ContactDto1> actual = Arrays.asList(responseEntity.getBody());
        Assertions.assertEquals(0, actual.size());
    }
}
