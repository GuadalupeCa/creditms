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

    @Override
    public Flux<Credit> findAll(){
        return creditRepository.findAll();
    }

    @Override
    public Mono<Credit> findById(String id){
        return creditRepository.findById(id);
    }

    @Override
    public Mono<Credit> save(Credit credit){
        return creditRepository.save(credit);
    }

    @Override
    public Mono<Void> deleteById(String id){
        return creditRepository.deleteById(id);
    }

    @Override
    public Flux<Credit> findByClientDocumentIdentityNumber(String documentIdentityNumber) {
        return creditRepository.findByClientDocumentIdentityNumber(documentIdentityNumber);
    }
}
