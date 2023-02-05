package com.teamwebsoft.repositories;

import com.teamwebsoft.models.Contact;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ContactRepository extends JpaRepository<Contact, Long> {
}
