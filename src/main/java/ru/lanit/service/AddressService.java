package ru.lanit.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;
import ru.lanit.dto.RequestAddressDto;
import ru.lanit.entity.Address;
import ru.lanit.entity.Person;
import ru.lanit.exception.NotFoundEntityException;
import ru.lanit.exception.ValidateException;
import ru.lanit.repository.AddressRepository;
import ru.lanit.repository.PersonRepository;
import ru.lanit.validator.RequestAddressDtoValidator;

@Component
public class AddressService {

    private PersonRepository personRepository;
    private RequestAddressDtoValidator validator;
    private AddressRepository addressRepository;

    @Autowired
    public AddressService(PersonRepository personRepository,
                          RequestAddressDtoValidator validator,
                          AddressRepository addressRepository) {
        this.personRepository = personRepository;
        this.validator = validator;
        this.addressRepository = addressRepository;
    }

    @Transactional
    public void save(RequestAddressDto requestPersonDto) throws ValidateException {
        try {
            validator.validate(requestPersonDto);
            Person person = personRepository.getById(requestPersonDto.getPersonId());
            Address address = (new Address()).setPerson(person)
                    .setStreet(requestPersonDto.getStreet())
                    .setFlat(requestPersonDto.getFlat())
                    .setHouse(requestPersonDto.getHouse());
            this.addressRepository.save(address);
        }
        catch (NotFoundEntityException e){
            throw new ValidateException("Пользователь не найден");
        }
    }
}
