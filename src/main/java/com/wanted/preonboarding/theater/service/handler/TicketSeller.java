package com.wanted.preonboarding.theater.service.handler;

public class TicketSeller {
    private final TicketOffice ticketOffice;

    public TicketSeller(TicketOffice ticketOffice){
        this.ticketOffice = ticketOffice;
    }

    public TicketOffice getTicketOffice(){
        return ticketOffice;
    }

    public void plusAmount(long amount) {
        ticketOffice.plusAmount(amount);
    }

    public Ticket pubTicket() {
        return this.ticketOffice.getTicket();
    }
}
