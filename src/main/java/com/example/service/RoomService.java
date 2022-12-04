package com.example.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


import com.example.model.Categorys;
import com.example.model.Room;
import com.example.repository.CategoryRepository;
import com.example.repository.RoomRepository;

@Service
public class RoomService {
    private final RoomRepository roomRepository;
    private final CategoryRepository categoryRepository;

    @Autowired
    public RoomService(RoomRepository roomRepository,
                       CategoryRepository categoryRepository) {
        this.roomRepository = roomRepository;
        this.categoryRepository = categoryRepository;
    }

    public List<Room> getAllRooms() {
        return roomRepository.findAll();
    }

    public String findByCategoryName(String name) {
        Categorys category = categoryRepository.getCategoryByCategoryName(name);
        List<Room> rooms = filterByCategory(category);

        StringBuilder sb = new StringBuilder();
        for (Room room : rooms) {
            sb.append(room).append("</br>");
        }
        return sb.toString();
    }

    public List<Room> getAvailableRooms() {
        List<Room> list=new ArrayList<Room>();
        for (Room room : availableRooms()) {
            list.add(room);
        }
        return list;
    }

    public List<Room> filterByCategory(Categorys category) {
        List<Room> result = new ArrayList<>();
        for (Room room : roomRepository.findAll()) {
            if (room.getCategory().equals(category)) {
                result.add(room);
            }
        }
        return result;
    }

    public List<Room> availableRooms() {
        List<Room> result = new ArrayList<>();
        for (Room room : roomRepository.findAll()) {
            if (room.getAvailable() == 1) {
                result.add(room);
            }
        }
        return result;
    }

	public Room saveRoom(Room room) {
		
		return roomRepository.save(room) ;
	}
}
