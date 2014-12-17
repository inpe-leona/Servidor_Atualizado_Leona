package br.leona.servidor.servlet;
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

public class PantiltMoverServlet extends HttpServlet {
 private static final long serialVersionUID = 1L;
private ObservacaoService obsService;
    
    public PantiltMoverServlet() {
        this.obsService = new ObservacaoService();
    }


  protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
      int azimute = Integer.parseInt(request.getParameter("azimute"));
      int elevacao = Integer.parseInt(request.getParameter("elevacao"));
      System.out.println("Azimute: "+azimute);
      System.out.println("Elevacao: "+elevacao);
      HttpSession session = request.getSession();
      session.setAttribute("azimute", "azimute");
      session.setAttribute("elevacao", "elevacao");
      
      //obsService.movimentar(graus, "L");     
 }

  
 protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
  // TODO Auto-generated method stub
  
 }

}