package com.example.partypad.Service;

import com.example.partypad.dao.RoomRepository;
import com.example.partypad.dto.RoomDTO;
import com.example.partypad.entity.Room;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service

public class RoomServiceImpl implements RoomService{

    private RoomRepository roomRepository ;

    @Autowired
    public RoomServiceImpl (RoomRepository roomRepository) {
        this.roomRepository = roomRepository;
    }

    @Override
    public List<Room> findAll() {
        return roomRepository.findAll();
    }

    @Override
    public List<RoomDTO> findAllRoomDTO() {
        return roomRepository.findAllRoomDTO();
    }

    @Override
    public List<RoomDTO> findByUsername(String username) {
        return roomRepository.findByUsername(username);
    }




    @Override
    public Room findById(int theId) {
        Optional<Room> result = roomRepository.findById(theId);

        Room room = null;

        if (result.isPresent()) {
            room = result.get();
        }
        else {
            // we didn't find the employee
            throw new RuntimeException("Did not find room id - " + theId);
        }

        return room;
    }

    @Override
    public Room save(Room room) {
        return roomRepository.save(room);
    }

    @Override
    public void deleteById(int id) {
        roomRepository.deleteById(id);

    }
}
