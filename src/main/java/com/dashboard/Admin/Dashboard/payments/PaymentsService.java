package com.dashboard.Admin.Dashboard.payments;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.List;

@Service
public class PaymentsService {
    @Autowired
    private PaymentsRepository paymentsRepository;

    public List<Payments>  getAllPayments(){
        return paymentsRepository.findAllByOrderByIdAsc();
    }

    public Payments getSinglePayment(int id){
        return paymentsRepository.findById(id).orElse(null);
    }
    public List<Payments> getFilteredPayments(Integer id, String paymentMethod, LocalDateTime dateTimeStart, LocalDateTime dateTimeEnd){
        return paymentsRepository.findByIdOrPaymentMethodOrDateTimeBetween(id, paymentMethod, dateTimeStart, dateTimeEnd);
    }
}
