package ru.anikanov.tmweb.servlet;

import lombok.Getter;
import lombok.Setter;
import ru.anikanov.tmweb.entity.Project;
import ru.anikanov.tmweb.repository.IProjectRepository;

import javax.annotation.PostConstruct;
import javax.enterprise.context.RequestScoped;
import javax.inject.Inject;
import javax.inject.Named;
import java.io.Serializable;
import java.util.List;

@Getter
@Setter
@Named("mainBean")
@RequestScoped
public class JsfTest implements Serializable {
    private String test;
    private String test1 = "TEST1";
    @Inject
    IProjectRepository projectRepository;

    private List<Project> projects;

    public void setTest(String test) {
        this.test = test;
    }

    @PostConstruct
    public void init() {
        projects = projectRepository.findAll();
    }

}
