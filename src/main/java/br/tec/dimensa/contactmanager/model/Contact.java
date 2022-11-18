package br.tec.dimensa.contactmanager.model;

import org.apache.commons.text.WordUtils;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import java.util.Objects;

@Entity
public class Contact {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    private String name;
    private String email;
    private String phoneNumber;
    private String birthDate;

    public Contact() {
    }

    public Contact(String name, String email, String phoneNumber, String birthDate) {
        this.name = Objects.nonNull(name) ? WordUtils.capitalize(name) : null;
        this.email = email;
        this.phoneNumber = phoneNumber;
        this.birthDate = birthDate;

        validate();

    }

    public void validate() {
        if (Objects.isNull(name)) throw new RuntimeException("name cannot be null");
        if (Objects.isNull(email)) throw new RuntimeException("email cannot be null");
        if (Objects.isNull(phoneNumber)) throw new RuntimeException("phoneNumber cannot be null");

        if (name.isBlank() || name.trim().length() < 3 || !name.matches("/[a-zA-Z\\u00C0-\\u00FF ]+/i"))
            throw new RuntimeException("name must contain least 3 letters");

        if (email.isBlank() || email.trim().length() < 3 || !email.matches("^[A-Z0-9._%+-]+@[A-Z0-9.-]+\\\\.[A-Z]{2,6}$"))
            throw new RuntimeException("email needs to be valid");

        if (phoneNumber.isBlank() || !phoneNumber.matches("[0-9]*"))
            throw new RuntimeException("phoneNumber needs to be valid");

        if (!birthDate.isBlank() || !birthDate.matches("\\d{2}/\\d{2}/\\d{4}"))
            throw new RuntimeException("birthDate needs to be valid");

    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
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

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Contact)) return false;
        Contact contact = (Contact) o;
        return id.equals(contact.id);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id);
    }
}
