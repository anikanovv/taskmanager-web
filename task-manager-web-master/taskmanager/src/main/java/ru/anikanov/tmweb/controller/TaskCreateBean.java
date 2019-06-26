package ru.anikanov.tmweb.controller;


import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import ru.anikanov.tmweb.Service.TaskService;
import ru.anikanov.tmweb.entity.Task;

import javax.enterprise.context.RequestScoped;
import javax.inject.Inject;
import javax.inject.Named;
import java.io.Serializable;

@Getter
@Setter
@Named("taskcreate")
@NoArgsConstructor
@RequestScoped
public class TaskCreateBean implements Serializable {
    @Inject
    LoginBean loginBean;
    @Inject
    private ProjectBean projectBean;
    @Inject
    TaskService taskService;
    private String name;
    private String description;
    private String dateEnd;

    public String persist() {
        Task task = new Task(loginBean.getUser().getId(), projectBean.getProject().getId(), name, description, dateEnd);
        taskService.persist(task);
        return "tasklist";
    }
}