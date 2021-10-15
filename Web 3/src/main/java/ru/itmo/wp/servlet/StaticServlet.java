package ru.itmo.wp.servlet;

import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.File;
import java.io.IOException;
import java.io.OutputStream;
import java.nio.file.Files;

public class StaticServlet extends HttpServlet {
    private static final String IDEA_PATH = "C:/Users/Onexx/Downloads/olymp/ITMO KT/Web/Web 3/A/src/main/webapp/static";

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException {
        String requestUri = request.getRequestURI();
        String mimeType = "";

        String[] uris = requestUri.split("\\+");
        for (String uri : uris) {
            File file = new File(IDEA_PATH, uri);
            if (!file.isFile()) {
                file = new File(getServletContext().getRealPath("/static/" + uri));
            }
            if (file.isFile()) {
                if (mimeType.isEmpty()) {
                    mimeType = getContentTypeFromName(uri);
                }
                OutputStream outputStream = response.getOutputStream();
                Files.copy(file.toPath(), outputStream);
                outputStream.flush();
            } else {
                response.sendError(HttpServletResponse.SC_NOT_FOUND);
            }
        }
        response.setContentType(mimeType);
    }

    private String getContentTypeFromName(String name) {
        name = name.toLowerCase();

        if (name.endsWith(".png")) {
            return "image/png";
        }

        if (name.endsWith(".jpg")) {
            return "image/jpeg";
        }

        if (name.endsWith(".html")) {
            return "text/html";
        }

        if (name.endsWith(".css")) {
            return "text/css";
        }

        if (name.endsWith(".js")) {
            return "application/javascript";
        }

        throw new IllegalArgumentException("Can't find content type for '" + name + "'.");
    }
}

/*
http://localhost:8080/index.html
*/