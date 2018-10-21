package br.com.alura.gerenciador.servlet.obsoletoCursoParte1;

import java.io.IOException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import br.com.alura.gerenciador.modelo.Banco;
import br.com.alura.gerenciador.modelo.Empresa;
/*
 * Servlet responsável pela listagem das empresas cadastradas
 * 
 * */
//@WebServlet("/listaEmpresas")
public class ListaEmpresasServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
	//doGet
	protected void service(HttpServletRequest request, HttpServletResponse response) 
			throws ServletException, IOException {
		
		Banco banco = new Banco();
		List<Empresa> lista = banco.getEmpresas();
		
		request.setAttribute("empresas", lista);
		
		//despachando a requisição e seus parâmetros para outra servlet
		RequestDispatcher rd = request.getRequestDispatcher("/listaEmpresas.jsp");
		//'passando para frente'
		rd.forward(request, response);
		
	}
}
