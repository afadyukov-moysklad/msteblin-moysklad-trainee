package io.github.msteblin.Marketplace.account.dto;

import io.github.msteblin.Marketplace.account.Account;

// DTO для создания аккаунта
public record AccountCreationDTO(String login, String password) {
}
