package ru.anikanov.tmweb.controller;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import ru.anikanov.tmweb.Service.ProjectService;
import ru.anikanov.tmweb.entity.Project;

import javax.enterprise.context.RequestScoped;
import javax.inject.Inject;
import javax.inject.Named;
import java.io.Serializable;

@Getter
@Setter
@Named("projectCreate")
@NoArgsConstructor
@RequestScoped
public class ProjectCreateBean implements Serializable {
    @Inject
    LoginBean loginBean;
    @Inject
    ProjectService projectService;
    private String name;
    private String description;
    private String dateEnd;

    public String persist() {
        Project project = new Project(loginBean.getUser().getId(), name, description, dateEnd);
        projectService.persist(project);
        return "projectlist";
    }
}
