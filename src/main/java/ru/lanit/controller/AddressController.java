package ru.lanit.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;
import ru.lanit.dto.RequestAddressDto;
import ru.lanit.exception.ValidateException;
import ru.lanit.service.AddressService;
import ru.lanit.service.PersonService;

@Controller
public class AddressController {

    private PersonService personService;
    private AddressService addressService;

    @Autowired
    public AddressController(PersonService personService, AddressService addressService) {
        this.personService = personService;
        this.addressService = addressService;
    }

    @RequestMapping(value = "/address", method = RequestMethod.GET)
    public ModelAndView showFrom() {
        ModelAndView result = new ModelAndView();
        result.addObject("persons", personService.getList());
        return result;
    }

    @RequestMapping(value = "/address", method = RequestMethod.POST)
    public ModelAndView save(@RequestParam(required = false) String person,
                             @RequestParam(required = false) String street,
                             @RequestParam(required = false) String house,
                             @RequestParam(required = false) String flat) {
        boolean existError = false;
        ModelAndView result = new ModelAndView();
        try {
            addressService.save(new RequestAddressDto(person, street, house, flat));
        } catch (ValidateException e) {
            existError = true;
            result.addObject("errorMessage", e.getMessage());
        }
        if (existError) {
            result.setViewName("index");
        } else {
            result.setViewName("redirect:statictic");
        }
        return result;
    }
}
