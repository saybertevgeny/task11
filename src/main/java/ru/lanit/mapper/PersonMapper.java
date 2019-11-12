package ru.lanit.mapper;

import org.springframework.stereotype.Component;
import ru.lanit.dto.PersonDto;
import ru.lanit.entity.Person;

@Component
public class PersonMapper {

    public PersonDto map(Person person) {
        return new PersonDto(
                person.getId(),
                person.getLastName() + " " + person.getFirstName() + " " + person.getMiddleName(),
                person.getBirthDate()
        );
    }
}
