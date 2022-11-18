package br.tec.dimensa.contactmanager.api.contract;

import br.tec.dimensa.contactmanager.api.dto.input.ContactInput;
import br.tec.dimensa.contactmanager.api.dto.output.ContactOutput;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.util.UriComponentsBuilder;

import javax.validation.Valid;
import java.util.List;

@RequestMapping("/api/v1/contact")
public interface ContactRestContract {
    @GetMapping("/{id}")
    ResponseEntity<ContactOutput> findContactById(@PathVariable Long id);

    @GetMapping
    ResponseEntity<List<ContactOutput>> getAllContacts();

    @PostMapping
    ResponseEntity<ContactOutput> createNewContact(@RequestBody @Valid ContactInput contactInput, UriComponentsBuilder uriBuilder);

    @PutMapping("/{id}")
    ResponseEntity<ContactOutput> updateContactById(@PathVariable Long id, @RequestBody @Valid ContactInput contactInput);

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteContactById(@PathVariable Long id);
}
