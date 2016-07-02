package com.wildtigerrr.mainlogic;

import com.wildtigerrr.mainlogic.enums.Gender;
import com.wildtigerrr.mainlogic.enums.TicketType;

import java.util.Calendar;

public class Passenger {
    Enum<TicketType> ticketType;
    String firstName;
    String lastName;
    String ID;
    String country;
    Calendar date;
    Enum<Gender> gender;

    public Enum<TicketType> getTicketType() {
        return ticketType;
    }

    public void setTicketType(Enum<TicketType> ticketType) {
        this.ticketType = ticketType;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getID() {
        return ID;
    }

    public void setID(String ID) {
        this.ID = ID;
    }

    public String getCountry() {
        return country;
    }

    public void setCountry(String country) {
        this.country = country;
    }

    public Calendar getDate() {
        return date;
    }

    public void setDate(Calendar date) {
        this.date = date;
    }

    public Enum<Gender> getGender() {
        return gender;
    }

    public void setGender(Enum<Gender> gender) {
        this.gender = gender;
    }
}
