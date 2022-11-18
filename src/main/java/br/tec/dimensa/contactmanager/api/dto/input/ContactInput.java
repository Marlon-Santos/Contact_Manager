package br.tec.dimensa.contactmanager.api.dto.input;

import br.tec.dimensa.contactmanager.model.Contact;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;

public class ContactInput {
    @NotBlank
    private String name;
    @NotBlank
    @Email
    private String email;
    @NotBlank
    private String phoneNumber;
    private String birthDate;

    public Contact toContact() {
        return new Contact(name, email, phoneNumber, birthDate);
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

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

    public String getBirthDate() {
        return birthDate;
    }

    public void setBirthDate(String birthDate) {
        this.birthDate = birthDate;
    }
}
