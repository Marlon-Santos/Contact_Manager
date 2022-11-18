package br.tec.dimensa.contactmanager.service.implementation;

import br.tec.dimensa.contactmanager.api.dto.input.ContactInput;
import br.tec.dimensa.contactmanager.model.Contact;
import br.tec.dimensa.contactmanager.repository.ContactRepository;
import br.tec.dimensa.contactmanager.service.contract.ContactServiceContract;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Objects;
import java.util.Optional;

@Service
public class ContactService implements ContactServiceContract {
    @Autowired
    private ContactRepository contactRepository;

    @Override
    public Contact findContactById(Long id) {
        try {
            if (Objects.isNull(id)) throw new RuntimeException("id cannot be null");

            Optional<Contact> contact = contactRepository.findById(id);
            if (contact.isEmpty()) throw new RuntimeException("Contact not found");

            return contact.get();

        } catch (Exception e) {
            throw new RuntimeException(e);

        }
    }

    @Override
    public Contact findContactByName(String name) {
        try {
            if (Objects.isNull(name)) throw new RuntimeException("name cannot be null");

            Optional<Contact> contact = contactRepository.findByName(name);
            if (contact.isEmpty()) throw new RuntimeException("name not found");

            return contact.get();

        } catch (Exception e) {
            throw new RuntimeException(e);

        }
    }

    @Override
    public boolean isContactRepeat(String name) {
        try {
            findContactByName(name);
            return true;

        } catch (Exception e) {
            return false;

        }
    }

    @Override
    public List<Contact> getAllContacts() {
        try {
            return contactRepository.findAll();

        } catch (Exception e) {
            throw new RuntimeException(e);

        }

    }

    @Override
    public Contact createNewContact(ContactInput contactInput) {
        try {
            Contact contact = contactInput.toContact();
            if (isContactRepeat(contact.getName())) throw new RuntimeException("contact already exists");

            return contactRepository.save(contact);

        } catch (Exception e) {
            throw new RuntimeException(e);

        }

    }

    @Override
    public Contact updateContactById(Long id, ContactInput contactInput) {
        try {
            Contact contact = contactInput.toContact();
            if (isContactRepeat(contact.getName())) throw new RuntimeException("contact already exists");

            Contact currentContact = findContactById(id);
            BeanUtils.copyProperties(contact, currentContact, "id");

            return contactRepository.save(currentContact);

        } catch (Exception e) {
            throw new RuntimeException(e);

        }
    }

    @Override
    public void deleteContactById(Long id) {
        Contact contact = findContactById(id);
        contactRepository.delete(contact);

    }
}
