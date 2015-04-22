/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.leona.servidor.servlet;

import br.leona.servidor.service.ObservacaoService;
import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author Leona1
 */
public class PantiltResetServlet extends HttpServlet {

    private static final long serialVersionUID = 1L;
    private ObservacaoService obsService;

    public PantiltResetServlet() {
        this.obsService = new ObservacaoService();
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
            
        obsService.movimentar(0, "RESET");
    }

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
  // TODO Auto-generated method stub

    }
}
