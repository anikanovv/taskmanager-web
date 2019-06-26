package ru.anikanov.tmweb.servlet.User;

import ru.anikanov.tmweb.entity.User;
import ru.anikanov.tmweb.repository.IUserRepository;

import javax.inject.Inject;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet("/usersignin")
public class UserSignInServlet extends HttpServlet {
    @Inject
    private IUserRepository userRepository;

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.getRequestDispatcher("/WEB-INF/views/usersignin.jsp").forward(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String login = req.getParameter("login");
        User user = userRepository.findByLogin(login);
        if (user == null) {
            resp.getWriter().println("Wrong Login");
            return;
        }
        String password = req.getParameter("password");
        if (!user.getPassword().equals(password)) {
            resp.getWriter().println("Wrong Password");
            return;
        }
        req.getSession().setAttribute("userId", user.getId());
        System.out.println("SIGNED IN");
        resp.sendRedirect("/task-manager/projectlist");
    }
}
