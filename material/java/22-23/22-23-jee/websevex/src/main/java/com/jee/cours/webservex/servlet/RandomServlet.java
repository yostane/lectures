package com.jee.cours.webservex.servlet;

import java.io.IOException;
import java.util.Random;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

@WebServlet("/random")
public class RandomServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        var r = new Random();
        req.setAttribute("randomValue", r.nextInt());
        this.getServletContext().getRequestDispatcher("/WEB-INF/random.jsp").forward(req, resp);
    }
}
