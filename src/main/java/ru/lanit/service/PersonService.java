package ru.lanit.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;
import ru.lanit.dto.PersonDto;
import ru.lanit.dto.RequestPersonDto;
import ru.lanit.entity.Address;
import ru.lanit.entity.Person;
import ru.lanit.exception.ValidateException;
import ru.lanit.mapper.AddressMapper;
import ru.lanit.mapper.PersonMapper;
import ru.lanit.repository.PersonRepository;
import ru.lanit.validator.RequestPersonDtoValidator;

import java.util.ArrayList;
import java.util.List;

@Component
public class PersonService {

    private PersonRepository personRepository;
    private RequestPersonDtoValidator validator;
    private PersonMapper personMapper;
    private AddressMapper addressMapper;

    @Autowired
    public PersonService(
            PersonRepository personRepository,
            RequestPersonDtoValidator validator,
            PersonMapper personMapper,
            AddressMapper addressMapper
    ) {
        this.personRepository = personRepository;
        this.validator = validator;
        this.personMapper = personMapper;
        this.addressMapper = addressMapper;
    }

    public Person save(RequestPersonDto requestPersonDto) throws ValidateException {
        validator.validate(requestPersonDto);
        Person person = new Person();
        person.setFirstName(requestPersonDto.getFirstname())
                .setLastName(requestPersonDto.getLastname())
                .setMiddleName(requestPersonDto.getMiddlename())
                .setBirthDate(requestPersonDto.getBirthdate());

        personRepository.save(person);
        return person;
    }

    @Transactional(readOnly = true)
    public List<PersonDto> getList() {
        List<PersonDto> result = new ArrayList<>();
        List<Person> personList = personRepository.getList(false);
        for (Person person : personList) {
            PersonDto personDto = this.personMapper.map(person);
            List<Address> addressList = person.getAddresses();
            for (Address address : addressList) {
                personDto.getAddresses().add(this.addressMapper.map(address));
            }

            result.add(personDto);
        }
        return result;
    }
}
