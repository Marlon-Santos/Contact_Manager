package br.tec.dimensa.contactmanager.repository;

import br.tec.dimensa.contactmanager.model.Contact;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface ContactRepository extends JpaRepository<Contact, Long> {
    Optional<Contact> findByName(String name);
}
