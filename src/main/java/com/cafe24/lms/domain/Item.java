package com.cafe24.lms.domain;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Inheritance;
import javax.persistence.InheritanceType;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

@Entity
@Inheritance(strategy = InheritanceType.JOINED)
public class Item {

    @Id
    @Column(name = "ITEM_ID")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String title;
    private Boolean isrent;
    
    @ManyToOne
    @JoinColumn(name="categoryNo")
    private Category category;

    @Override
    public String toString() {
	return "Item [id=" + id + ", title=" + title + ", isrent=" + isrent + ", categoryNo=" + category + "]";
    }

    public Long getId() {
	return id;
    }

    public void setId(Long id) {
	this.id = id;
    }

    public String getTitle() {
	return title;
    }

    public void setTitle(String title) {
	this.title = title;
    }

    public boolean isIsrent() {
        return isrent;
    }

    public void setIsrent(boolean isrent) {
        this.isrent = isrent;
    }
    

    public Boolean getIsrent() {
        return isrent;
    }

    public void setIsrent(Boolean isrent) {
        this.isrent = isrent;
    }

    public Category getCategory() {
        return category;
    }

    public void setCategory(Category category) {
        this.category = category;
    }

}
