package ru.anikanov.tmweb.entity;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

import javax.persistence.*;
import java.util.Set;
import java.util.UUID;

@Getter
@Setter
@NoArgsConstructor
@Entity
public class User {
    @Id
    @NotNull
    private String id = UUID.randomUUID().toString();
    @Nullable
    @Column(unique = true)
    private String login;
    @Nullable
    private String password;

    @OneToMany(cascade = CascadeType.ALL,
            fetch = FetchType.LAZY,
            mappedBy = "userId",
            orphanRemoval = true)
    private Set<Project> projects;

    @OneToMany(cascade = CascadeType.ALL,
            fetch = FetchType.LAZY,
            mappedBy = "userId",
            orphanRemoval = true)
    private Set<Task> tasks;

    public User(@Nullable final String login, @Nullable final String password) {
        this.login = login;
        this.password = password;
    }
}
