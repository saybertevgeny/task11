package ru.lanit.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;
import ru.lanit.dto.RequestPersonDto;
import ru.lanit.exception.ValidateException;
import ru.lanit.service.PersonService;

@Controller
public class PersonController {

    private PersonService personService;

    @Autowired
    public PersonController(PersonService personService) {
        this.personService = personService;
    }

    @RequestMapping(value = "/person", method = RequestMethod.GET)
    public String showFrom() {
        return "index";
    }

    @RequestMapping(value = "/person", method = RequestMethod.POST)
    public ModelAndView save(@RequestParam(required = false) String firstname,
                             @RequestParam(required = false) String lastname,
                             @RequestParam(required = false) String middlename,
                             @RequestParam(required = false) String birthday) {
        boolean existError = false;
        ModelAndView result = new ModelAndView();
        try {
            personService.save(new RequestPersonDto(firstname, middlename, lastname, birthday));
        } catch (ValidateException e) {
            existError = true;
            result.addObject("errorMessage", e.getMessage());
        }
        if (existError) {
            result.setViewName("index");
        } else {
            result.setViewName("redirect:address");
        }
        return result;
    }
}
