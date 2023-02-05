package com.teamwebsoft.controllers;

import com.teamwebsoft.models.Contact;
import com.teamwebsoft.repositories.ContactRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.sql.Date;
import java.util.Random;

@RestController
public class ContactController {

    @Autowired
    private ContactRepository contactRepository;

    public Contact saveContactInquiryDetails(@RequestBody Contact contact){
        contact.setContactId(getServiceReqNumber());
        contact.setCreatedAt(new Date(System.currentTimeMillis()));
        return contactRepository.save(contact);
    }

    private String getServiceReqNumber() {
        Random random = new Random();
        int number = random.nextInt(999999999-9999)+9999;
        return "SR"+number;
    }

}
