package pl.szczawip.blablacar.domain;


import org.hibernate.annotations.Cascade;
import org.hibernate.annotations.CascadeType;

import javax.persistence.*;
import java.util.Date;


@Entity
public class Ride {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String destinationLocation;

    private String departureLocation;


    private Date departureTime;

    @ManyToOne
    @Cascade(value = CascadeType.ALL)
    private Driver driver;


    public String getDestinationLocation() {
        return destinationLocation;
    }

    public String getDepartureLocation() {
        return departureLocation;
    }


    public Date getDepartureTime() {
        return departureTime;
    }


    public void setDestinationLocation(final String destinationLocation) {
        this.destinationLocation = destinationLocation;
    }

    public void setDepartureLocation(final String departureLocation) {
        this.departureLocation = departureLocation;
    }

    public void setDepartureTime(final Date departureTime) {
        this.departureTime = departureTime;
    }


    public Driver getDriver() {
        return driver;
    }

    public void setDriver(final Driver driver) {
        this.driver = driver;
    }

    public Long getId() {
        return id;
    }
}