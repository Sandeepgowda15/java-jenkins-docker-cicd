package com.example;

import java.io.IOException;
import java.io.PrintWriter;

import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

@WebServlet("/")
public class HelloServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest request,
                         HttpServletResponse response)
            throws IOException {

        response.setContentType("text/html;charset=UTF-8");

        try (PrintWriter out = response.getWriter()) {
            out.println("<!DOCTYPE html>");
            out.println("<html><head><title>Java CI/CD</title></head>");
            out.println("<body style='font-family:Arial;text-align:center;margin-top:80px;'>");
            out.println("<h1>Java CI/CD Pipeline v3 is Working!</h1>");
            out.println("<p>Deployed using Jenkins, Maven, Docker and AWS.</p>");
            out.println("</body></html>");
        }
    }
}
