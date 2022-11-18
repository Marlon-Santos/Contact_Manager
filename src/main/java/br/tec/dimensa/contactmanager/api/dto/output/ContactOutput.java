package br.tec.dimensa.contactmanager.api.dto.output;

import br.tec.dimensa.contactmanager.model.Contact;

import java.util.List;
import java.util.stream.Collectors;

public class ContactOutput {
    private final Long id;
    private final String name;
    private final String email;
    private final String phoneNumber;
    private final String birthDate;

    public ContactOutput(Long id, String name, String email, String phoneNumber, String birthDate) {
        this.id = id;
        this.name = name;
        this.email = email;
        this.phoneNumber = phoneNumber;
        this.birthDate = birthDate;
    }

    public static ContactOutput converter(Contact contact) {
        return new ContactOutput(contact.getId(),
                contact.getName(), contact.getEmail(), contact.getPhoneNumber(), contact.getBirthDate());
    }

    public static List<ContactOutput> converter(List<Contact> contacts) {
        return contacts.stream().map(ContactOutput::converter).collect(Collectors.toList());
    }

    public Long getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public String getEmail() {
        return email;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public String getBirthDate() {
        return birthDate;
    }
}
