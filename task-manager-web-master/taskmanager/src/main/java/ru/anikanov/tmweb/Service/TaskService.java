package ru.anikanov.tmweb.Service;

import org.apache.deltaspike.jpa.api.transaction.Transactional;
import org.jetbrains.annotations.NotNull;
import ru.anikanov.tmweb.entity.Task;
import ru.anikanov.tmweb.repository.ITaskRepository;

import javax.inject.Inject;
import java.io.Serializable;
import java.util.List;

@Transactional
public class TaskService implements Serializable {
    @Inject
    ITaskRepository taskRepository;

    public void persist(@NotNull final Task task) {
        taskRepository.persist(task);
    }

    ;

    public Task merge(@NotNull final Task task) {
        return taskRepository.merge(task);
    }

    ;

    public void remove(@NotNull final Task task) {
        taskRepository.remove(task);
    }

    ;

    public List<Task> findByProjectId(@NotNull final String projectId) {
        return taskRepository.findByProjectId(projectId);
    }

    ;

    public Task findById(@NotNull final String id) {
        return taskRepository.findById(id);
    }

    ;
}
