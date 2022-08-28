package Classes;

import Person.PersonFieldReade;
import java.time.LocalDateTime;

public class CollectionPerson {
    private long id = 1;

    PersonFieldReade PersonFieldsReader = new PersonFieldReade();

    public Person createPerson() {
        return new Person(getId(),
                PersonFieldsReader.readName(),
                PersonFieldsReader.readCoordinates(),
                LocalDateTime.now(),
                PersonFieldsReader.readColor(),
                PersonFieldsReader.readColorHair(),
                PersonFieldsReader.readCountry(),
                PersonFieldsReader.readLocation());
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id++;
    }
}
