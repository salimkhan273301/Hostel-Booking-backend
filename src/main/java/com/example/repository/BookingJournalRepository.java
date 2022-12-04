package com.example.repository;

import java.util.List;


import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.example.model.BookingJournal;

@Repository
public interface BookingJournalRepository extends CrudRepository<BookingJournal, Long> {

    List<BookingJournal> findById(long id);

    List<BookingJournal> findAll();
}
