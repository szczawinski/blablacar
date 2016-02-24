package pl.szczawip.blablacar.web.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.SessionAttributes;

import pl.szczawip.blablacar.domain.Ride;
import pl.szczawip.blablacar.service.impl.BlaBlaService;


@Controller
@RequestMapping("/welcome")
@SessionAttributes("formBean")
public class WelcomeController {

    @Autowired
    private BlaBlaService service;


    @ModelAttribute("formBean")
    public FormBean createFormBean() {
        return new FormBean();
    }


    @RequestMapping( method = RequestMethod.GET)
    public String welcome() {
        return "welcome";
    }

    @RequestMapping("add")
    public String add() {
        return "add";
    }


    @RequestMapping( method = RequestMethod.POST)
    public String processSubmit(final FormBean formBean, final BindingResult result, final Model model) {
        if (result.hasErrors()) {
            return null;
        }
        if (formBean.getDeparture().equals("") && formBean.getDestination().equals("")){
            return "search";
        }


        final List<Ride> rides = service.findRides(formBean.getDeparture(), formBean.getDestination());
        model.addAttribute("search", formBean);
        model.addAttribute("rides", rides);


        return "rides";
    }
}

