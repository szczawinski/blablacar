package pl.szczawip.blablacar.web.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import pl.szczawip.blablacar.model.Ride;
import pl.szczawip.blablacar.service.BlaBlaService;

import java.util.List;

@RestController
public class RideController {

    @Autowired
    private BlaBlaService service;

    @RequestMapping("/rides")
    public List<Ride> rides() {
        return service.findRides();
    }

}
