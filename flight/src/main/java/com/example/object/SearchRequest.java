package com.example.object;

public class SearchRequest {

    private String flightId;
    private String departAirport;
    private String arriveAirport;

    // Add other request parameters here

    // Getters and setters


    public SearchRequest(String flightId, String departAirport, String arriveAirport) {
        this.flightId = flightId;
        this.departAirport = departAirport;
        this.arriveAirport = arriveAirport;
    }

    public String getFlightId() {
        return flightId;
    }

    public void setFlightId(String flightId) {
        this.flightId = flightId;
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
}