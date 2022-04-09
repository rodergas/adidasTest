package com.adidas.test.subscription.domain;

import lombok.Builder;
import lombok.Getter;

import java.util.Date;

@Builder
@Getter
public class CreateSubscriptionEvent {
        private String email;
        private String gender;
        private Date birthDate;
        private Boolean isConsentFlagChecked;
        private String campaignId;
}
