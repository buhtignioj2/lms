package com.cafe24.lms.domain;

import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;

@Entity
@DiscriminatorValue( "M" )
public class Music extends Item {

    private String singer;

    @Override
    public String toString() {
	return "Music [singer=" + singer + "]";
    }

    public String getSinger() {
	return singer;
    }

    public void setSinger(String singer) {
	this.singer = singer;
    }

}
