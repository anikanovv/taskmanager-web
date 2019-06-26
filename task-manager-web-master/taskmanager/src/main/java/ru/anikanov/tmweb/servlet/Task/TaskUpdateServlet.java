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
@WebServlet("/taskupdate")
public class TaskUpdateServlet extends HttpServlet {

    @Inject
    private ITaskRepository taskRepository;

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String id = req.getParameter("id");
        Task task = taskRepository.findById(id);
        req.setAttribute("task", task);
        req.getRequestDispatcher("/WEB-INF/views/taskupdate.jsp").forward(req, resp);

    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) {
        try {
            String id = req.getParameter("id");
            System.out.println("post " + id);
            Task task = taskRepository.findById(id);
            String userId = (String) req.getSession().getAttribute("userId");
            String name = req.getParameter("name");
            if (userId != null) task.setName(name);
            String description = req.getParameter("description");
            if (userId != null) task.setDescription(description);
            String dateEnd = req.getParameter("dateEnd");
            if (userId != null) task.setDateEnd(dateEnd);
            taskRepository.merge(task);
            resp.sendRedirect("/task-manager/tasklist?projectId=" + task.getProjectId() + "");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
