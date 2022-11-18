package br.tec.dimensa.contactmanager.service.contract;

import br.tec.dimensa.contactmanager.api.dto.input.ContactInput;
import br.tec.dimensa.contactmanager.model.Contact;

import javax.validation.Valid;
import java.util.List;

public interface ContactServiceContract {
    Contact findContactById(Long id);

    Contact findContactByName(String name);

    boolean isContactRepeat(String name);

    List<Contact> getAllContacts();

    Contact createNewContact(@Valid ContactInput contactInput);

    Contact updateContactById(Long id, @Valid ContactInput contactInput);

    void deleteContactById(Long id);


}
