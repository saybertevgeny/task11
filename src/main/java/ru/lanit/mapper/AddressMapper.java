package ru.lanit.mapper;

import org.springframework.stereotype.Component;
import ru.lanit.dto.AddressDto;
import ru.lanit.entity.Address;

@Component
public class AddressMapper {

    public AddressDto map(Address address) {
        return new AddressDto(
                address.getId(),
                address.getStreet() + " " + address.getHouse() + " " + address.getFlat()
        );
    }
}
