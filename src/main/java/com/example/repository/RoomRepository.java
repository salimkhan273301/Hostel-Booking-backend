package com.example.repository;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.example.model.Room;

import java.util.List;


@Repository
public interface RoomRepository extends CrudRepository<Room, Long> {

    List<Room> findAll();
}