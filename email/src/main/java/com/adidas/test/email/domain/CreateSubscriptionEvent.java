package com.adidas.test.email.domain;
import lombok.Getter;

import java.util.Date;

@Getter
public class CreateSubscriptionEvent {
    private String email;
    private String gender;
    private Date birthDate;
    private Boolean isConsentFlagChecked;
    private String campaignId;
}
