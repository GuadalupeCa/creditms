package com.finance.creditms.service;

import com.finance.creditms.dao.repository.CreditRepositoryInterface;
import com.finance.creditms.domain.document.Credit;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@Service
public class CreditService {
    @Autowired
    private CreditRepositoryInterface creditRepositoryInterface;

    public Flux findAll(){
        return creditRepositoryInterface.findAll();
    }

    public Mono findById(String id){
        return creditRepositoryInterface.findById(id);
    }

    public Mono save(Credit credit){
        return creditRepositoryInterface.save(credit);
    }
}
