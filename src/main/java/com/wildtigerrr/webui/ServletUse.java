package com.wildtigerrr.webui;

import com.wildtigerrr.mainlogic.ServletHandler;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

@WebServlet(
        urlPatterns = "/servletUse/*",
        asyncSupported = true)
public class ServletUse extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp)
            throws ServletException, IOException {

        doPost(req, resp);


    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp)
            throws ServletException, IOException {

        String page = ServletHandler.mainHandle(req);
        resp.setContentType ("text/html; charset=UTF-8");
        PrintWriter out = resp.getWriter ();
        out.print(page);

    }

}
