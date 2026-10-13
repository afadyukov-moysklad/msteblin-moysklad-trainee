package io.github.msteblin.Marketplace.account.dto;

import java.util.UUID;

// DTO для получения с БД
public record AccountDTO(UUID id, String login) {
}
