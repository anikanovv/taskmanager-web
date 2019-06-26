package ru.anikanov.tmweb.servlet.User;

import org.apache.deltaspike.jpa.api.transaction.Transactional;
import ru.anikanov.tmweb.entity.User;
import ru.anikanov.tmweb.repository.IUserRepository;

import javax.inject.Inject;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@Transactional
@WebServlet("/userregister")
public class UserRegistrationServlet extends HttpServlet {
    @Inject
    private IUserRepository userRepository;

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.getRequestDispatcher("/WEB-INF/views/userregister.jsp").forward(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        User user = new User();
        user.setLogin(req.getParameter("login"));
        user.setPassword(req.getParameter("password"));
        userRepository.persist(user);
        resp.getWriter().println("Success registration");
        resp.sendRedirect("/task-manager/usersignin");
    }
}
