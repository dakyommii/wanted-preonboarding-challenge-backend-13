package com.wanted.preonboarding.theater.service;

import com.wanted.preonboarding.theater.dto.RequestMessage;
import com.wanted.preonboarding.theater.service.handler.*;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class TheaterService {
    private final Theater theater;

    public String enter(Audience audience){
        /*
            티켓 금액: 100
            티켓 개수: 20000
         */
        TicketSeller ticketSeller =  new TicketSeller(new TicketOffice(20000L, new Ticket(100L)));
        Ticket ticket = ticketSeller.pubTicket();   // 티켓 발급

        /*
            티켓 없음 -> 구매
            * invitation: 예약증
         */
        if(!audience.hasInvitation()) {
            audience.minusAmount(ticket.getFee());  // 소지한 금액 차감
            ticketSeller.plusAmount(ticket.getFee());   // 판매 금액 추가
        }

        // 티켓 세팅
        audience.setTicket(ticket);
        theater.enter(audience);

        return "Have a good time.";

    }
}
