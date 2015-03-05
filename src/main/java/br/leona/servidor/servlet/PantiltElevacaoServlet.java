package br.leona.servidor.servlet;

import br.leona.server.model.Observacao;
import br.leona.servidor.service.ObservacaoService;
import br.leona.servidor.service.ObservacaoService;
import java.io.IOException;
import javax.servlet.ServletException;

import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 * Servlet implementation class ActionServlet
 */
public class PantiltElevacaoServlet extends HttpServlet {

    private static final long serialVersionUID = 1L;
    private ObservacaoService obsService;
    private HttpServletRequest request;

    public PantiltElevacaoServlet(HttpServletRequest request) {
        this.obsService = new ObservacaoService();
        this.request = request;
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        int graus = Integer.parseInt(request.getParameter("elevacao"));
        obsService.movimentar(graus, "elevacao");
        HttpSession session = request.getSession();
        Observacao ob = (Observacao) session.getAttribute("obs");
        obsService.salvarLog(ob.getId().toString(), ob.getNome(), "azimute", graus);
    }

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
  // TODO Auto-generated method stub

    }

}
