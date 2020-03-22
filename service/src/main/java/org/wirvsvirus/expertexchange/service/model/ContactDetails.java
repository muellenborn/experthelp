package org.wirvsvirus.expertexchange.service.model;

import javax.validation.constraints.Email;

public class ContactDetails {
    /**
     * E-Mail-Adresse
     */
    @Email
    private String email;
    /**
     * Kontaktnummern.
     */
    private String phoneNumber;
    private String mobileNumber;
    private String faxNumber;

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public String getMobileNumber() {
        return mobileNumber;
    }

    public void setMobileNumber(String mobileNumber) {
        this.mobileNumber = mobileNumber;
    }

    public String getFaxNumber() {
        return faxNumber;
    }

    public void setFaxNumber(String faxNumber) {
        this.faxNumber = faxNumber;
    }
}
