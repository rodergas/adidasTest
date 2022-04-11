package com.adidas.test.publicservice.domain;

import lombok.*;

import java.util.Date;

@Getter
@NoArgsConstructor
public class Subscription {
        private String email;
        private String gender;
        private Date birthDate;
        private Boolean isConsentFlagChecked;
        private String campaignId;
}
