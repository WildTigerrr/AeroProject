package com.wildtigerrr.mainlogic;

import com.wildtigerrr.mainlogic.enums.ArrDepStatus;
import com.wildtigerrr.mainlogic.enums.FlightStatus;

import java.util.Calendar;
import java.util.List;

/**
 * Created by WildTigerrr on 4/8/2016.
 */
public class Flight {
    private Calendar depDate;
    private Calendar arrDate;
    private String flightNumber;
    private String city;
    private String terminal;
    Enum<FlightStatus> flightStatus;
    Enum<ArrDepStatus> arrDepStatus;
    List<Passenger> passengers;
    List<Ticket> tickets;

    public Calendar getDepDate() {
        return depDate;
    }

    public void setDepDate(Calendar depDate) {
        this.depDate = depDate;
    }

    public Calendar getArrDate() {
        return arrDate;
    }

    public void setArrDate(Calendar arrDate) {
        this.arrDate = arrDate;
    }

    public String getFlightNumber() {
        return flightNumber;
    }

    public void setFlightNumber(String flightNumber) {
        this.flightNumber = flightNumber;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public String getTerminal() {
        return terminal;
    }

    public void setTerminal(String terminal) {
        this.terminal = terminal;
    }

    public Enum<FlightStatus> getFlightStatus() {
        return flightStatus;
    }

    public void setFlightStatus(Enum<FlightStatus> flightStatus) {
        this.flightStatus = flightStatus;
    }

    public Enum<ArrDepStatus> getArrDepStatus() {
        return arrDepStatus;
    }

    public void setArrDepStatus(Enum<ArrDepStatus> arrDepStatus) {
        this.arrDepStatus = arrDepStatus;
    }

    public List<Passenger> getPassengers() {
        return passengers;
    }

    public void setPassengers(List<Passenger> passengers) {
        this.passengers = passengers;
    }

    public List<Ticket> getTickets() {
        return tickets;
    }

    public void setTickets(List<Ticket> tickets) {
        this.tickets = tickets;
    }
}
