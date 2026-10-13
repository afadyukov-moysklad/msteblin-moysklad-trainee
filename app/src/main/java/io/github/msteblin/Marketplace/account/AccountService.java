package io.github.msteblin.Marketplace.account;

import io.github.msteblin.Marketplace.account.dto.AccountCreationDTO;
import io.github.msteblin.Marketplace.account.dto.AccountDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class AccountService {
    @Autowired
    @SuppressWarnings("unused")
    private AccountRepository accountRepository;

    @Transactional
    public AccountDTO createAccount(AccountCreationDTO accountCreationDTO) {
        // TODO: implement argon2id hashing
        Account account = new Account(accountCreationDTO.login(), "");
        Account savedAccount = accountRepository.save(account);
        return AccountDTO.fromAccount(savedAccount);
    }
}
