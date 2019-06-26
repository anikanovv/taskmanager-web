package ru.anikanov.tmweb.entity;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

import javax.persistence.*;
import java.util.Date;
import java.util.Set;
import java.util.UUID;

@Getter
@Setter
@Entity
@NoArgsConstructor
public final class Project {
    @Id
    @NotNull
    private String id = UUID.randomUUID().toString();

    @Nullable
    private String userId;

    @Nullable
    private String name;

    @Nullable
    private String description;

    @NotNull
    private Date dateBegin = new Date();

    @Nullable
    private String dateEnd;

    @OneToMany(cascade = CascadeType.ALL,
            fetch = FetchType.LAZY,
            mappedBy = "projectId",
            orphanRemoval = true)
    private Set<Task> tasks;

    public Project(@Nullable final String userId, @Nullable final String name, @Nullable final String description, @Nullable final String dateEnd) {
        this.userId = userId;
        this.name = name;
        this.description = description;
        this.dateEnd = dateEnd;
    }

    @Override
    public String toString() {
        return "ID: " + getId() + "; Название: " + name + "; Описание: " + description + "; Дата создания: " + dateBegin;
    }
}
