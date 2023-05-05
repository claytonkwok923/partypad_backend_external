package com.example.partypad.dao;

import com.example.partypad.dto.RoomDTO;
import com.example.partypad.entity.Room;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface RoomRepository extends JpaRepository<Room,Integer> {

    @Query("SELECT new com.example.partypad.dto.RoomDTO(CAST(r.id AS int),r.title, r.description,CAST(r.price AS int),r.location,CAST(r.guests AS int),CAST(r.size AS int),r.username) FROM Room r")
    List<RoomDTO> findAllRoomDTO();

    @Query("SELECT new com.example.partypad.dto.RoomDTO(CAST(r.id AS int),r.title, r.description,CAST(r.price AS int),r.location,CAST(r.guests AS int),CAST(r.size AS int),r.username) FROM Room r WHERE r.username = :username")
    List<RoomDTO> findByUsername(@Param("username") String username);


//    @Query("SELECT new com.example.partypad.dto.RoomDTO(r.id,r.title, r.description,r.price) FROM Room r")
//    List<RoomDTO> findAllRoomDTO();

}
