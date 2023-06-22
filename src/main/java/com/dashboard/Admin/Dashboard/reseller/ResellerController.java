package com.dashboard.Admin.Dashboard.reseller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.List;

@Controller
public class ResellerController {
    @Autowired
    private ResellerService resellerService;
    @GetMapping("/resellers")
    public String getAllResellers(Model model){
        List<Reseller> resellers = resellerService.getAllResellers();
        model.addAttribute("allResellers",resellers);
        model.addAttribute("template","reseller.html");
        model.addAttribute("title","Resellers");
        return "base";
    }
}
