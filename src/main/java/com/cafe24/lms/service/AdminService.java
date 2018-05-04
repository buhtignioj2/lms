package com.cafe24.lms.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.cafe24.lms.domain.Rent;
import com.cafe24.lms.domain.Reservation;
import com.cafe24.lms.repository.RentRepository;
import com.cafe24.lms.repository.ReservationRepository;

@Service
@Transactional
public class AdminService {

    @Autowired
    private RentRepository rentRepository;
    
    @Autowired 
    private ReservationRepository reservationRepository;

    public List<Rent> findAllRent() {
	return rentRepository.findAll();
    }

    public List<Reservation> findAllReserve() {
	return reservationRepository.findAll();
    }
    
    
}
