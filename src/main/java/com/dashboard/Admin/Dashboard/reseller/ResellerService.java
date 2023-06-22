package com.dashboard.Admin.Dashboard.reseller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ResellerService {
    @Autowired
    private  ResellerRepository resellerRepository;


    public List<Reseller> getAllResellers(){
        return resellerRepository.findAllByOrderByIdAsc();
    }
}
