package ru.anikanov.tmweb.servlet.Task;

import ru.anikanov.tmweb.repository.ITaskRepository;

import javax.inject.Inject;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet("/tasklist")
public class TaskListServlet extends HttpServlet {
    @Inject
    private ITaskRepository taskRepository;

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.setAttribute("tasks", taskRepository.findByProjectId(req.getParameter("projectId")));
        System.out.println("ListGet " + req.getParameter("projectId"));
        req.setAttribute("projectId", req.getParameter("projectId"));
        req.getRequestDispatcher("/WEB-INF/views/tasklist.jsp").forward(req, resp);
    }
}
