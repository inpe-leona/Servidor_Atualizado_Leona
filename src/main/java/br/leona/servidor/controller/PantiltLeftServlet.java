package br.leona.servidor.controller;
import br.leona.servidor.service.ObservacaoService;
import java.io.IOException;
import javax.servlet.ServletException;

import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class ActionServlet
 */

public class PantiltLeftServlet extends HttpServlet {
 private static final long serialVersionUID = 1L;
private ObservacaoService obsService;
    
    public PantiltLeftServlet() {
        this.obsService = new ObservacaoService();
    }


  protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
      int graus = Integer.parseInt(request.getParameter("graus"));
    obsService.movimentar(graus, "L");     
 }

  
 protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
  // TODO Auto-generated method stub
  
 }

}