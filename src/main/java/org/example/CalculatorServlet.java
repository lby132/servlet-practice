package org.example;

import org.example.calculator.Calculator;
import org.example.calculator.PositiveNumber;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import javax.servlet.*;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import java.io.IOException;
import java.io.PrintWriter;

//@WebServlet("/calculate")
public class CalculatorServlet implements Servlet {

    private static final Logger logger = LoggerFactory.getLogger(CalculatorServlet.class);

    private ServletConfig servletConfig;

    @Override
    public void init(ServletConfig config) throws ServletException {
        logger.info("init");
        this.servletConfig = config;
    }

    @Override
    public ServletConfig getServletConfig() {
        return null;
    }

    @Override
    public void service(ServletRequest req, ServletResponse res) throws ServletException, IOException {
        logger.info("service");
        int operand1 = Integer.parseInt(req.getParameter("operand1"));
        String operator = req.getParameter("operator");
        int operand2 = Integer.parseInt(req.getParameter("operand2"));

        int result = Calculator.calculate(new PositiveNumber(operand1), operator, new PositiveNumber(operand2));

        PrintWriter writer = res.getWriter();
        writer.print(result);
    }

    @Override
    public void destroy() {

    }

    @Override
    public String getServletInfo() {
        return "";
    }

//    @Override
//    public void init(ServletConfig config) throws ServletException {
//        logger.info("init");
//    }
//
//    @Override
//    public void service(ServletRequest req, ServletResponse res) throws ServletException, IOException {
//        logger.info("service");
//    }
//
//    @Override
//    public void destroy() {
//
//    }
}
