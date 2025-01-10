package Controller;

import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

import racing_game.player.dao.playerDAO;
import racing_game.player.model.player;

@WebServlet("/") // Maps the servlet to the root path
public class Homeservlet extends HttpServlet {
    private static final long serialVersionUID = 1L;

    public Homeservlet() {
        super(); // Default constructor
    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        // Determine the action based on the servlet path
        String action = request.getServletPath();
        RequestDispatcher requestDispatcher;

        switch (action) {
            case "/register":
                // Forward to registration.jsp when the path is "/register"
                requestDispatcher = request.getRequestDispatcher("registration.jsp");
                requestDispatcher.forward(request, response);
                break;

            case "/profile":
                // Forward to profile.jsp when the path is "/profile"
                requestDispatcher = request.getRequestDispatcher("profile.jsp");
                requestDispatcher.forward(request, response);
                break;

            case "/list":
                // Create an instance of playerDAO and fetch the list of players
                playerDAO dao = new playerDAO();
                List<player> players = dao.selectAllPlayers();
                request.setAttribute("players", players);
                requestDispatcher = request.getRequestDispatcher("list.jsp");
                requestDispatcher.forward(request, response);
                break;

            default:
                // Forward to a default page (e.g., home.jsp)
                requestDispatcher = request.getRequestDispatcher("home.jsp");
                requestDispatcher.forward(request, response);
                break;
        }
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        // Handle POST requests by delegating to the doGet method
        doGet(request, response);
    }
}