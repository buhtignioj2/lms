package com.cafe24.lms.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.cafe24.lms.domain.Reservation;

public interface ReservationRepository extends JpaRepository<Reservation, Long> {

    @Query( value = "SELECT count(r.id) FROM Reservation r WHERE r.user.no = :no and r.item.id = :id", nativeQuery = false )
    Long findItemByNo(@Param("no")Long no, @Param("id")Long id);

    
    @Modifying
    @Query( value="update Item i SET i.isrent = true where i.id= :id", nativeQuery=false )	// true면 sql쓰고 false면 jpql씀
    int update(@Param("id") Long item_id);


    @Query( value = " select r.count from reservation r where r.item_id = ?1 order by r.rent_date desc limit 1", nativeQuery=true)
    Long findReservationCount(Long id);
}
