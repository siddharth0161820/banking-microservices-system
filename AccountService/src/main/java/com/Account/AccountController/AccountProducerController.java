package com.Account.AccountController;

import com.Account.AccountService.AccountProducerService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/Account/Producer")
public class AccountProducerController {
    //1>Connect AccountProducerController to AccountProducerService via Constructor injection
    private final AccountProducerService accountProducerService;

    public AccountProducerController(AccountProducerService accountProducerService) {
        this.accountProducerService = accountProducerService;
    }
    //2>Endpoints to send message to be produced
    @PostMapping("/producerAccountPublishMessage")
    public ResponseEntity<String> sendMessage(@RequestBody String message) {
        accountProducerService.sendMessage(message);
        return ResponseEntity.ok("Message sent to Kafka topic successfullyyy");
    }
}
