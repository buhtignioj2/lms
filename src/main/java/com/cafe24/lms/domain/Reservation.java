package com.cafe24.lms.domain;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Transient;

@Entity
public class Reservation {
    @Id
    @Column(name = "RESERVATION_ID")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long no;

    @Column(name = "count", nullable = true)
    private Long count;

    @Column(name = "rent_date", nullable = false)
    private Date rentDate;

    @Column(name = "return_date", nullable = false)
    private Date returnDate;

    @ManyToOne
    @JoinColumn(name = "USER_ID")
    private User user;

    @ManyToOne
    @JoinColumn(name = "ITEM_ID")
    private Item item;

    @Transient
    private String categoryName;

    @Transient
    private String itemTitle;
    
    public Long getNo() {
	return no;
    }

    public void setNo(Long no) {
	this.no = no;
    }

    public Long getCount() {
	return count;
    }

    public void setCount(Long count) {
	this.count = count;
    }

    public Date getRentDate() {
	return rentDate;
    }

    public void setRentDate(Date rentDate) {
	this.rentDate = rentDate;
    }

    public Date getReturnDate() {
	return returnDate;
    }

    public void setReturnDate(Date returnDate) {
	this.returnDate = returnDate;
    }

    public User getUser() {
	return user;
    }

    public void setUser(User user) {
	this.user = user;
    }

    public Item getItem() {
	return item;
    }

    public void setItem(Item item) {
	this.item = item;
    }

    @Override
    public String toString() {
	return "Reservation [no=" + no + ", count=" + count + ", rentDate=" + rentDate + ", returnDate=" + returnDate
		+ ", user=" + user + ", item=" + item + "]";
    }

}
