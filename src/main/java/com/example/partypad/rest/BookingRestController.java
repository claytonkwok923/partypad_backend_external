package com.example.partypad.rest;


import com.example.partypad.Service.BookingService;
import com.example.partypad.Service.RoomService;
import com.example.partypad.entity.Booking;
import com.example.partypad.entity.Room;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.security.Principal;
import java.util.List;

@RestController
@RequestMapping("/api")
public class BookingRestController {

    private BookingService bookingService ;

    private RoomService roomService ;

    @Autowired
    public BookingRestController(BookingService bookingService,RoomService roomService) {
        this.bookingService = bookingService;
        this.roomService = roomService ;
    }


//    @GetMapping("/bookings")
//    public List<Booking> findByUsername(Principal principal) {
//        String username = principal.getName();
//        return bookingService.findByUsername(username) ;
//    }

    @GetMapping("/bookings/guest")
    public List<Booking> findByGuest(Principal principal) {
        String username = principal.getName();
        return bookingService.findByGuest(username) ;
    }


    @GetMapping("/bookings/host")
    public List<Booking> findByHost(Principal principal) {
        String username = principal.getName();
        return bookingService.findByHost(username) ;
    }






    @GetMapping("/bookings/{bookingId}")
    public Booking getBooking(@PathVariable int bookingId) {

        Booking booking = bookingService.findById(bookingId);

        if (booking == null) {
            throw new RuntimeException("Booking id not found - " + bookingId);
        }

        return booking;
    }




    @PostMapping("/bookings")
    public Booking addBooking(@RequestBody Booking booking, Principal principal) {
//        String username = jwtUtils.extractUsername(jwtToken);
        String username = principal.getName();
        booking.setGuest(username);
        Room room = roomService.findById(booking.getRoomId()) ;
        booking.setRoom(room);
        return bookingService.save(booking) ;
    }

    @PutMapping("/bookings")
    public Booking updateEmployee(@RequestBody Booking booking) {

        Booking dbBooking = bookingService.save(booking);

        return bookingService.save(booking);
    }

    @DeleteMapping("/bookings/{bookingId}")
    public String deleteBooking(@PathVariable int bookingId) {

        Booking tempBooking = bookingService.findById(bookingId);

        // throw exception if null

        if (tempBooking == null) {
            throw new RuntimeException("Booking id not found - " + bookingId);
        }

        bookingService.deleteById(bookingId);

        return "Deleted booking id - " + bookingId;
    }


}
