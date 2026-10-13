package io.github.msteblin.Marketplace.seller;

import io.github.msteblin.Marketplace.account.Account;
import io.github.msteblin.Marketplace.account.dto.AccountCreationDTO;
import io.github.msteblin.Marketplace.account.dto.AccountDTO;
import io.github.msteblin.Marketplace.exception.NotFoundException;
import io.github.msteblin.Marketplace.seller.dto.SellerCreationDTO;
import io.github.msteblin.Marketplace.seller.dto.SellerDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.UUID;

@Service
public class SellerService {
    @Autowired
    @SuppressWarnings("unused")
    private SellerRepository sellerRepository;

    @Transactional
    public SellerDTO createSeller(SellerCreationDTO sellerCreationDTO) {
        Seller seller = new Seller(new Account(sellerCreationDTO.accountId()), sellerCreationDTO.msToken());
        Seller savedSeller = sellerRepository.save(seller);
        return SellerDTO.fromSeller(savedSeller);
    }

    @Transactional
    public SellerDTO getSeller(UUID id) {
        Seller seller = sellerRepository.findById(id)
                .orElseThrow(() -> new NotFoundException("seller id=" + id));
        return SellerDTO.fromSeller(seller);
    }

    @Transactional
    public void deleteSeller(UUID id) {
        sellerRepository.deleteById(id);
    }
}
