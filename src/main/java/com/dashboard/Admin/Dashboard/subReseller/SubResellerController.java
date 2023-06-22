package com.dashboard.Admin.Dashboard.subReseller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class SubResellerController {
    @Autowired
    private SubResellerService subResellerService;
    @GetMapping("/sub-resellers")
    public String getAllSubResellers(Model model){
        model.addAttribute("allSubResellers",subResellerService.getAllSubResellers());
        model.addAttribute("template","subReseller.html");
        model.addAttribute("title","Sub-Resellers");
        return "base";
    }


}
