package com.finance.creditms.repository;

import com.finance.creditms.domain.document.Credit;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

public interface CreditRepository {
    Flux<Credit> findAll();
    Mono<Credit> findById(String id);
    Mono<Credit> save(Credit credit);
    Mono<Void> deleteById(String id);
}
