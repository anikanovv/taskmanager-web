package ru.anikanov.tmweb.repository;

import lombok.NoArgsConstructor;
import org.jetbrains.annotations.NotNull;
import ru.anikanov.tmweb.entity.Task;

import javax.enterprise.context.ApplicationScoped;
import javax.inject.Inject;
import javax.persistence.EntityManager;
import java.util.List;

@ApplicationScoped
@NoArgsConstructor
public class TaskRepository {

    @Inject
    private EntityManager entityManager;

    public void persist(@NotNull Task task) {
        entityManager.getTransaction().begin();
        entityManager.persist(task);
        entityManager.getTransaction().commit();

    }

    public List findAll(@NotNull final String projectId) {
        return entityManager.createQuery("SELECT task FROM Task task WHERE task.projectId=:projectId")
                .setParameter("projectId", projectId)
                .getResultList();
    }

    public void remove(String id) {
        Task task = findOne(id);
        entityManager.getTransaction().begin();
        entityManager.remove(task);
        entityManager.getTransaction().commit();
    }

    public Task findOne(String id) {
        return (Task) entityManager.createQuery("SELECT task FROM Task task WHERE task.id=:id")
                .setParameter("id", id)
                .getSingleResult();
    }

    public Task merge(@NotNull final Task task) {
        return entityManager.merge(task);
    }

}
