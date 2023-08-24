package com.wanted.preonboarding.theater.service.handler;

public class Bag {
    private Long amount;
    private final Invitation invitation;
    private Ticket ticket;

    public Bag(long amount){
        this(null, amount);
    }
    public Bag(Invitation invitation, long amount){
        this.invitation = invitation;
        this.amount = amount;
    }

    public boolean hasInvitation() {
        return invitation != null;
    }
    public boolean hasTicket() {
        return ticket != null;
    }
    public void setTicket(Ticket ticket) {
        this.ticket = ticket;
    }
    public void minusAmount(long amount) {
        this.amount -= amount;
        if(this.amount<0) {
            throw new RuntimeException("금액이 부족합니다.");
        }
    }

    public Invitation getInvitation() {
        return this.invitation;
    }
    public void plusAmount(long amount) {
        this.amount += amount;
    }
}
