package com.example.lab78.Controller;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

import java.io.IOException;

@WebServlet(name = "/", value = {"/dang-nhap"})
public class DangNhap extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String uri = req.getRequestURI();
        if (uri.contains("/dang-nhap")){
            req.getRequestDispatcher("/dangnhap.jsp").forward(req,resp);
        }else{
            HttpSession ss = req.getSession();
            ss.invalidate();
        }
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String tk = req.getParameter("tk");
        String mk = req.getParameter("mk");
        HttpSession ss = req.getSession();
        if(tk.equals("hungdzvcl")&&mk.equals("1")) {
            ss.setAttribute("tk", tk);
            ss.setAttribute("mk", mk);
            resp.sendRedirect("/song-management/playlists");
        }else{
            resp.sendRedirect("/dang-nhap");
        }
    }
}
