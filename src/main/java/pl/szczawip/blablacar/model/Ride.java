package pl.szczawip.blablacar.model;


import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import com.fasterxml.jackson.databind.ser.std.DateSerializer;
import com.google.common.collect.Lists;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import java.util.Date;
import java.util.List;


@Entity
public class Ride {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String arrivalLocation;
    private String departureLocation;
    private Date departureTime;
    private Date returnTime;
    private int price;


    public Ride(){
    }

    public Ride(String departureLocation,String arrivalLocation, Date departureTime){
        this.departureLocation = departureLocation;
        this.arrivalLocation = arrivalLocation;
        this.departureTime = departureTime;
    }


    public void setReturnTime(Date returnTime) {
        this.returnTime = returnTime;
    }

    public String getArrivalLocation() {
        return arrivalLocation;
    }

    public String getDepartureLocation() {
        return departureLocation;
    }

    @JsonSerialize(using=DateSerializer.class)
    public Date getDepartureTime() {
        return departureTime;
    }
    @JsonSerialize(using=DateSerializer.class)
    public Date getReturnTime() {
        return returnTime;
    }
}