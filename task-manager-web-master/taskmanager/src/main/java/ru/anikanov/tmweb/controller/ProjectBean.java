package ru.anikanov.tmweb.controller;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import ru.anikanov.tmweb.Service.ProjectService;
import ru.anikanov.tmweb.entity.Project;

import javax.enterprise.context.SessionScoped;
import javax.inject.Inject;
import javax.inject.Named;
import java.io.Serializable;
import java.util.List;

@Getter
@Setter
@Named("projects")
@NoArgsConstructor
@SessionScoped
public class ProjectBean implements Serializable {
    @Inject
    private ProjectService projectService;
    @Inject
    private LoginBean loginBean;

    private Project project;

    public List<Project> getList() {
        return projectService.findByUserId(loginBean.getUser().getId());
    }

    public String remove(String id) {
        projectService.remove(projectService.findById(id));
        return "projectlist";
    }

    public String taskList(String projectId) {
        project = projectService.findById(projectId);
        return "tasklist";
    }
}
