package io.github.msteblin.Marketplace.customer;

import io.github.msteblin.Marketplace.account.Account;
import io.github.msteblin.Marketplace.account.AccountRepository;
import io.github.msteblin.Marketplace.customer.dto.CustomerCreationDTO;
import io.github.msteblin.Marketplace.customer.dto.CustomerDTO;
import io.github.msteblin.Marketplace.exception.NotFoundException;
import io.micrometer.core.annotation.Counted;
import io.micrometer.core.annotation.Timed;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.UUID;

@Service
@Slf4j
@RequiredArgsConstructor
public class CustomerService {
    @Autowired
    private final CustomerRepository customerRepository;

    @Autowired
    private final AccountRepository accountRepository;

    // TODO: create an account automatically
    @Timed(value = "moysklad-trainee.operation", extraTags = {"entity", "customer", "operation", "create"})
    @Counted(value = "moysklad-trainee.operation", extraTags = {"entity", "customer", "operation", "create"})
    @Transactional
    public CustomerDTO createCustomer(CustomerCreationDTO customerCreationDTO) {
        // TODO: call AccountService.getAccount instead?
        Account account = accountRepository.findById(customerCreationDTO.accountId())
                .orElseThrow(() -> new NotFoundException("account id=" + customerCreationDTO.accountId()));
        Customer customer = new Customer(account, customerCreationDTO.name());
        Customer savedCustomer = customerRepository.save(customer);
        log.debug("Seller: {}, saved seller: {}", customer, savedCustomer);
        log.info("Created seller, id={}", savedCustomer.getId());
        return CustomerDTO.fromCustomer(savedCustomer);
    }

    @Timed(value = "moysklad-trainee.operation", extraTags = {"entity", "customer", "operation", "get"})
    @Counted(value = "moysklad-trainee.operation", extraTags = {"entity", "customer", "operation", "get"})
    @Transactional(readOnly = true)
    public CustomerDTO getCustomer(UUID id) {
        // TODO: commonize
        Customer customer = customerRepository.findById(id)
                .orElseThrow(() -> new NotFoundException("customer id=" + id));
        log.debug("Seller: {}", customer);
        log.info("Returning customer, id={}", customer.getId());
        return CustomerDTO.fromCustomer(customer);
    }

    @Timed(value = "moysklad-trainee.operation", extraTags = {"entity", "customer", "operation", "delete"})
    @Counted(value = "moysklad-trainee.operation", extraTags = {"entity", "customer", "operation", "delete"})
    @Transactional
    public void deleteCustomer(UUID id) {
        log.info("Deleting customer, id={}", id);
        customerRepository.deleteById(id);
    }
}
