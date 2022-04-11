package com.adidas.test.subscription.domain;

import lombok.Getter;

import javax.persistence.*;
import java.util.Date;

@Getter
@Entity
@Table(name = "subscriptions")
public class Subscription {
        @Id
        @GeneratedValue(strategy = GenerationType.AUTO)
        private long id;
        private String email;
        private String gender;
        private Date birthDate;
        private Boolean isConsentFlagChecked;
        private String campaignId;
}
