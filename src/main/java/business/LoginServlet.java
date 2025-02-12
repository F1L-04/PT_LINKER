package business;
import  jakarta.servlet.RequestDispatcher;
import data.entity.Cliente;
import data.entity.Professionista;
import data.service.LoginService;
import data.entity.Utente;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

import java.io.IOException;
import java.security.NoSuchAlgorithmException;
import java.util.ArrayList;

@WebServlet("/LoginServlet")
public class LoginServlet extends HttpServlet {

    // Gestisce la navigazione e l'invio del form
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        // Se il metodo è GET, l'utente sta cercando di navigare alla pagina di login
        // Quindi mostriamo il form di login
        if(request.getSession().getAttribute("utente") == null) {
            request.getRequestDispatcher("WEB-INF/login.jsp").forward(request, response);
        } else if (request.getSession().getAttribute("utente") instanceof Professionista) {
            request.getRequestDispatcher("WEB-INF/home_professionista.jsp").forward(request, response);
        }else{
            request.getRequestDispatcher("WEB-INF/home_cliente.jsp").forward(request, response);
        }
    }

    // Gestisce la raccolta dei dati dal form e la logica di login
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String regex = "^[a-zA-Z0-9_+&*-]+(?:\\.[a-zA-Z0-9_+&*-]+)*@(?:[a-zA-Z0-9-]+\\.)+[a-zA-Z]{2,7}$";

        // Otteniamo i dati dal form (username e password)
        String email = request.getParameter("email");
        String password = request.getParameter("password");

        if(email==null || !email.matches(regex) || email.isEmpty()){
            throw new IllegalArgumentException("L'e-mail non rispetta i criteri.");
        }
        if(password==null || password.length()<8 || password.length()>24 ){
            throw new IllegalArgumentException("La password non rispetta i criteri di sicurezza.");
        }

        CodificaPass cod = new CodificaPass();
        String hashPass;
        try{
            hashPass=cod.toHash(password);
        } catch (NoSuchAlgorithmException e) {
            throw new RuntimeException(e);
        }

        // Chiamare la logica di business per la validazione
        LoginService loginLogic = new LoginService();
        Utente isValid = loginLogic.verificaUtente(email, hashPass);

        if (isValid instanceof Cliente) {

            System.out.println("Cliente");
            request.getSession().setAttribute("utente", isValid);

            RequestDispatcher dispatcher = request.getRequestDispatcher("/WEB-INF/home_cliente.jsp");
            dispatcher.forward(request, response);  // Inoltra la richiesta al JSP


        }else if (isValid instanceof Professionista) {  // Verifica se l'utente è un professionista
            System.out.println("prof");
            request.getSession().setAttribute("utente", isValid);
            System.out.println("prof");

            // Usa RequestDispatcher per inoltrare la richiesta alla pagina JSP
            RequestDispatcher dispatcher = request.getRequestDispatcher("/WEB-INF/home_professionista.jsp");
            dispatcher.forward(request, response);  // Inoltra la richiesta al JSP
        }else {
            // Credenziali errate, visualizziamo un messaggio di errore
            request.setAttribute("errorMessage", "Username o password non validi");
            request.getRequestDispatcher("/WEB-INF/login.jsp").forward(request, response);
        }
    }
}