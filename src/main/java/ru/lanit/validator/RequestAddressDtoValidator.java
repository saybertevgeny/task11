package ru.lanit.validator;

import org.springframework.stereotype.Component;
import ru.lanit.dto.RequestAddressDto;
import ru.lanit.exception.ValidateException;

@Component
public class RequestAddressDtoValidator {

    public void validate(RequestAddressDto addressDto) throws ValidateException {
        if (addressDto.getStreet() == null || addressDto.getStreet().equals("")) {
            throw new ValidateException("Все поля обязательны");
        }
        if (addressDto.getHouse() == null || addressDto.getHouse().equals("")) {
            throw new ValidateException("Все поля обязательны");
        }
        if (addressDto.getFlat() == null || addressDto.getFlat().equals("")) {
            throw new ValidateException("Все поля обязательны");
        }
    }
}
