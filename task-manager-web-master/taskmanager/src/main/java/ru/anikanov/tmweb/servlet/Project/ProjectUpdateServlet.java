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
@WebServlet("/projectupdate")
public class ProjectUpdateServlet extends HttpServlet {

    @Inject
    private IProjectRepository projectRepository;

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String id = req.getParameter("projectId");
        Project project = projectRepository.findById(id);
        req.setAttribute("projectId", id);
        req.setAttribute("project", project);
        req.getRequestDispatcher("/WEB-INF/views/projectupdate.jsp").forward(req, resp);

    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) {
        try {
            String id = req.getParameter("id");
            System.out.println("post " + id);
            Project project = projectRepository.findById(id);
            String userId = (String) req.getSession().getAttribute("userId");
            String name = req.getParameter("name");
            if (userId != null) project.setName(name);
            String description = req.getParameter("description");
            if (userId != null) project.setDescription(description);
            String dateEnd = req.getParameter("dateEnd");
            if (userId != null) project.setDateEnd(dateEnd);
            projectRepository.merge(project);
            resp.sendRedirect("/task-manager/projectlist");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
