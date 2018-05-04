package com.cafe24.lms.domain;

import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;

@Entity
@DiscriminatorValue("D")
public class Dvd extends Item {

    private String distributor;

    @Override
    public String toString() {
	return "Dvd [distributor=" + distributor + "]";
    }

    public String getDistributor() {
	return distributor;
    }

    public void setDistributor(String distributor) {
	this.distributor = distributor;
    }

}
