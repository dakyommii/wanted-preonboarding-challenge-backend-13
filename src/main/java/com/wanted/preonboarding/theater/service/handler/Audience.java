package com.wanted.preonboarding.theater.service.handler;

public class Audience {
    private final Bag bag;


    public Audience(Bag bag){
        this.bag = bag;
    }

    public Boolean hasInvitation() {return this.bag!=null && this.bag.hasInvitation();}

    public void minusAmount(long fee) {
        this.bag.minusAmount(fee);
    }

    public void setTicket(Ticket ticket) {
        this.bag.setTicket(ticket);
    }

    public boolean hasTicket() {
        return this.bag.hasTicket();
    }

//    public Bag getBag(){ return bag;}
}