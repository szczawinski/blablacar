package pl.szczawip.blablacar.web.controller;

import org.hibernate.validator.constraints.NotEmpty;

/**
 * Created by szczawip on 4/23/2015.
 */
public class FormBean {

    private String departure;

    private String destination;


    public String getDeparture() {
        return departure;
    }

    public void setDeparture(final String departure) {
        this.departure = departure;
    }

    public String getDestination() {
        return destination;
    }

    public void setDestination(final String destination) {
        this.destination = destination;
    }
}
