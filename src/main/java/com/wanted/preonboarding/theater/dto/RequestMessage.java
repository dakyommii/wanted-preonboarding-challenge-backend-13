package com.wanted.preonboarding.theater.dto;

import com.wanted.preonboarding.theater.service.handler.*;
import com.wanted.preonboarding.theater.service.handler.Invitation;
import lombok.*;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.stereotype.Component;

import java.time.LocalDateTime;

@Builder
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@Component
public class RequestMessage {

    private Long amount;
    private static final String WHEN_PATTERN="yyyy-MM-dd HH:mm:ss";

    @DateTimeFormat(pattern = WHEN_PATTERN)
    private LocalDateTime when;

    public boolean hasInvitation() {
        return this.when!=null;
    }

    public Audience toAudience() {
        Invitation invitation=null;

        if(this.hasInvitation()) {
            invitation=new Invitation(this.when);
        }

        Bag bag=new Bag(invitation,this.amount);
        return new Audience(bag);
    }

}
