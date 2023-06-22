package com.dashboard.Admin.Dashboard.currency;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CurrencyService {
    @Autowired
    private CurrencyRepository currencyRepository;

    public List<Currency> getAllCurrency(){
       return currencyRepository.findAllByOrderByIdAsc();
    }

    public Currency getSingleCurrency(int id){
        return currencyRepository.findById(id).orElse(null);
    }

    public  void  save(Currency currency){
        currencyRepository.save(currency);
    }


    public void deleteByCurrencyId(int id){
        currencyRepository.deleteById(id);
    }
}
