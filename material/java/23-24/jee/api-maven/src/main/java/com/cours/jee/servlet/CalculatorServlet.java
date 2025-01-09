package com.cours.jee.servlet;

import java.io.IOException;

import com.cours.jee.dao.CalculatorDao;
import com.cours.jee.model.CalculatorResult;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

@WebServlet("/calculate")
public class CalculatorServlet extends HttpServlet {

    CalculatorDao calculatorDao = new CalculatorDao();

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.setAttribute("results", calculatorDao.getAll());
        req.getRequestDispatcher("/WEB-INF/show-all-calculator-result.jsp").forward(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String nb1 = req.getParameter("nb1");
        String nb2 = req.getParameter("nb2");
        if (nb1 != null && nb2 != null) {
            int x = Integer.parseInt(nb1);
            int y = Integer.parseInt(nb2);
            CalculatorResult calculatorResult = new CalculatorResult(x + y, x - y);
            calculatorDao.add(calculatorResult);
            req.setAttribute("calculatorResult", calculatorResult);
        }
        req.getRequestDispatcher("/WEB-INF/calculator-result.jsp").forward(req, resp);
    }
}
