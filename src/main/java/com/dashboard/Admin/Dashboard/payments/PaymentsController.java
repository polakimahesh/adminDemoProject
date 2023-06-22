package com.dashboard.Admin.Dashboard.payments;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestParam;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.time.format.DateTimeFormatter;
import java.util.List;

@Controller
public class PaymentsController {
    @Autowired
    private PaymentsService paymentsService;
    @Autowired
    private PaymentsRepository paymentsRepository;

    @GetMapping("/transactions/payments")
    public  String getAllPaymentPage(Model model){

        List<Payments> payments = paymentsService.getAllPayments();
        model.addAttribute("allPaymentTransaction",payments);
        model.addAttribute("templateTs","payments.html");
        model.addAttribute("title","Payments");
        model.addAttribute("template","transaction.html");
        model.addAttribute("style","/transaction.css");
//        model.addAttribute("style","css/app.css");
        return "base";
    }
    @GetMapping("/transactions/payment")
    public  String getSinglePaymentPage(Model model, @RequestParam(required = false) String id, @RequestParam(required = false) String method,
                                        @RequestParam(required = false) String start, @RequestParam(required = false) String end){
        DateTimeFormatter dateTimeFormatter = DateTimeFormatter.ISO_LOCAL_DATE;
        LocalDate start1 = LocalDate.parse(start, dateTimeFormatter);
        LocalDate end1 = LocalDate.parse(end, dateTimeFormatter);
        final LocalDateTime of = LocalDateTime.of(start1, LocalTime.MIN);
        int id2 = 0;
        if (!id.isEmpty()) {
            id2 = Integer.parseInt(id);
        }
        List<Payments> payments = paymentsService.getFilteredPayments(id2, method, of, LocalDateTime.of(end1, LocalTime.MIN));
        model.addAttribute("allPaymentTransaction",payments);
        model.addAttribute("templateTs","payments.html");
        model.addAttribute("title","Payments");
        model.addAttribute("template","transaction.html");
        model.addAttribute("style","/transaction.css");
//        model.addAttribute("style","css/app.css");
        return "base";
    }

//    @GetMapping("/transactions/payments/mahesh/{id}")
//
//    public  String getAllPaymentMaheshPage(Model model, @PathVariable int id) {
//        Payments payments = paymentsRepository.findByIdAndDateTimeBetweenAndDateTime(id,"21/06/2023","21/06/2023");
//        model.addAttribute("allPaymentTransaction",payments);
//       model.addAttribute("templateTs","payments.html");
//        model.addAttribute("title","Payments");
//        model.addAttribute("template","transaction.html");
//        model.addAttribute("style","/transaction.css");
//
//        return "base";
//    }

}
