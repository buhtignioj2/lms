package com.cafe24.lms.domain;

import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;

@Entity
@DiscriminatorValue( "B" )
public class Book extends Item{
    private String isbn;
    
    @Override
    public String toString() {
	return "Book [isbn=" + isbn + "]";
    }
    public String getIsbn() {
        return isbn;
    }
    public void setIsbn(String isbn) {
        this.isbn = isbn;
    }
}
