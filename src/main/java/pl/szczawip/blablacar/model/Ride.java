package pl.szczawip.blablacar.model;


import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import com.fasterxml.jackson.databind.ser.std.DateSerializer;
import org.hibernate.annotations.*;
import org.hibernate.annotations.CascadeType;

import javax.persistence.*;
import javax.persistence.Entity;
import java.util.Date;


@Entity
public class Ride {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String destinationLocation;

    private String departureLocation;

    private Date departureTime;

    private Date returnTime;

    @ManyToOne
    @Cascade(value = CascadeType.ALL)
    private Driver driver;


    public void setReturnTime(final Date returnTime) {
        this.returnTime = returnTime;
    }

    public String getDestinationLocation() {
        return destinationLocation;
    }

    public String getDepartureLocation() {
        return departureLocation;
    }

    @JsonSerialize(using = DateSerializer.class)
    public Date getDepartureTime() {
        return departureTime;
    }

    @JsonSerialize(using = DateSerializer.class)
    public Date getReturnTime() {
        return returnTime;
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
}