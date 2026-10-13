package io.github.msteblin.Marketplace.seller;

import org.jspecify.annotations.NonNull;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;
import java.util.UUID;

public interface SellerRepository extends JpaRepository<Seller, UUID> {
    @NonNull<S extends Seller> S save(@NonNull S entity);
    @NonNull Optional<Seller> findById(@NonNull UUID uuid);
    boolean existsById(@NonNull UUID uuid);
    void deleteById(@NonNull UUID uuid);
    void delete(@NonNull Seller entity);
    long count();
}
