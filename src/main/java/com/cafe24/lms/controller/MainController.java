package com.cafe24.lms.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort.Direction;
import org.springframework.data.web.PageableDefault;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import com.cafe24.lms.domain.Item;
import com.cafe24.lms.domain.Rent;
import com.cafe24.lms.domain.Reservation;
import com.cafe24.lms.repository.ItemService;
import com.cafe24.lms.service.RentService;
import com.cafe24.lms.service.ReservationService;
import com.example.security.Auth;

@Controller
public class MainController {

    @Autowired
    private RentService rentService;

    @Autowired
    private ReservationService reservationService;
    
    @Autowired
    private ItemService itemService;

    @RequestMapping({ "", "/main" })
    public String index(Model model, @PageableDefault(sort = { "id" }, direction = Direction.DESC, size = 3)Pageable pageable) {
	Page<Item> itemPage = itemService.findAll(pageable);
	model.addAttribute("itemPage", itemPage );
	return "main/index";
    }

    @Auth( value=Auth.Role.USER )
    @RequestMapping("/rent/{no}/{userNo}/false")
    public String rent(@PathVariable("no") Long no, @PathVariable("userNo") Long userNo, @ModelAttribute Rent rent,
	    @ModelAttribute Item item, Model model) {
	String msg = null;
	rent.setItem( rentService.findItem( no ) );
	rent.setUser( rentService.findUser( userNo ) );

	if ( rentService.findItem( rent ) == false ) {
	    rentService.update( rent );
	    msg = "정상적으로 대여가 되었습니다.";
	} else {
	    msg = "허튼짓 하지 마세요.";
	}
	model.addAttribute( "msg", msg );

	return "main/rent";
    }

    @Auth( value=Auth.Role.USER )
    @RequestMapping("/rent/{no}/{userNo}/true")
    public String reservation(@PathVariable("no") Long no, @PathVariable("userNo") Long userNo,
	    @ModelAttribute Reservation reservation, @ModelAttribute Item item, Model model) {
	String msg = null;

	reservation.setItem( reservationService.findItem( no ) );
	reservation.setUser( reservationService.findUser( userNo ) );

	if ( reservationService.findItem( reservation ) == false ) {
	    Long count = reservationService.findReservationCount( reservation.getItem().getId());
	    if( count == null ) {
		reservation.setCount( 0L );
	    } else {
		reservation.setCount( count + 1L );
	    }
	    reservationService.save( reservation );

	    msg = "정상적으로 예약이 되었습니다.";
	} else {
	    msg = "이미 예약이 됐습니다.";
	}
	model.addAttribute( "msg", msg );
	return "main/rent";
    }
}
