package ru.anikanov.tmweb.loader;

import ru.anikanov.tmweb.repository.ProjectRepository;
import ru.anikanov.tmweb.repository.TaskRepository;
import ru.anikanov.tmweb.repository.UserRepository;

import javax.enterprise.context.ApplicationScoped;
import javax.inject.Inject;

@ApplicationScoped
public class Bootstrap {
    @Inject
    UserRepository userRepository;
    @Inject
    TaskRepository taskRepository;
    @Inject
    ProjectRepository projectRepository;
}
