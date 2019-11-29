package com.study.web.servlet;

import com.study.domain.PageBean;
import com.study.domain.User;
import com.study.service.UserService;
import com.study.service.impl.UserServiceImp;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.Map;

@WebServlet("/findUserByPageServlet")
public class FindUserByPageServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        request.setCharacterEncoding("utf-8");
        String currentPage = request.getParameter("currentPage");
        String rows = request.getParameter("rows");

        if (currentPage == null||"".equals(currentPage)) {
            currentPage = "1";
        }
        if (rows == null||"".equals(rows)) {
            rows = "5";
        }
        //获取条件查询参数
        Map<String, String[]> condition = request.getParameterMap();

        //调用Service查询
        UserService service = new UserServiceImp();
        PageBean<User> pageBean = service.findUserByPage(currentPage,rows,condition);

        //将pageBean存入request
        request.setAttribute("pageBean",pageBean);
        request.setAttribute("condition",condition);
        request.getRequestDispatcher("/list.jsp").forward(request,response);

    }
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        this.doPost(request,response);
    }
}
