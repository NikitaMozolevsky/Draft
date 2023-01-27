package by.mozolevskij.pharmacy.example.learning.session_cookies.servlets;

import jakarta.servlet.*;
import jakarta.servlet.http.*;

import java.io.IOException;

public class SetCookiesServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        Cookie cookie1 = new Cookie("some_id", "123"); //его имя и значение
        Cookie cookieSomeName = new Cookie("some_name", "Name");

        cookie1.setMaxAge(24 * 60 * 60);//срок действия Cookie, обязательные действие
        cookieSomeName.setMaxAge(24 * 60 * 60);

        response.addCookie(cookie1);
        response.addCookie(cookieSomeName);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }
}
