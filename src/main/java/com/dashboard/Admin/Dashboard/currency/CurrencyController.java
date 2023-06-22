package com.dashboard.Admin.Dashboard.currency;

import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;



@Controller
public class CurrencyController {
    @Autowired
    private CurrencyService currencyService;

    @GetMapping("/currency")
    public  String currencyPage(Model model){
        model.addAttribute("allCurrencyList",currencyService.getAllCurrency());
        model.addAttribute("template","currency.html");
        model.addAttribute("title","Currency");
//        model.addAttribute("style","css/app.css");
        return "base";
    }
    @GetMapping("/currency/{id}")
    public  String getSingleCurrency(Model model , @PathVariable int id) {
        Currency currency = currencyService.getSingleCurrency(id);

        if (currency != null) {
            model.addAttribute("singleCurrency",currency);
            model.addAttribute("template","singleCurrency.html");
            model.addAttribute("title","Currency");
            return "base";
        }else{
            return "error";
        }
    }

    @GetMapping("/register-currency")
    public  String addNewCurrency(Model model){
        Currency currency = new Currency();
        model.addAttribute("currency",currency);
        model.addAttribute("template","newCurrency.html");
        model.addAttribute("title","Add Currency");
        return "base";
    }
    @PostMapping("/saveCurrency")
    public  String saveCurrency(@ModelAttribute Currency currency){
        currencyService.save(currency);
        return "redirect:/currency";
    }

    @GetMapping("/deleteCurrency/{id}")
    public  String  deleteCurrency(@PathVariable int id){
        currencyService.deleteByCurrencyId(id);
        return "redirect:/currency";
    }
    @GetMapping("/register-currency/{id}")
    public  String  updateCurrency(Model model , @PathVariable int id){
        Currency currency = currencyService .getSingleCurrency(id);
        model.addAttribute("currency", currency);
        model.addAttribute("template","newCurrency.html");
        model.addAttribute("title","Update Currency");
        return "base";
    }
}
