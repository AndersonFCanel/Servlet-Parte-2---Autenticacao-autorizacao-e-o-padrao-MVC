package br.com.alura.gerenciador.acao;

import java.io.IOException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import br.com.alura.gerenciador.modelo.Banco;
import br.com.alura.gerenciador.modelo.Empresa;

public class ListaEmpresas {

	public ListaEmpresas() {
		// TODO Auto-generated constructor stub
	}

	public String executa(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		System.out.println("Ação: listando empresa");
		
		Banco banco = new Banco();
		List<Empresa> lista = banco.getEmpresas();

		request.setAttribute("empresas", lista);
		
		//AULA 02 ==> Esse tipo de tarefa deve ser executada no servlet
		// despachando a requisição e seus parâmetros para outra servlet
		//RequestDispatcher rd = request.getRequestDispatcher("/listaEmpresas.jsp");
		// 'passando para frente'
		//rd.forward(request, response);
		
		//O "forward:" serve para fazer um foward para o jsp
		//return "/listaEmpresas.jsp";
		return "forward:listaEmpresas.jsp";
		
	}
}
