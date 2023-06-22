package com.dashboard.Admin.Dashboard.transaction;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
@Controller
public class TransactionController {
    @Autowired
    private TransactionService transactionService;


    @GetMapping("/transactions")
    public String getAllTransaction(Model model){
        model.addAttribute("allTransaction",transactionService.getAllTransaction());
        model.addAttribute("template","transaction.html");
        model.addAttribute("style","/transaction.css");
        //model.addAttribute("title","Transaction");
        model.addAttribute("templateTs","payments.html");
        model.addAttribute("title","Payments");
//        model.addAttribute("style","css/app.css");
//        return "transaction";
        return "base";
    }

    @GetMapping("/transactions/{id}")
    public String getSingleUser(@PathVariable("id") int id, Model model){
        model.addAttribute("singleTransactionDetails",transactionService.getAllTransactionBySingleUser(id));
        model.addAttribute("template","transactionDetails.html");
        model.addAttribute("title","Transaction");
        return "base" ;
    }

    @GetMapping("/transaction/{id}")
    public String getSingleTransaction(@PathVariable int id, Model model){
        model.addAttribute("singleTransaction",transactionService.getSingleTransaction(id));
        model.addAttribute("template","singleTransaction.html");
        model.addAttribute("title","Transaction Details");
        return "base";
    }

    @GetMapping("/transactions/recurring")
    public  String  recurringPage(Model model){
        model.addAttribute("templateTs","recurr.html");
        model.addAttribute("title","Recurring");
        model.addAttribute("template","transaction.html");
        model.addAttribute("style","/transaction.css");
//        model.addAttribute("style","css/app.css");
       return "base";

    }

    @GetMapping("/transactions/disputes")
    public  String disputesPage(Model model){
        model.addAttribute("templateTs","disputes.html");
        model.addAttribute("title","Disputes");
        model.addAttribute("template","transaction.html");
        model.addAttribute("style","/transaction.css");
//        model.addAttribute("style","css/app.css");
        return "base";
    }
//    @GetMapping("/transactions/payments")
//    public  String paymentPage(Model model){
//        model.addAttribute("templateTs","payments.html");
//        model.addAttribute("title","Payments");
//        model.addAttribute("template","transaction.html");
//        model.addAttribute("style","/transaction.css");
////        model.addAttribute("style","css/app.css");
//        return "base";
//    }
    @GetMapping("/transactions/refunds")
    public  String refundPage(Model model){

        model.addAttribute("templateTs","refunds.html");
        model.addAttribute("title","Refunds");
//        model.addAttribute("style","css/app.css");
        model.addAttribute("template","transaction.html");
        model.addAttribute("style","/transaction.css");
        return "base";
    }
    @GetMapping("/transactions/refunds/Details")
    public  String refundCardPage(Model model){

        model.addAttribute("templateTs","refundCard.html");
        model.addAttribute("title","Refunds");
//        model.addAttribute("style","css/app.css");
        model.addAttribute("template","transaction.html");
        model.addAttribute("style","/transaction.css");
        return "base";
    }
    @GetMapping("/transactions/chargeback")
    public  String chargebackPage(Model model){
        model.addAttribute("templateTs","chargeback.html");
        model.addAttribute("title","Chargeback");
//        model.addAttribute("style","css/app.css");
        model.addAttribute("template","transaction.html");
        model.addAttribute("style","/transaction.css");
        return "base";
    }
    @GetMapping("/transactions/chargeback/cardDetails")
    public  String chargebackCardPage(Model model){
        model.addAttribute("templateTs","chargebackCardDetails.html");
        model.addAttribute("title","Chargeback");
//        model.addAttribute("style","css/app.css");
        model.addAttribute("template","transaction.html");
        model.addAttribute("style","/transaction.css");
        return "base";
    }

    @GetMapping("/transactions/chargeback/Details")
    public  String chargebackAcceptPage(Model model){
        model.addAttribute("templateTs","chargebackCard.html");
        model.addAttribute("title","Chargeback");
//        model.addAttribute("style","css/app.css");
        model.addAttribute("template","transaction.html");
        model.addAttribute("style","/transaction.css");
        return "base";
    }




}
