package br.tec.dimensa.contactmanager.api.dto.input;

import br.tec.dimensa.contactmanager.model.Contact;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;

@NoArgsConstructor
@Getter
@EqualsAndHashCode(of = {"name", "email", "phoneNumber"})
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

}
