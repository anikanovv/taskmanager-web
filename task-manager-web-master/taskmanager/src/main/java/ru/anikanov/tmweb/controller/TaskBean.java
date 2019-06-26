package ru.anikanov.tmweb.controller;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import ru.anikanov.tmweb.Service.TaskService;
import ru.anikanov.tmweb.entity.Task;

import javax.enterprise.context.SessionScoped;
import javax.inject.Inject;
import javax.inject.Named;
import java.io.Serializable;
import java.util.List;

@Getter
@Setter
@Named("tasks")
@NoArgsConstructor
@SessionScoped
public class TaskBean implements Serializable {
    @Inject
    private TaskService taskService;
    @Inject
    private ProjectBean projectBean;

    public List<Task> getList() {
        return taskService.findByProjectId(projectBean.getProject().getId());
    }

    public String remove(String id) {
        taskService.remove(taskService.findById(id));
        return "projectlist";
    }
}