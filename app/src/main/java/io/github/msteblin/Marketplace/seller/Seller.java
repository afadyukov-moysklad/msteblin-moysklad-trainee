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

    @OneToOne(optional = false)
    @NonNull
    @OnDelete(action = OnDeleteAction.CASCADE)
    private final Account account;
    @NonNull
    @Column(unique = true, name = "ms_token")
    private String msToken;

    public Seller() {
        this.id = new UUID(0, 0);
        this.account = new Account();
        this.msToken = "";
    }

    public Seller(@NonNull Account account, @NonNull String msToken) {
        this.id = new UUID(0, 0);
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
