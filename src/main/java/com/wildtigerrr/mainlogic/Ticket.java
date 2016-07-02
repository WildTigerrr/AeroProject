package com.wildtigerrr.mainlogic;

import com.wildtigerrr.mainlogic.enums.TicketType;

public class Ticket {
    Enum<TicketType> ticketType;
    double price;

    public Enum<TicketType> getTicketType() {
        return ticketType;
    }

    public void setTicketType(Enum<TicketType> ticketType) {
        this.ticketType = ticketType;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }
}
