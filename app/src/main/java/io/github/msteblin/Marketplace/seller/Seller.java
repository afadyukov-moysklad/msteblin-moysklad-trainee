package io.github.msteblin.Marketplace.seller;

import io.github.msteblin.Marketplace.account.Account;
import jakarta.persistence.*;
import org.hibernate.annotations.OnDelete;
import org.hibernate.annotations.OnDeleteAction;
import org.jspecify.annotations.NonNull;

import java.util.UUID;

@Entity
@Table(name = "sellers")
@SuppressWarnings("unused")
public class Seller {
    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    private final UUID id;

    @OneToOne
    @NonNull
    @OnDelete(action = OnDeleteAction.CASCADE)
    private final Account account;
    @NonNull
    @Column(unique = true, name = "ms_token")
    private String msToken;

    public Seller(UUID id, @NonNull Account account, @NonNull String msToken) {
        this.id = id;
        this.account = account;
        this.msToken = msToken;
    }

    public UUID getId() {
        return id;
    }

    public @NonNull Account getAccount() {
        return account;
    }

    public @NonNull String getMsToken() {
        return msToken;
    }

    public void setMsToken(@NonNull String msToken) {
        this.msToken = msToken;
    }
}
