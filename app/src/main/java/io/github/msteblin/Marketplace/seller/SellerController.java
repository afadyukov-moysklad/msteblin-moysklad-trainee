package io.github.msteblin.Marketplace.seller;

import io.github.msteblin.Marketplace.account.dto.AccountCreationDTO;
import io.github.msteblin.Marketplace.account.dto.AccountDTO;
import io.github.msteblin.Marketplace.seller.dto.SellerCreationDTO;
import io.github.msteblin.Marketplace.seller.dto.SellerDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.UUID;

@RestController
@RequestMapping("/sellers")
@SuppressWarnings("unused")
public class SellerController {
    @Autowired
    private SellerService sellerService;

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public SellerDTO createSeller(@RequestBody SellerCreationDTO seller) {
        return sellerService.createSeller(seller);
    }

    @GetMapping("/{id}")
    public SellerDTO getSeller(@PathVariable("id") UUID id) {
        return sellerService.getSeller(id);
    }

    @DeleteMapping("/{id}")
    public void deleteSeller(@PathVariable("id") UUID id) {
        sellerService.deleteSeller(id);
    }
}
