package dev.adafycheng.microservices.client.account.mvc;

import java.util.List;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import dev.adafycheng.microservices.client.account.model.CustomerAccount;
import dev.adafycheng.microservices.client.account.repository.CustomerAccountRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;

@RestController
@Slf4j
@RequiredArgsConstructor
public class CustomerAccountController {

    private final CustomerAccountRepository customerAccountRepository;

    @GetMapping("/api/customerAccounts")
    public Iterable<CustomerAccount> getAllCustomerAccounts() {
        log.debug("->getAllCustomerAccounts");
        return customerAccountRepository.findAll();
    }

    @GetMapping("/api/customerAccount/{lastName}")
    public List<CustomerAccount> findByLastName(@PathVariable("lastName") String name) {
        log.debug("->findByLastName");
        return customerAccountRepository.findByLastName(name);
    }

    @PostMapping("/api/customerAccounts")
    public CustomerAccount saveCustomerAccount(@RequestBody CustomerAccount customerAccount) {
        log.debug("->saveCustomerAccount {}", customerAccount);
        return customerAccountRepository.save(customerAccount);
    }

}