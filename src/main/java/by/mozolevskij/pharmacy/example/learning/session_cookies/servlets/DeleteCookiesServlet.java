package by.mozolevskij.pharmacy.example.learning.session_cookies.servlets;

import jakarta.servlet.*;
import jakarta.servlet.http.*;

import java.io.IOException;

public class DeleteCookiesServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        Cookie cookie1 = new Cookie("some_id", "");

        cookie1.setMaxAge(0); //удаление Cookie

        cookie1.setMaxAge(-1); //удаление Cookie при закрытии браузера

        response.addCookie(cookie1);

    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }
}
