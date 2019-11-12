package ru.lanit.validator;

import org.springframework.stereotype.Component;
import ru.lanit.dto.RequestPersonDto;
import ru.lanit.exception.ValidateException;

@Component
public class RequestPersonDtoValidator {

    public void validate(RequestPersonDto requestPersonDto) throws ValidateException {
        if (requestPersonDto.getFirstname() == null || requestPersonDto.getFirstname().equals("")) {
            throw new ValidateException("Все поля обязательны");
        }
        if (requestPersonDto.getMiddlename() == null || requestPersonDto.getMiddlename().equals("")) {
            throw new ValidateException("Все поля обязательны");
        }
        if (requestPersonDto.getLastname() == null || requestPersonDto.getLastname().equals("")) {
            throw new ValidateException("Все поля обязательны");
        }
        if (requestPersonDto.getBirthdate() == null) {
            throw new ValidateException("Все поля обязательны");
        }
    }
}
