package com.dashboard.Admin.Dashboard.home;

import com.dashboard.Admin.Dashboard.transaction.TransactionRepository;
import com.dashboard.Admin.Dashboard.users.Users;
import com.dashboard.Admin.Dashboard.users.UsersRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.List;
import java.util.stream.Collectors;

@Controller
public class HomeController {

    @Autowired
    private UsersRepository usersRepository;

    @Autowired
    private TransactionRepository transactionRepository;


    @GetMapping("/home")
    public  String homePage(Model model){
        Integer countOfUsers=usersRepository.findAll().size();
        Integer countOfTransactions= transactionRepository.findAll().size();
        Long countOfMoney = transactionRepository.findByAmount();
        model.addAttribute("template","dashboard.html");
        model.addAttribute("title","Admin Dashboard");
//        model.addAttribute("style","css/app.css");
        model.addAttribute("countOfUsers",countOfUsers);
        model.addAttribute("countOfTransactions",countOfTransactions);
        model.addAttribute("countOfMoney",countOfMoney);
        return "base";
    }
    @GetMapping("/charts")
    public  String chartsPage(Model model){
        model.addAttribute("template","charts.html");
        model.addAttribute("title","Charts");
//        model.addAttribute("style","css/app.css");
        return "base";
    }
    @GetMapping("/profile")
    public  String profilePage(Model model){
        model.addAttribute("template","profile.html");
        model.addAttribute("title","Profile");
//        model.addAttribute("style","css/app.css");
        return "base";
    }

    @GetMapping("/")
    public  String signInPage(Model model){
//        model.addAttribute("template","sign-in.html");
//        model.addAttribute("title","Register");
//        model.addAttribute("style","css/app.css");
        return "sign-in.html";
    }
    @GetMapping("/sign-up")
    public  String signUpPage(Model model){
        Users users = new Users();
        model.addAttribute("user",users);
//        model.addAttribute("template","sign-up.html");
//        model.addAttribute("title","Sign-up");
//        model.addAttribute("style","css/app.css");
        return "sign-up.html";
    }



}
