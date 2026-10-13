package io.github.msteblin.Marketplace.account;

import org.jspecify.annotations.NonNull;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;
import java.util.UUID;

@Repository
public interface AccountRepository extends JpaRepository<Account, UUID> {
    @NonNull <S extends Account> S save(@NonNull S entity);
    @NonNull Optional<Account> findById(@NonNull UUID uuid);
    boolean existsById(@NonNull UUID uuid);
    void deleteById(@NonNull UUID uuid);
    void delete(@NonNull Account entity);
    long count();
}
