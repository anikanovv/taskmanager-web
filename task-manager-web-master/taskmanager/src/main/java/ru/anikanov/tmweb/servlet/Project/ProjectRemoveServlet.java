package ru.anikanov.tmweb.servlet.Project;

import org.apache.deltaspike.jpa.api.transaction.Transactional;
import ru.anikanov.tmweb.repository.IProjectRepository;

import javax.inject.Inject;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@Transactional
@WebServlet("/projectremove")
public class ProjectRemoveServlet extends HttpServlet {
    @Inject
    IProjectRepository projectRepository;

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String id = req.getParameter("projectId");
        projectRepository.remove(projectRepository.findById(id));
        resp.sendRedirect("/task-manager/projectlist");
    }
}
