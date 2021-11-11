package com.finance.creditms.service;

import com.finance.creditms.repository.CreditRepository;
import com.finance.creditms.domain.document.Credit;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@Service
public class CreditServiceImpl implements CreditService{
    @Autowired
    private CreditRepository creditRepository;

    public Flux<Credit> findAll(){
        return creditRepository.findAll();
    }

    public Mono<Credit> findById(String id){
        return creditRepository.findById(id);
    }

    public Mono<Credit> save(Credit credit){
        return creditRepository.save(credit);
    }

    public Mono<Void> deleteById(String id){
        return creditRepository.deleteById(id);
    }
}
