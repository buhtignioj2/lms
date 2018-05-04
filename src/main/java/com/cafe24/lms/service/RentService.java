package com.cafe24.lms.service;

import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;
import java.util.Locale;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.cafe24.lms.domain.Item;
import com.cafe24.lms.domain.Rent;
import com.cafe24.lms.domain.User;
import com.cafe24.lms.repository.ItemService;
import com.cafe24.lms.repository.RentRepository;
import com.cafe24.lms.repository.UserRepository;

@Service
@Transactional
public class RentService {

    @Autowired
    private RentRepository rentRepository;

    @Autowired
    private ItemService itemRepository;
    
    @Autowired
    private UserRepository userRepository;

    public Item findItem(Long no) {
	return itemRepository.findOne( no );
    }

    public User findUser(Long no) {
	return userRepository.findOne( no );
    }

    public void save(Rent rent) {
	Calendar cal = new GregorianCalendar(Locale.KOREA);
	cal.setTime(new Date());
	cal.add(Calendar.DAY_OF_YEAR, 7);

	rent.setRentDate( new Date() );
	rent.setReturnDate( new Date(cal.getTimeInMillis()) );
	
	rentRepository.save( rent );
    }
    
    public boolean findItem(Rent rent) {
	if( rentRepository.findOne( rent.getUser().getNo() ) == null ) {
	    return false;
	} else {
	    return true;
	}
    }
    
    public void update(Rent rent) {
	itemRepository.update( rent.getItem().getId() );
//	rentRepository.save( rent );
	save(rent);
    }
}
