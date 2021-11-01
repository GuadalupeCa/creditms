package com.finance.creditms.repository.impl;

import com.fasterxml.jackson.core.PrettyPrinter;
import com.finance.creditms.repository.CreditRepositoryExt;
import com.finance.creditms.repository.CreditRepository;
import com.finance.creditms.domain.document.Credit;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@Repository
public class CreditRepositoryImpl implements CreditRepository {

    @Autowired
    private CreditRepositoryExt creditRepositoryExt;

    @Override
    public Flux<Credit> findAll() {
        return creditRepositoryExt.findAll();
    }

    @Override
    public Mono<Credit> findById(String id) {
        return creditRepositoryExt.findById(id);
    }

    @Override
    public Mono<Credit> save(Credit credit) {
        return creditRepositoryExt.save(credit);
    }

    @Override
    public Mono<Void> deleteById(String id) {
        return creditRepositoryExt.deleteById(id);
    }
}
