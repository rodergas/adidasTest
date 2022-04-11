package com.adidas.test.email.domain;
import lombok.Getter;
import lombok.NonNull;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import java.util.Date;

@Getter
public class Subscription {
    @NotBlank(message = "email is mandatory")
    @Email(message = "email is not valid")
    private String email;
    private String firstName;
    private String gender;
    @NotNull(message = "birthDate is mandatory")
    private Date birthDate;
    @NotNull(message = "isConsentFlagChecked is mandatory")
    private Boolean isConsentFlagChecked;
    @NotBlank(message = "campaignId is mandatory")
    private String campaignId;
}
