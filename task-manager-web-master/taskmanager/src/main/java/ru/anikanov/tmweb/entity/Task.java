package ru.anikanov.tmweb.entity;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

import javax.persistence.Entity;
import javax.persistence.Id;
import java.util.Date;
import java.util.UUID;

@Getter
@Setter
@Entity
@NoArgsConstructor
public class Task {
    @Id
    @NotNull
    private String id = UUID.randomUUID().toString();
    @Nullable
    private String projectId;
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

    public Task(@Nullable final String userId, @Nullable final String projectId, @Nullable final String name, @Nullable final String description, @Nullable final String dateEnd) {
        this.projectId = projectId;
        this.userId = userId;
        this.name = name;
        this.description = description;
        this.dateEnd = dateEnd;
    }

}
