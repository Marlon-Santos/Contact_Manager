package br.tec.dimensa.contactmanager.model;

import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.apache.commons.text.WordUtils;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import java.time.LocalDateTime;
import java.util.Objects;

@Entity
@NoArgsConstructor
@Getter
@Setter
@EqualsAndHashCode(of = {"id"})
public class Contact {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String name;
    private String email;
    private String phoneNumber;
    private String birthDate;
    private LocalDateTime lastModified = LocalDateTime.now();

    public Contact(String name, String email, String phoneNumber, String birthDate) {
        this.name = Objects.nonNull(name) ? WordUtils.capitalize(name) : null;
        this.email = email;
        this.phoneNumber = phoneNumber;
        this.birthDate = birthDate;
        lastModified = LocalDateTime.now();

        validate();

    }

    public void validate() {
        if (Objects.isNull(name)) throw new RuntimeException("name cannot be null");
        if (Objects.isNull(email)) throw new RuntimeException("email cannot be null");
        if (Objects.isNull(phoneNumber)) throw new RuntimeException("phoneNumber cannot be null");

        if (name.isBlank() || name.trim().length() < 3) {
            throw new RuntimeException("name must contain least 3 letters");

        }

        //Regex validates if a string is in an email format
        if (email.isBlank() || email.trim().length() < 3 ||
                !email.matches("([a-zA-Z0-9]+(?:[._+-][a-zA-Z0-9]+)*)@([a-zA-Z0-9]+(?:[.-][a-zA-Z0-9]+)*[.][a-zA-Z]{2,})")) {
            throw new RuntimeException("email needs to be valid xxxx@xxxxx.xxx");

        }

        //Regex validates if it contains only numbers
        if (phoneNumber.isBlank() || !phoneNumber.matches("[0-9]*")) {
            throw new RuntimeException("phoneNumber needs to be valid");

        }

        //Regex validates if the string is in dd/mm/yyyy format
        if (Objects.nonNull(birthDate) && !birthDate.isBlank() && !birthDate.matches("\\d{2}/\\d{2}/\\d{4}")) {
            throw new RuntimeException("birthDate needs to be valid dd/mm/yyyy");

        }

    }

}
