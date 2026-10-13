package io.github.msteblin.Marketplace.account;

import jakarta.persistence.*;
import org.jspecify.annotations.NonNull;

import java.util.UUID;

@Entity
public class Account {
    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    private final UUID id;

    @NonNull
    @Column(unique = true)
    private String login;
    @NonNull
    private String hash;

    public Account(UUID id, @NonNull String login, @NonNull String hash) {
        this.id = id;
        this.login = login;
        this.hash = hash;
    }
}
