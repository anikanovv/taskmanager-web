package ru.anikanov.tmweb.repository;

import org.apache.deltaspike.data.api.EntityRepository;
import org.apache.deltaspike.data.api.Repository;
import org.jetbrains.annotations.NotNull;
import ru.anikanov.tmweb.entity.Project;

import java.util.List;

@Repository
public interface IProjectRepository extends EntityRepository<Project, String> {
    void persist(@NotNull final Project project);

    Project merge(@NotNull final Project project);

    void remove(@NotNull final Project project);

    List<Project> findByUserId(@NotNull final String userId);

    Project findById(@NotNull final String id);
}
