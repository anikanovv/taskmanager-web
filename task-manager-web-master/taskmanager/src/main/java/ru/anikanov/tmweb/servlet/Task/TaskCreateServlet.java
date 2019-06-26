package ru.anikanov.tmweb.servlet.Task;

import org.apache.deltaspike.jpa.api.transaction.Transactional;
import ru.anikanov.tmweb.entity.Task;
import ru.anikanov.tmweb.repository.ITaskRepository;

import javax.inject.Inject;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@Transactional
@WebServlet("/taskcreate")
public class TaskCreateServlet extends HttpServlet {
    @Inject
    private ITaskRepository taskRepository;

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.setAttribute("projectId", req.getParameter("id"));
        req.getRequestDispatcher("/WEB-INF/views/taskcreate.jsp").forward(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) {
        try {
            Task task = new Task();
            task.setName(req.getParameter("name"));
            task.setDescription(req.getParameter("description"));
            task.setDateEnd(req.getParameter("dateEnd"));
            String userId = (String) req.getSession().getAttribute("userId");
            task.setUserId(userId);
            String projectId = req.getParameter("projectId");
            task.setProjectId(projectId);
            taskRepository.persist(task);
            resp.sendRedirect("/task-manager/tasklist?projectId=" + projectId + "");
        } catch (IOException e) {
            e.printStackTrace();
        }

    }
}
