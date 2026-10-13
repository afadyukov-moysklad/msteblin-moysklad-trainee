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
    private Account account;
    @NonNull
    @Column(unique = true)
    private String ms_token;

    public Seller(UUID id, @NonNull Account account, @NonNull String msToken) {
        this.id = id;
        this.account = account;
        ms_token = msToken;
    }
}
