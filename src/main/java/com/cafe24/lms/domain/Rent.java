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
public class Rent {

    @Id
    @Column(name = "RENT_ID")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long no;
    
    @Column(name = "rent_date", nullable = false)
    private Date rentDate;
    
    @Column(name = "return_date", nullable = false)
    private Date returnDate;
    
    @ManyToOne
    @JoinColumn(name="USER_ID")
    private User user;
    
    @ManyToOne
    @JoinColumn(name="ITEM_ID")
    private Item item;
    
    @Override
    public String toString() {
	return "Rent [no=" + no + ", rentDate=" + rentDate + ", returnDate=" + returnDate + ", user=" + user + ", item="
		+ item + "]";
    }

    public Long getNo() {
        return no;
    }

    public void setNo(Long no) {
        this.no = no;
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

}
