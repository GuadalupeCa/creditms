package com.finance.creditms.handler;

import com.finance.creditms.domain.document.Credit;
import com.finance.creditms.service.CreditService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.reactive.function.server.ServerRequest;
import org.springframework.web.reactive.function.server.ServerResponse;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@Slf4j
@Component
public class CreditHandler {

    @Autowired
    private CreditService creditService;

    public Mono findAll(ServerRequest serverRequest) {
        log.info("Find all clients");
        return ServerResponse.ok()
                .body(creditService.findAll(), Credit.class);
    }

    public Mono findById(ServerRequest serverRequest) {
        String id = serverRequest.pathVariable("id");
        log.info("Find by Id: {}", id);
        return ServerResponse.ok().body(creditService.findById(id), Credit.class);
    }

    public Mono save(ServerRequest serverRequest) {
        Mono<Credit> credit = serverRequest.bodyToMono(Credit.class);
        log.info("Save credit");
        return credit.flatMap(p -> ServerResponse
                .status(HttpStatus.CREATED)
                .body(creditService.save(p), Credit.class));
    }

    public Mono update(ServerRequest serverRequest) {
        Mono<Credit> credit = serverRequest.bodyToMono(Credit.class);
        log.info("Update credit");
        return credit.flatMap(p -> ServerResponse
                .status(HttpStatus.CREATED)
                .body(creditService.save(p), Credit.class));
    }

    public Mono deleteById(ServerRequest serverRequest) {
        String id = serverRequest.pathVariable("id");
        log.info("delete credit by id");
        return creditService.deleteById(id).then(ServerResponse.noContent().build());
    }
}
