package com.adidas.test.publicservice.domain;

import lombok.Builder;
import lombok.Getter;

import java.util.Date;

@Builder
@Getter
public class Subscription {
        private String email;
        private String gender;
        private Date birthDate;
        private Boolean isConsentFlagChecked;
        private String campaignId;
}
