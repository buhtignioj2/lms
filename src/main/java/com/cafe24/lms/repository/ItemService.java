package com.cafe24.lms.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.cafe24.lms.domain.Item;

public interface ItemService extends JpaRepository<Item, Long> {

    @Modifying
    @Query( value="update Item i SET i.isrent = true where i.id= :id", nativeQuery=false )	// true면 sql쓰고 false면 jpql씀
    int update(@Param("id") Long item_id);
    
//    int update(@Param( "isrent" ) Boolean isrent, @Param("item_id") Long item_id);
//    
    
//  @Query( value = "select count(r.item_id) from Reservation r where r.item_id =:#{#reserve.item_id} and r.user_id =:#{#reserve.user_id} ", nativeQuery=false )
//  int findByReservation(@Param("reserve") Reservation reserve ); 
  
  
//  @Query( value="SELECT COUNT(r) FROM RESERVATION r WHERE r.USER_ID = ?0 and r.ITEM_ID= ?1 ", nativeQuery = true )

  
  /*@Query( "select gb from Guestbook gb where gb.no >: startNo" )
  Page<Guestbook> findAllByStartNo( @Param("startNo") Long startNo, Pageable pageable);
  
  @Query( value="update User u set u.name=:#{#user.name }, u.gender=:#{#user.gender } where u.no=:#{#user.no }", nativeQuery=false )	// true면 sql쓰고 false면 jpql씀
  int update(@Param( "user" ) User user);
  */
}
