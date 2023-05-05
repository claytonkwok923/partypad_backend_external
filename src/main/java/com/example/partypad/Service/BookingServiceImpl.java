package com.example.partypad.Service;

import com.example.partypad.dao.BookingRepository;
import com.example.partypad.entity.Booking;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service

public class BookingServiceImpl implements BookingService{

    private BookingRepository bookingRepository ;

    @Autowired
    public BookingServiceImpl(BookingRepository bookingRepository) {
        this.bookingRepository = bookingRepository;
    }

    @Override
    public List<Booking> findAll() {
        return bookingRepository.findAll();
    }

//    public List<Booking> findByUsername(String username) {
//        return bookingRepository.findByUsername(username);
//    }

    public List<Booking> findByGuest(String guest) {
        return bookingRepository.findByGuest(guest);
    }

    public List<Booking> findByHost(String host) {
        return bookingRepository.findByHost(host);
    }

    @Override
    public Booking findById(int theId) {
        Optional<Booking> result = bookingRepository.findById(theId);

        Booking booking = null;

        if (result.isPresent()) {
            booking = result.get();
        }
        else {
            // we didn't find the employee
            throw new RuntimeException("Did not find booking id - " + theId);
        }

        return booking;
    }

    @Override
    public Booking save(Booking booking) {
        return bookingRepository.save(booking);
    }

    @Override
    public void deleteById(int id) {
        bookingRepository.deleteById(id);

    }
}
