package io.github.msteblin.Marketplace.seller.dto;

import java.util.UUID;

// DTO для создания продавца
public record SellerCreationDTO(UUID accountId, String msToken) {
}
