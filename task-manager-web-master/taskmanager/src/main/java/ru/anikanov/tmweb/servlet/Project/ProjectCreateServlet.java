package ru.anikanov.tmweb.servlet.Project;

import org.apache.deltaspike.jpa.api.transaction.Transactional;
import ru.anikanov.tmweb.entity.Project;
import ru.anikanov.tmweb.repository.IProjectRepository;

import javax.inject.Inject;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@Transactional
@WebServlet("/projectcreate")
public class ProjectCreateServlet extends HttpServlet {
    @Inject
    private IProjectRepository projectRepository;

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.getRequestDispatcher("/WEB-INF/views/projectcreate.jsp").forward(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) {
        try {
            Project project = new Project();
            String userId = (String) req.getSession().getAttribute("userId");
            project.setUserId(userId);
            project.setName(req.getParameter("name"));
            project.setDescription(req.getParameter("description"));
            project.setDateEnd(req.getParameter("dateEnd"));
            projectRepository.persist(project);
            resp.sendRedirect("/task-manager/projectlist");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
