package io.github.msteblin.Marketplace.seller.dto;

import io.github.msteblin.Marketplace.account.Account;
import io.github.msteblin.Marketplace.account.dto.AccountDTO;
import io.github.msteblin.Marketplace.seller.Seller;

import java.util.UUID;

// DTO для получения продавца с БД
public record SellerDTO(UUID id, AccountDTO account) {
    public static SellerDTO fromSeller(Seller seller) {
        Account sellersAccount = seller.getAccount();
        return new SellerDTO(seller.getId(), AccountDTO.fromAccount(sellersAccount));
    }
}
