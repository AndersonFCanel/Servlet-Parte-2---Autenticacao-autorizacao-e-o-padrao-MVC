package br.com.alura.gerenciador.acao;

import java.io.IOException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import br.com.alura.gerenciador.modelo.Banco;
import br.com.alura.gerenciador.modelo.Empresa;

public class MostraEmpresa {

	public MostraEmpresa() {
	}
	
	public String executa(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		System.out.println("Ação: mostrando dados da empresa");
		
		String paramId = request.getParameter("id");
		Integer id = Integer.valueOf(paramId);
		
		Banco banco = new Banco();
		Empresa empresa = banco.buscaEmpresaPelaId(id);
		
		System.out.println(empresa.getNome());

		request.setAttribute("empresa", empresa);
		
		//AULA 02 ==> Esse tipo de tarefa deve ser executada no servlet
		//RequestDispatcher rd = request.getRequestDispatcher("/formAlteraEmpresa.jsp");
		//rd.forward(request, response);
		return "forward:formAlteraEmpresa.jsp";
	}

}
