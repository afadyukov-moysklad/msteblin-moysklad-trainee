package io.github.msteblin.Marketplace.seller;

import io.github.msteblin.Marketplace.seller.dto.SellerCreationDTO;
import io.github.msteblin.Marketplace.seller.dto.SellerDTO;
import io.github.msteblin.MoySkladAPI.types.Product;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;
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

    @GetMapping("/{id}/goods")
    public List<Product> getGoods(@PathVariable("id") UUID id) {
        return sellerService.getGoods(id);
    }

    @GetMapping("/{sellerId}/goods/{goodId}")
    public Product getGoods(@PathVariable("sellerId") UUID sellerId, @PathVariable("goodId") UUID goodId) {
        return sellerService.getGood(sellerId, goodId);
    }
}
