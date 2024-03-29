package com.study.web.servlet;

import com.study.domain.User;
import com.study.service.UserService;
import com.study.service.impl.UserServiceImp;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

@WebServlet("/userListServlet")
public class UserListServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        UserService userService = new UserServiceImp();
        List<User> users = userService.findAll();
        request.setAttribute("users",users);
      response.sendRedirect(request.getContextPath()+"/findUserByPageServlet");
//        request.getRequestDispatcher("/list.jsp").forward(request,response);

    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        this.doPost(request, response);
    }
}
