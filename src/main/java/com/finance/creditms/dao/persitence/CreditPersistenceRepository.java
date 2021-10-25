package com.finance.creditms.dao.persitence;

import com.finance.creditms.domain.document.Credit;
import org.springframework.data.mongodb.repository.ReactiveMongoRepository;

public interface CreditPersistenceRepository extends ReactiveMongoRepository<Credit,String> {
}
