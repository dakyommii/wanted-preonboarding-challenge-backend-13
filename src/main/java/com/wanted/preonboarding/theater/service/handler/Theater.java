package com.wanted.preonboarding.theater.service.handler;

import com.wanted.preonboarding.theater.dto.RequestMessage;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
public class Theater {

    public void enter(Audience audience){
        // 티켓 없으면 입장 불가
        if(audience==null &&!audience.hasTicket()){
            throw new RuntimeException("입장할 수 없습니다.");
        }
    }
}
