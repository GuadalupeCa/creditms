package com.finance.creditms.repository;

import com.finance.creditms.domain.document.Credit;
import org.springframework.data.mongodb.repository.ReactiveMongoRepository;
import reactor.core.publisher.Flux;

public interface CreditRepositoryExt extends ReactiveMongoRepository<Credit,String> {
    Flux<Credit> findByClientDocumentIdentityNumberAndStatusTrue(String documentIdentityNumber);

}
