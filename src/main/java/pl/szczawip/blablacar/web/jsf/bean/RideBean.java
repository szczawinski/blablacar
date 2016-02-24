package pl.szczawip.blablacar.web.jsf.bean;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import pl.szczawip.blablacar.domain.Ride;
import pl.szczawip.blablacar.service.impl.BlaBlaService;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.RequestScoped;
import java.util.List;

@ManagedBean(name = "rideBean", eager = true)
@RequestScoped
@Component
public class RideBean {

    @Autowired
    public BlaBlaService blaBlaService;

    public List<Ride> getRides() {
        return blaBlaService.findRides();
    }
}
