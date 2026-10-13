package io.github.msteblin.Marketplace.account;

import io.github.msteblin.Marketplace.account.dto.AccountCreationDTO;
import io.github.msteblin.Marketplace.account.dto.AccountDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Optional;
import java.util.UUID;

@Service
public class AccountService {
    @Autowired
    @SuppressWarnings("unused")
    private AccountRepository accountRepository;

    @Autowired
    @SuppressWarnings("unused")
    private PasswordEncoder passwordEncoder;

    @Transactional
    public AccountDTO createAccount(AccountCreationDTO accountCreationDTO) {
        Account account = new Account(accountCreationDTO.login(), passwordEncoder.encode(accountCreationDTO.password()));
        Account savedAccount = accountRepository.save(account);
        return AccountDTO.fromAccount(savedAccount);
    }

    @Transactional
    public AccountDTO getAccount(UUID id) {
        // TODO: unwrap safely, throw exception if it is empty
        Optional<Account> account = accountRepository.findById(id);
        return AccountDTO.fromAccount(account.get());
    }

    @Transactional
    public void deleteAccount(UUID id) {
        accountRepository.deleteById(id);
    }
}
