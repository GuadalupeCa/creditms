package com.finance.creditms.handler;

import com.finance.creditms.domain.document.Credit;
import com.finance.creditms.service.CreditService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Component;
import org.springframework.web.reactive.function.BodyInserters;
import org.springframework.web.reactive.function.server.ServerRequest;
import org.springframework.web.reactive.function.server.ServerResponse;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

import java.util.HashMap;
import java.util.Map;

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

        return credit.flatMap(creditToSave -> {
            Map<String, Object> responseMessage = new HashMap<>();

            Flux<Credit> clientDebits = creditService.findByClientDocumentIdentityNumber(creditToSave.getClient().getDocumentIdentityNumber());

            return clientDebits.collectList().flatMap(accounts -> {
                log.info(String.valueOf(accounts));
                boolean save = false;
                if(creditToSave.getClient().getType().getName().equalsIgnoreCase("PERSONAL")){
                    if (accounts.isEmpty()) save = true;
                    else {
                        responseMessage.put("Message", "El cliente no puede aperturar mas de una cuenta de credito");
                    }
                } else save = true;
                if (save) {
                    log.info("Save debit account.");
                    return ServerResponse.ok().body(creditService.save(creditToSave), Credit.class);
                } else {
                    return ServerResponse.status(HttpStatus.NO_CONTENT)
                            .body(BodyInserters.fromValue(responseMessage));
                }
            });
        });
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
