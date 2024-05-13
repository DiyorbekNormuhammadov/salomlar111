package uz.diyorbek_vs_asilbek_2.servlet;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebListener;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;
import uz.diyorbek_vs_asilbek_2.entity.Users;
import uz.diyorbek_vs_asilbek_2.repo.UserRepo;

import java.io.IOException;
@WebServlet(value = "/auth/login")
public class Login extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String phone = req.getParameter("phone");
        String password = req.getParameter("password");
        Users user = UserRepo.checkLogin(phone, password);
        if (user == null) {
            resp.sendRedirect("/login.jsp");
            return;
        }
        HttpSession session = req.getSession();
        session.setAttribute("currentUser", user);
        resp.sendRedirect("/admin.jsp");
    }
}
