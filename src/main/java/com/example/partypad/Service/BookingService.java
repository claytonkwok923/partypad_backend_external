package com.example.partypad.Service;


import com.example.partypad.entity.Booking;

import java.util.List;

public interface BookingService {

    List<Booking> findAll() ;

//    List<Booking> findByUsername(String username);

    List<Booking> findByGuest(String guest);

    List<Booking> findByHost(String host);

    Booking findById(int id) ;

    //add or update
    Booking save(Booking booking) ;


    //delete
    void deleteById(int id) ;
}
