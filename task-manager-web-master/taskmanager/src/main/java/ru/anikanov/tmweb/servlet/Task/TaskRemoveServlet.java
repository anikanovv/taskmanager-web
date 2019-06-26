package ru.anikanov.tmweb.servlet.Task;

import org.apache.deltaspike.jpa.api.transaction.Transactional;
import ru.anikanov.tmweb.entity.Task;
import ru.anikanov.tmweb.repository.ITaskRepository;

import javax.inject.Inject;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@Transactional
@WebServlet("/taskremove")
public class TaskRemoveServlet extends HttpServlet {
    @Inject
    ITaskRepository taskRepository;

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws IOException {
        Task task = taskRepository.findById(req.getParameter("id"));
        taskRepository.remove(task);
        resp.sendRedirect("/task-manager/tasklist?projectId=" + task.getProjectId() + "");
    }
}
