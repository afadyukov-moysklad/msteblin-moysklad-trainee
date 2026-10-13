package io.github.msteblin.Marketplace.account;

import jakarta.persistence.*;
import org.jspecify.annotations.NonNull;

import java.util.UUID;

@Entity
@Table(name = "accounts")
@SuppressWarnings("unused")
public class Account {
    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    private UUID id;

    @NonNull
    @Column(unique = true)
    private String login;
    @NonNull
    private String hash;

    public Account() {
        this.id = new UUID(0, 0);
        this.login = "";
        this.hash = "";
    }

    public Account(UUID id) {
        this.id = id;
        this.login = "";
        this.hash = "";
    }

    public Account(@NonNull String login, @NonNull String hash) {
        this.id = new UUID(0, 0);
        this.login = login;
        this.hash = hash;
    }

    public UUID getId() {
        return id;
    }

    public void setId(UUID id) {
        this.id = id;
    }

    public @NonNull String getLogin() {
        return login;
    }

    public void setLogin(@NonNull String login) {
        this.login = login;
    }

    public @NonNull String getHash() {
        return hash;
    }

    public void setHash(@NonNull String hash) {
        this.hash = hash;
    }
}
