package io.github.msteblin.Marketplace.account;

import io.github.msteblin.Marketplace.account.dto.AccountCreationDTO;
import io.github.msteblin.Marketplace.account.dto.AccountDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;

public class AccountService {
    @Autowired
    private AccountRepository accountRepository;

    // TODO: implement DTO conversions, creation logic
    @Transactional
    public void createAccount(AccountCreationDTO accountCreationDTO) {
        // ...
    }
}
