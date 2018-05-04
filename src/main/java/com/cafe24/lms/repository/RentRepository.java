package com.cafe24.lms.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.cafe24.lms.domain.Rent;

public interface RentRepository extends JpaRepository<Rent, Long> {
    @Query( value="SELECT * FROM RENT r, ITEM i WHERE i.item_id = r.item_id and i.isrent = 1", nativeQuery = true )
    Rent findByItemId(String item_id);

    @Query( value="select * from rent r where r.item_id = ?1 order by r.rent_date desc limit 1", nativeQuery = true )
    Rent findReturnDateByItemId(Long id); 
}
