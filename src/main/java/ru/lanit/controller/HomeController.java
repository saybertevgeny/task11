package ru.lanit.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;
import ru.lanit.service.PersonService;

@Controller
public class HomeController {

    private PersonService personService;

    @Autowired
    public HomeController(PersonService personService) {
        this.personService = personService;
    }

    @RequestMapping(value = "/", method = RequestMethod.GET)
    public String getIndex() {
        return "index";
    }

    @RequestMapping(value = "/statictic", method = RequestMethod.GET)
    public ModelAndView getStatistic() {
        ModelAndView result = new ModelAndView();
        result.addObject("persons", personService.getList());
        result.setViewName("statistic");
        return result;
    }
}
