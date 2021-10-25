package com.finance.creditms.dao.repository;

import com.finance.creditms.dao.persitence.CreditPersistenceRepository;
import com.finance.creditms.domain.document.Credit;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@Repository
public class CreditRepository implements CreditRepositoryInterface{

    @Autowired
    private CreditPersistenceRepository creditPersistenceRepository;

    @Override
    public Flux findAll() {
        return creditPersistenceRepository.findAll();
    }

    @Override
    public Mono findById(String id) {
        return creditPersistenceRepository.findById(id);
    }

    @Override
    public Mono save(Credit credit) {
        return creditPersistenceRepository.save(credit);
    }
}
