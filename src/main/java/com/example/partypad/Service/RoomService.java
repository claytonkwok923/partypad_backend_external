package com.example.partypad.Service;


import com.example.partypad.dto.RoomDTO;
import com.example.partypad.entity.Room;

import java.util.List;

public interface RoomService {

    List<Room> findAll() ;

    List<RoomDTO> findAllRoomDTO();

    List<RoomDTO> findByUsername(String username);

    Room findById(int id) ;

    //add or update
    Room save(Room room) ;


    //delete
    void deleteById(int id) ;
}
