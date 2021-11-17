package com.finance.creditms.service;

import com.finance.creditms.domain.document.Credit;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

public interface CreditService {
    Flux<Credit> findAll();
    Mono<Credit> findById(String id);
    Mono<Credit> save(Credit credit);
    Mono<Void> deleteById(String id);
    Flux<Credit> findByClientDocumentIdentityNumber(String documentIdentityNumber);
    Flux<Credit> findByAccount(String account);
}
