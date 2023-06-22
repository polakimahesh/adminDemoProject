package com.dashboard.Admin.Dashboard.payments;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.List;

@Repository
public interface PaymentsRepository extends JpaRepository<Payments,Integer> {
    List<Payments> findAllByOrderByIdAsc();

    List<Payments> findByIdOrPaymentMethodOrDateTimeBetween(Integer id, String paymentMethod, LocalDateTime dateTimeStart, LocalDateTime dateTimeEnd);

//   @Query("select p from Payments p where p.id = ?1 and TO_CHAR(p.dateTime, 'YYYY-MM-DD') between ?2 and ?3 ")
//    Payments findByIdAndDateTimeBetweenAndDateTime(Integer id, String dateTimeStart, String dateTimeEnd);




}
