package ru.anikanov.tmweb.servlet.Project;

import ru.anikanov.tmweb.repository.IProjectRepository;

import javax.inject.Inject;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet("/projectlist")
public class ProjectListServlet extends HttpServlet {

    @Inject
    private IProjectRepository projectRepository;

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String userId = (String) req.getSession().getAttribute("userId");
        System.out.println(userId);
        if (projectRepository.findByUserId(userId) == null) {
            return;
        }
        req.setAttribute("projects", projectRepository.findByUserId(userId));
        req.getRequestDispatcher("/WEB-INF/views/projectlist.jsp").forward(req, resp);
    }
}
