package br.com.alura.gerenciador.acao;

import java.io.IOException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import br.com.alura.gerenciador.modelo.Banco;
import br.com.alura.gerenciador.modelo.Empresa;

public class RemoveEmpresa {

	public RemoveEmpresa() {
		// TODO Auto-generated constructor stub
	}

	public String executa(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		System.out.println("Ação: Removendo uma empresa");
		
		String paramId = request.getParameter("id");
		Integer id = Integer.valueOf(paramId);

		System.out.println(id);

		Banco banco = new Banco();
		banco.removeEmpresa(id);
		
		//AULA 02 ==> Esse tipo de tarefa deve ser executada no servlet
		//O "redirect:" serve para fazer um redirect para o jsp
		//response.sendRedirect("entrada?acao=ListaEmpresas");
		return "redirect:entrada?acao=ListaEmpresas";
	}

}
