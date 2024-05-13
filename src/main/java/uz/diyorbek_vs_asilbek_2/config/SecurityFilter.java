package uz.diyorbek_vs_asilbek_2.config;

import jakarta.servlet.*;
import jakarta.servlet.annotation.WebFilter;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;
import uz.diyorbek_vs_asilbek_2.entity.Users;

import java.io.IOException;
import java.util.List;

@WebFilter("/*")

public class SecurityFilter implements Filter {
    int a = 0;

    List<String> openPages = List.of(
            "/",
            "/orderAll.jsp",
            "/index.jsp",
            "/login.jsp",
            "/auth/login",
            "static/bootstrap.min.css",
            "/orderCompleted.jsp",
            "/orderInprogres.jsp",
            "orderOpen.jsp"
    );

    @Override
    public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException, ServletException {
//        ++a;
//        if (a == 1) {
//            MyListener.generateData();
//        }
//        ++a;
        HttpServletRequest request1 = (HttpServletRequest) request;
        HttpServletResponse response1 = (HttpServletResponse) response;
        String requestURI = request1.getRequestURI();
        if (openPages.contains(requestURI)) {
            chain.doFilter(request, response);
            return;
        }
        HttpSession session = request1.getSession();
        Object currentUser = session.getAttribute("currentUser");
        Users currentUser1 = (Users) currentUser;
        if (currentUser1 == null) {
            response1.sendRedirect(
                    "/login.jsp"
            );
            return;
        }
        chain.doFilter(request, response);
    }
}