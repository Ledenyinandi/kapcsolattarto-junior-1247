package hu.futureofmedia.task.contactsapi.entities;

import lombok.Getter;
import lombok.NoArgsConstructor;
import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
@Getter
@NoArgsConstructor
public class Company {

    @Id
    private Long id;
    private String name;

}
