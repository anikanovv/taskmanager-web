package ru.anikanov.tmweb.Service;

import org.apache.deltaspike.jpa.api.transaction.Transactional;
import org.jetbrains.annotations.NotNull;
import ru.anikanov.tmweb.entity.Project;
import ru.anikanov.tmweb.repository.IProjectRepository;

import javax.inject.Inject;
import java.io.Serializable;
import java.util.List;

@Transactional
public class ProjectService implements Serializable {
    @Inject
    IProjectRepository projectRepository;

    public void persist(@NotNull final Project project) {
        projectRepository.persist(project);
    }

    ;

    public Project merge(@NotNull final Project project) {
        return projectRepository.merge(project);
    }

    ;

    public void remove(@NotNull final Project project) {
        projectRepository.remove(project);
    }

    ;

    public List<Project> findByUserId(@NotNull final String userId) {
        return projectRepository.findByUserId(userId);
    }

    ;

    public Project findById(@NotNull final String id) {
        return projectRepository.findById(id);
    }

    ;
}
