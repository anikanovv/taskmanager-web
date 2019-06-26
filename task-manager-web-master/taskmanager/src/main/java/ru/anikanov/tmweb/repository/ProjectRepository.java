package ru.anikanov.tmweb.repository;

import lombok.NoArgsConstructor;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import ru.anikanov.tmweb.entity.Project;

import javax.enterprise.context.ApplicationScoped;
import javax.inject.Inject;
import javax.persistence.EntityManager;
import java.util.List;

@ApplicationScoped
@NoArgsConstructor
public class ProjectRepository {

    @Inject
    private EntityManager entityManager;

    public void persist(@NotNull final Project project) {
        entityManager.getTransaction().begin();
        entityManager.persist(project);
        entityManager.getTransaction().commit();
    }

    public void remove(@NotNull final String id) {
        Project project = findOne(id);
        System.out.println("PROJECT ---->" + project);
        entityManager.getTransaction().begin();
        entityManager.remove(project);
        entityManager.getTransaction().commit();
    }

    public List findAll(@NotNull final String userId) {
        return entityManager.createQuery("SELECT project FROM Project project WHERE project.userId=:userId").setParameter("userId", userId).getResultList();
    }

    @Nullable
    public Project findOne(@NotNull final String id) {
        System.out.println("id ---->" + id);
        return (Project) entityManager.createQuery("SELECT project FROM Project project WHERE project.id=:id")
                .setParameter("id", id)
                .getSingleResult();
    }

    @Nullable
    public Project merge(@NotNull final Project project) {
        return entityManager.merge(project);
    }
}
