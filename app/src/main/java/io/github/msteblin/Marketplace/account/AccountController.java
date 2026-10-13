package io.github.msteblin.Marketplace.account;

import io.github.msteblin.Marketplace.account.dto.AccountCreationDTO;
import io.github.msteblin.Marketplace.account.dto.AccountDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.UUID;

@RestController
@RequestMapping("/accounts")
@SuppressWarnings("unused")
public class AccountController {
    @Autowired
    private AccountService accountService;

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public AccountDTO createAccount(@RequestBody AccountCreationDTO account) {
        return accountService.createAccount(account);
    }

    @GetMapping("/{id}")
    public AccountDTO getAccount(@PathVariable("id") UUID id) {
        return accountService.getAccount(id);
    }

    @DeleteMapping("/{id}")
    public void deleteAccount(@PathVariable("id") UUID id) {
        accountService.deleteAccount(id);
    }
}
