package ru.itmo.wp.servlet;

import com.google.gson.Gson;

import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class MessageServlet extends HttpServlet {

    private static class Message {
        private final String user;
        private final String text;

        Message(String user, String text) {
            this.user = user;
            this.text = text;
        }

        public String getUser() {
            return user;
        }

        public String getText() {
            return text;
        }
    }

    private final List<Message> messages = new ArrayList<>();

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws IOException {
        String requestUri = request.getRequestURI();
        HttpSession session = request.getSession();
        switch (requestUri) {
            case "/message/auth": {
                String user = request.getParameter("user");
                if (user != null) {
                    if(!user.trim().isEmpty()){
                        session.setAttribute("user", user);
                    }else{
                        user = null;
                    }
                }
                writeToJson(user, response);
                break;
            }
            case "/message/findAll":
                if (session.getAttribute("user") != null) {
                    writeToJson(messages, response);
                }
                break;
            case "/message/add": {
                String user = (String) session.getAttribute("user");
                String text = request.getParameter("text");
                if (user != null && text != null && !text.trim().isEmpty()) {
                    messages.add(new Message(user, text));
                } else {
                    response.sendError(HttpServletResponse.SC_BAD_REQUEST);
                }
                break;
            }
            default:
                response.sendError(HttpServletResponse.SC_BAD_REQUEST);
                break;
        }
        response.setCharacterEncoding("windows-1251");
        response.setContentType("application/json");
    }

    protected void writeToJson(Object objectToConvert, HttpServletResponse response) throws IOException {
        String json = new Gson().toJson(objectToConvert);
        response.getWriter().print(json);
        response.getWriter().flush();
    }
}
/*
http://localhost:8080/messages.html
*/