package com.finance.creditms.dao.repository;

import com.finance.creditms.domain.document.Credit;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

public interface CreditRepositoryInterface {
    Flux findAll();
    Mono findById(String id);
    Mono save(Credit credit);
}
