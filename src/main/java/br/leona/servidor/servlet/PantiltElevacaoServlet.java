package br.leona.servidor.servlet;
import br.leona.servidor.service.ObservacaoService;
import br.leona.servidor.service.ObservacaoService;
import java.io.IOException;
import javax.servlet.ServletException;

import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class ActionServlet
 */

public class PantiltElevacaoServlet extends HttpServlet {
 private static final long serialVersionUID = 1L;
private ObservacaoService obsService;
    
    public PantiltElevacaoServlet() {
        this.obsService = new ObservacaoService();
    }


  protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
      System.out.println("Chegou Servlet");
    int graus = Integer.parseInt(request.getParameter("elevacao"));
    
    obsService.movimentar(graus, "elevacao");     
 }

  
 protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
  // TODO Auto-generated method stub
  
 }

}