package io.github.msteblin.Marketplace.seller;

import io.github.msteblin.Marketplace.account.Account;
import jakarta.persistence.*;
import org.hibernate.annotations.OnDelete;
import org.hibernate.annotations.OnDeleteAction;
import org.jspecify.annotations.NonNull;

import java.util.UUID;

@Entity
public class Seller {
    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    private final UUID id;

    @OneToOne
    @NonNull
    @OnDelete(action = OnDeleteAction.CASCADE)
    private final Account account;
    @NonNull
    @Column(unique = true)
    private String ms_token;

    public Seller(UUID id, @NonNull Account account, @NonNull String msToken) {
        this.id = id;
        this.account = account;
        ms_token = msToken;
    }

    public UUID getId() {
        return id;
    }

    public @NonNull Account getAccount() {
        return account;
    }

    public @NonNull String getMs_token() {
        return ms_token;
    }

    public void setMs_token(@NonNull String ms_token) {
        this.ms_token = ms_token;
    }
}
