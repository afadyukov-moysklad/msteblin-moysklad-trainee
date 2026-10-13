package io.github.msteblin.Marketplace.account.dto;

import io.github.msteblin.Marketplace.account.Account;

import java.util.UUID;

// DTO для получения аккаунта с БД
public record AccountDTO(UUID id, String login) {
    public static AccountDTO fromAccount(Account account) {
        return new AccountDTO(account.getId(), account.getLogin());
    }
}
