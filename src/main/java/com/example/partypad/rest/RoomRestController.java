package com.example.partypad.rest;


import com.example.partypad.Security.config.JwtService;
import com.example.partypad.Service.RoomService;
import com.example.partypad.dto.RoomDTO;
import com.example.partypad.entity.Room;
import jakarta.servlet.http.HttpServletRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.security.Principal;
import java.util.List;

@RestController
@RequestMapping("/api")
public class RoomRestController {

    private RoomService roomService ;

    private JwtService jwtService ;

//    @Autowired
//    private JwtUtils jwtUtils;

    @Autowired
    public RoomRestController(RoomService roomService ,JwtService jwtservice) {
        this.roomService = roomService;
        this.jwtService = jwtservice ;
    }

    @GetMapping("/allRooms")
    public List<RoomDTO> findAll() {
        return roomService.findAllRoomDTO() ;
    }
//
//    @GetMapping("/rooms")
//    public List<RoomDTO> findByUsername(Principal principal) {
//
//        String username = principal.getName();
//        return roomService.findByUsername(username) ;
//    }

    @GetMapping("/roomsByUsername")
    public List<RoomDTO> findByUsername(HttpServletRequest request) {
        System.out.println("@GetMapping(\"/roomsByUsername\") run");
        String token = request.getHeader("Authorization").substring(7) ;
        String username = jwtService.extractUsername(token);
//        String username = principal.getName();
        System.out.println("/roomsByUsername username :"+username);

        return roomService.findByUsername(username) ;
    }

    @GetMapping("/rooms/{roomId}")
    public Room getRoom(@PathVariable int roomId) {

        Room room = roomService.findById(roomId);

        if (room == null) {
            throw new RuntimeException("Room id not found - " + roomId);
        }

        return room;
    }




    @PostMapping("/rooms")
    public Room addRoom(@RequestBody Room room, Principal principal) {
//        String username = jwtUtils.extractUsername(jwtToken);
        String username = principal.getName();
        room.setUsername(username);
        return roomService.save(room) ;
    }

    @PutMapping("/rooms")
    public Room updateEmployee(@RequestBody Room room) {

        Room dbRoom = roomService.save(room);

        return roomService.save(room);
    }

    @DeleteMapping("/rooms/{roomId}")
    public String deleteRoom(@PathVariable int roomId) {

        Room tempRoom = roomService.findById(roomId);

        // throw exception if null

        if (tempRoom == null) {
            throw new RuntimeException("Room id not found - " + roomId);
        }

        roomService.deleteById(roomId);

        return "Deleted room id - " + roomId;
    }


}
