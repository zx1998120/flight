package com.example.data;

import java.time.LocalDateTime;
import java.util.Date;
import java.util.concurrent.TimeUnit;

public class Flight {
    private Integer id;
    private Date departDateTime;
    private Date arriveDateTime;
    private String departAirport;
    private String arriveAirport;
    private String flightNumber;

    public Flight(Integer id, Date departDateTime, Date arriveDateTime, String departAirport, String arriveAirport, String flightNumber) {
        this.id = id;
        this.departDateTime = departDateTime;
        this.arriveDateTime = arriveDateTime;
        this.departAirport = departAirport;
        this.arriveAirport = arriveAirport;
        this.flightNumber = flightNumber;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Date getDepartDateTime() {
        return departDateTime;
    }

    public void setDepartDateTime(Date departDateTime) {
        this.departDateTime = departDateTime;
    }

    public Date getArriveDateTime() {
        return arriveDateTime;
    }

    public void setArriveDateTime(Date arriveDateTime) {
        this.arriveDateTime = arriveDateTime;
    }

    public String getDepartAirport() {
        return departAirport;
    }

    public void setDepartAirport(String departAirport) {
        this.departAirport = departAirport;
    }

    public String getArriveAirport() {
        return arriveAirport;
    }

    public void setArriveAirport(String arriveAirport) {
        this.arriveAirport = arriveAirport;
    }

    public String getFlightNumber() {
        return flightNumber;
    }

    public void setFlightNumber(String flightNumber) {
        this.flightNumber = flightNumber;
    }
    public long getTravelTime() {
        long diffInMilliseconds = Math.abs(arriveDateTime.getTime() - departDateTime.getTime());
        return TimeUnit.MILLISECONDS.toMinutes(diffInMilliseconds); // Convert milliseconds to minutes
    }
}
