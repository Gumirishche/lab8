package servlets;

import dao.AlbumDAO;
import dao.CompositionDAO;
import dao.PerformerDAO;
import model.Album;
import model.Composition;
import model.Performer;
import org.hibernate.Session;
import util.HibernateUtil;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

@WebServlet("")
public class MainServlet extends HttpServlet {
    Session session = HibernateUtil.getSession();

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        List<Performer> performers = new PerformerDAO(session).selectAll();
        List<Album> albums = new AlbumDAO(session).selectAll();
        List<Composition> compositions = new CompositionDAO(session).selectAll();
        req.setAttribute("albums", albums);
        req.setAttribute("performers", performers);
        req.setAttribute("compositions", compositions);
        getServletContext().getRequestDispatcher("/main.jsp").forward(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        super.doPost(req, resp);
    }

}
