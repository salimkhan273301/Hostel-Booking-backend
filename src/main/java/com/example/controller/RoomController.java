package com.example.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;

import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.example.model.Employee;
import com.example.model.Feature;
import com.example.model.Room;
import com.example.service.JournalService;
import com.example.service.RoomService;

@RestController
@CrossOrigin(origins="http://localhost:4200")
@RequestMapping("/api/v1/")
public class RoomController {
    private final RoomService roomService;
    private final JournalService journalService;

    @Autowired
    public RoomController(
            RoomService roomService,
            JournalService journalService
    ) {
        this.roomService = roomService;
        this.journalService = journalService;
    }

    @RequestMapping("/findAllRooms")
    private List<Room> findAllRoom() {
        return roomService.getAllRooms();
    }
    @PostMapping("/addroom")
    private Room addRoom( @RequestBody Room room) {
		return roomService.saveRoom(room);
    	
    }

    @RequestMapping("find/category/{name}")
    private String findByCategoryName(@PathVariable String name) {
        return roomService.findByCategoryName(name);
    }

    @RequestMapping("room/available")
    private List<Room> getAvailableRooms() {
        return roomService.getAvailableRooms();
    }

 @PostMapping("/roombook")
    public Room bookRoom(
            @RequestParam("roomId") Room room,
            @RequestParam("userId") Employee emp,
            @RequestParam("featureId") Feature[] features,
            @RequestParam("year") int year,
            @RequestParam("month") int month,
            @RequestParam("dayOfMonth") int dayOfMonth
    ) {
        return journalService.bookRoom(room, emp, features, year, month, dayOfMonth);
    }

}
