package com.finance.creditms.repository;

import com.finance.creditms.domain.document.Credit;
import org.springframework.data.mongodb.repository.ReactiveMongoRepository;

public interface CreditRepositoryExt extends ReactiveMongoRepository<Credit,String> {
}
