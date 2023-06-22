package com.dashboard.Admin.Dashboard.subReseller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class SubResellerService {
    @Autowired
    private SubResellerRepository subResellerRepository;

    public List<SubResellers> getAllSubResellers(){
        return subResellerRepository.findAllByOrderByIdAsc();
    }
}
