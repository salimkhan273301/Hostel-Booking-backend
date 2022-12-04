package com.example.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.example.model.BookingJournal;

import com.example.service.JournalService;

@RestController
@CrossOrigin(origins="http://localhost:4200")
@RequestMapping("/api/v1/")
public class JournalController {

    private final JournalService journalService;

    @Autowired
    public JournalController(JournalService journalService) {
        this.journalService = journalService;
    }

    @RequestMapping(value = "/booking", method = RequestMethod.GET)
    private List<BookingJournal> findallBooking() {
        return journalService.findallBooking();
    }

    @RequestMapping(value = "/findBookingUser/{userID}", method = RequestMethod.GET)
    private List<BookingJournal> findBookingUser(@PathVariable("userID") long id) {
        return journalService.findBookingUser(id);
    }
}