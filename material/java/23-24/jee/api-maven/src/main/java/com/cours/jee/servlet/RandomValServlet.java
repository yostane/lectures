package com.cours.jee.servlet;

import java.io.IOException;
import java.util.random.RandomGenerator;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

@WebServlet("/random")
public class RandomValServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        double randVal = RandomGenerator.getDefault().nextDouble();
        String nb = req.getParameter("nb");
        if (nb != null) {
            randVal = Double.parseDouble(nb);
        }
        boolean hasWon = randVal > 0.5;
        req.setAttribute("hasWon", hasWon);
        req.setAttribute("randVal", randVal);
        req.setAttribute("style", "color:green;");
        req.getRequestDispatcher("/WEB-INF/randomval-better.jsp").forward(req, resp);
    }

}
