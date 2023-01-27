package by.mozolevskij.pharmacy.example.learning.session_cookies.servlets;

import jakarta.servlet.*;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.*;

import java.io.IOException;
import java.io.PrintWriter;

public class GetCookiesServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        Cookie[] cookies = request.getCookies(); //получение Cookies от клиента

        PrintWriter printWriter = response.getWriter();

        printWriter.println("<html>");

        for (Cookie cookie : cookies) {
            printWriter.println("<h1>" + cookie.getName() + " : " + cookie.getValue() + "</h1>");
        }

        printWriter.println("</html>");
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }
}
