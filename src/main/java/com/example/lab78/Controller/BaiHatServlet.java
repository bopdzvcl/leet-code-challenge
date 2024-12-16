package com.example.lab78.Controller;

import com.example.lab78.Entity.BaiHat;
import com.example.lab78.Repository.BaiHatRepo;
import com.example.lab78.Repository.CaSiRepo;
import com.google.gson.Gson;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;

@WebServlet(name = "baihat",value = {"/song-management/playlists","/song-management/add","/song-management/detail","/song-management/page","/song-management/ajax"})
public class BaiHatServlet extends HttpServlet {
    int page = 0;
    BaiHatRepo bh = new BaiHatRepo();
    CaSiRepo cs = new CaSiRepo();
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String uri = req.getRequestURI();
        if(uri.contains("playlists")){
            req.setAttribute("list",bh.getAll());
            req.setAttribute("casi",cs.getAll());
           req.getRequestDispatcher("/index.jsp").forward(req,resp);
        }else if(uri.contains("detail")){
            details(req,resp);
        }else if(uri.contains("page")){
            page = Integer.valueOf(req.getParameter("page"));
            req.setAttribute("page",page);
            req.setAttribute("list",bh.pagegin(page));
            req.getRequestDispatcher("/index.jsp").forward(req,resp);
        }else if(uri.contains("ajax")){
            ajax(req,resp);
        }
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String uri = req.getRequestURI();
        if(uri.contains("add")){
            add(req,resp);
        }
    }
    public void add(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String ten = req.getParameter("ten");
        int thoiLuong = Integer.valueOf(req.getParameter("thoiLuong"));
        Double gia = Double.valueOf(req.getParameter("gia"));
        String ngayRaMat = req.getParameter("ngayramat");
        int ma = Integer.valueOf(req.getParameter("tencasi"));
        BaiHat baihat = new BaiHat(null,ten,thoiLuong,gia,cs.getOne(ma),ngayRaMat);
        bh.add(baihat);
        req.setAttribute("list",bh.getAll());
        req.setAttribute("casi",cs.getAll());
        req.getRequestDispatcher("/index.jsp").forward(req,resp);
    }
    public void details(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        int id = Integer.valueOf(req.getParameter(("id")));
        req.setAttribute("bh",bh.getOne(id));
        req.setAttribute("list",bh.getAll());
        req.setAttribute("casi",cs.getAll());
        req.getRequestDispatcher("/index.jsp").forward(req,resp);
    }
    public void ajax(HttpServletRequest req,HttpServletResponse resp) throws IOException {
            List<BaiHat> baihat  = new ArrayList<>();
            for (int i = 0; i < 5; i++) {
                baihat.add((BaiHat) bh.getAll().get(i));
            }
            Gson gs = new Gson();
            String sgs = gs.toJson(baihat);
            resp.setContentType("appliction/json");
            PrintWriter pw = resp.getWriter();
            pw.println(sgs);
            pw.flush();

    }

}
