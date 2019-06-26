package ru.anikanov.tmweb.repository;

import org.apache.deltaspike.data.api.EntityRepository;
import org.apache.deltaspike.data.api.Repository;
import org.jetbrains.annotations.NotNull;
import ru.anikanov.tmweb.entity.Task;

import java.util.List;

@Repository
public interface ITaskRepository extends EntityRepository<Task, String> {
    void persist(@NotNull final Task task);

    void remove(@NotNull final Task task);

    Task merge(@NotNull final Task task);

    Task findById(@NotNull final String id);

    List<Task> findByProjectId(@NotNull final String projectId);
}
