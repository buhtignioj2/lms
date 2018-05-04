package com.cafe24.lms.service;

import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;
import java.util.List;
import java.util.Locale;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.cafe24.lms.domain.Item;
import com.cafe24.lms.domain.Rent;
import com.cafe24.lms.domain.Reservation;
import com.cafe24.lms.domain.User;
import com.cafe24.lms.repository.ItemService;
import com.cafe24.lms.repository.RentRepository;
import com.cafe24.lms.repository.ReservationRepository;
import com.cafe24.lms.repository.UserRepository;

@Service
@Transactional
public class ReservationService {

    @Autowired
    private ReservationRepository reservationRepository;
    
    @Autowired
    private ItemService itemRepository;
    
    @Autowired
    private UserRepository userRepository;

    @Autowired
    private RentRepository rentRepository;
    
    public void save(Reservation reservation) {
	Rent rent = rentRepository.findReturnDateByItemId( reservation.getItem().getId() );
	
	Calendar cal = new GregorianCalendar(Locale.KOREA);
	cal.setTime( rent.getReturnDate() );
	cal.add(Calendar.DAY_OF_YEAR, 7);

	reservation.setRentDate( rent.getReturnDate() );
	reservation.setReturnDate( new Date(cal.getTimeInMillis()) );
	
	reservationRepository.save( reservation );
    }

    public Item findItem(Long no) {
	return itemRepository.findOne( no );
    }

    public User findUser(Long no) {
	return userRepository.findOne( no );
    }

    public boolean findItem(Reservation reservation) {
	if( reservationRepository.findItemByNo( reservation.getUser().getNo(), reservation.getItem().getId() ) == 0 ) {
	    return false;
	} else {
	    return true;
	}
    }

    public void update(Reservation reservation) {
	itemRepository.update( reservation.getItem().getId() );
	reservationRepository.save( reservation );
    }

    public Long findReservationCount(Long id) {
	return reservationRepository.findReservationCount( id );
    }

}
