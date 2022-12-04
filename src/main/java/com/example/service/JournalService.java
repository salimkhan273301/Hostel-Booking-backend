package com.example.service;

import java.time.LocalDate;
import java.util.Arrays;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.model.BookingJournal;
import com.example.model.Employee;
import com.example.model.Feature;
import com.example.model.Room;
import com.example.repository.BookingJournalRepository;
import com.example.util.PriceCalculator;

@Service
public class JournalService {

    private BookingJournalRepository bookingJournalRepository;

    @Autowired
    public JournalService(BookingJournalRepository bookingJournalRepository) {
        this.bookingJournalRepository = bookingJournalRepository;
    }

    public Room bookRoom(Room room,Employee emp, Feature[] features, int year, int month, int dayOfMonth) {
        LocalDate dateFrom = LocalDate.now();
        LocalDate dateTo = LocalDate.of(year, month, dayOfMonth);

        List<Feature> featuresList = Arrays.asList(features);

        return bookRoom(emp, room, dateFrom, dateTo, featuresList);
    }

    private Room bookRoom(Employee emp, Room room, LocalDate dateFrom, LocalDate dateTo, List<Feature> features) {
        double price = PriceCalculator.getPrice(room, features);
        BookingJournal journalEntry = new BookingJournal(emp, room, dateFrom, dateTo, price);
        return bookingJournalRepository.save(journalEntry).getRoom_id();
    }

    public List<BookingJournal> findallBooking() {
        return bookingJournalRepository.findAll();
    }

    public List<BookingJournal> findBookingUser(long id){
        return bookingJournalRepository.findById(id);
    }
}