package br.tec.dimensa.contactmanager.api.controller;

import br.tec.dimensa.contactmanager.api.contract.ContactRestContract;
import br.tec.dimensa.contactmanager.api.dto.input.ContactInput;
import br.tec.dimensa.contactmanager.api.dto.output.ContactOutput;
import br.tec.dimensa.contactmanager.model.Contact;
import br.tec.dimensa.contactmanager.service.implementation.ContactService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.util.UriComponentsBuilder;

import java.net.URI;
import java.util.List;

@RestController
public class ContactRest implements ContactRestContract {
    @Autowired
    private ContactService contactService;

    @Override
    public ResponseEntity<ContactOutput> findContactById(@PathVariable Long id) {
        try {
            Contact contact = contactService.findContactById(id);
            return ResponseEntity.ok(ContactOutput.converter(contact));

        } catch (Exception e) {
            return ResponseEntity.notFound().build();

        }
    }

    @Override
    public ResponseEntity<List<ContactOutput>> getAllContacts() {
        try {
            List<Contact> contacts = contactService.getAllContacts();
            return ResponseEntity.ok(ContactOutput.converter(contacts));

        } catch (Exception e) {
            return ResponseEntity.badRequest().build();

        }
    }

    @Override
    public ResponseEntity<ContactOutput> createNewContact(ContactInput contactInput, UriComponentsBuilder uriBuilder) {
        try {
            Contact contact = contactService.createNewContact(contactInput);
            URI uri = uriBuilder.path("/{id}").buildAndExpand(contact.getId()).toUri();

            return ResponseEntity.created(uri).body(ContactOutput.converter(contact));

        } catch (Exception e) {
            return ResponseEntity.badRequest().build();

        }
    }

    @Override
    public ResponseEntity<ContactOutput> updateContactById(Long id, ContactInput contactInput) {
        try {
            Contact contact = contactService.updateContactById(id, contactInput);
            return ResponseEntity.ok(ContactOutput.converter(contact));

        } catch (Exception e) {
            return ResponseEntity.notFound().build();

        }
    }

    @Override
    public ResponseEntity<Void> deleteContactById(Long id) {
        try {
            contactService.deleteContactById(id);
            return ResponseEntity.noContent().build();

        } catch (Exception e) {
            return ResponseEntity.notFound().build();

        }
    }


}
