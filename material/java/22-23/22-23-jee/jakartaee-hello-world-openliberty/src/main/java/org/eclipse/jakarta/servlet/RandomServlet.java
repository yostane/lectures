package org.eclipse.jakarta.servlet;

import java.io.IOException;
import java.util.Random;
import java.util.logging.Logger;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

@WebServlet("/rvalue")
public class RandomServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        var r = new Random();
        int generatedValue = r.nextInt(100);
        String value = req.getParameter("userValue");
        try {
            int userValue = Integer.valueOf(value);
            boolean hasWon = userValue >= generatedValue ? true : false;
            req.setAttribute("hasWon", hasWon);
        } catch (NumberFormatException nfe) {
            Logger.getGlobal().warning("No Query param");
        }
        req.setAttribute("testNumbers", new int[] { 1, 2, 3, 4 });
        req.setAttribute("randomValue", generatedValue);
        this.getServletContext().getRequestDispatcher("/WEB-INF/randval.jsp").forward(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String value1 = req.getParameter("value1");
        String value2 = req.getParameter("value2");
        Integer sum = Integer.valueOf(value1) + Integer.valueOf(value2);
        req.setAttribute("sum", sum);
        this.getServletContext().getRequestDispatcher("/WEB-INF/sum.jsp").forward(req, resp);
    }

}
