package com.example.partypad.dao;

import com.example.partypad.entity.Booking;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface BookingRepository extends JpaRepository<Booking,Integer> {


//    @Query("SELECT new com.example.partypad.entity.Booking (b.id, b.checkinDate, b.checkoutDate, b.guests, b.totalPrice, b.status, b.roomId, b.username, b.host) FROM Booking b WHERE b.username = :username")
//    List<Booking> findByUsername(@Param("username") String username);

//    @Query("SELECT new com.example.partypad.entity.Booking(CAST(b.id AS int),b.checkinDate, b.checkoutDate) FROM Booking b WHERE b.guest = :username")
//    List<Booking> findByUsername(@Param("username") String username);

    List<Booking> findByGuest(String guest);

    List<Booking> findByHost(String host);





}
