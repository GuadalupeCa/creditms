package com.finance.creditms.handler;

import com.finance.creditms.domain.document.Credit;
import com.finance.creditms.service.CreditService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@Slf4j
@RestController
@RequestMapping("/credit")
public class CreditHandler {

    @Autowired
    private CreditService creditService;

    @GetMapping("/")
    public Flux findAll() {
        log.info("Find all clients");
        return creditService.findAll();
    }

    @GetMapping("/{id}")
    public Mono<Credit> findById(@PathVariable("id") String id) {
        log.info("Find by Id: {}", id);
        return creditService.findById(id);
    }

    @PostMapping("/save")
    public void createEmp(@RequestBody Credit debit) {
        creditService.save(debit).subscribe();
    }
}
