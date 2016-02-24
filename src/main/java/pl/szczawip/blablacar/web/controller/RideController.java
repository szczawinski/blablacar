package pl.szczawip.blablacar.web.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import pl.szczawip.blablacar.domain.Ride;
import pl.szczawip.blablacar.service.impl.BlaBlaService;

import java.util.List;

@Controller
public class RideController {

    @Autowired
    private BlaBlaService service;

    @RequestMapping("/rides")
    @ResponseBody
    public List<Ride> rides() {
        return service.findRides();
    }
}
