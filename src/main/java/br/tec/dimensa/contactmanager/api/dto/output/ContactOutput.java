package br.tec.dimensa.contactmanager.api.dto.output;

import br.tec.dimensa.contactmanager.model.Contact;
import lombok.EqualsAndHashCode;
import lombok.Getter;

import java.time.LocalDateTime;
import java.util.List;
import java.util.stream.Collectors;

@Getter
@EqualsAndHashCode(of = {"name", "email", "phoneNumber"})
public class ContactOutput {
    private final Long id;
    private final String name;
    private final String email;
    private final String phoneNumber;
    private final String birthDate;
    private LocalDateTime lastModified;

    public ContactOutput(Long id, String name, String email, String phoneNumber, String birthDate, LocalDateTime lastModified) {
        this.id = id;
        this.name = name;
        this.email = email;
        this.phoneNumber = phoneNumber;
        this.birthDate = birthDate;
        this.lastModified = lastModified;
    }

    public static ContactOutput converter(Contact contact) {
        return new ContactOutput(contact.getId(),
                contact.getName(), contact.getEmail(), contact.getPhoneNumber(), contact.getBirthDate(), contact.getLastModified());
    }

    public static List<ContactOutput> converter(List<Contact> contacts) {
        return contacts.stream().map(ContactOutput::converter).collect(Collectors.toList());
    }
}
