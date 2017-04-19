package servlet;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

@WebServlet("/user.html")
public class UserServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        Path path = Paths.get(req.getServletContext().getRealPath("/user.html"));
        ByteArrayOutputStream baos = new ByteArrayOutputStream();
        Files.copy(path, baos);
        HttpSession session = req.getSession(false);
        String email = (String) session.getAttribute("email");
        String html = String.format(baos.toString(), email);
        byte[] bytes = html.getBytes();
        resp.getOutputStream().write(bytes);
    }
}
