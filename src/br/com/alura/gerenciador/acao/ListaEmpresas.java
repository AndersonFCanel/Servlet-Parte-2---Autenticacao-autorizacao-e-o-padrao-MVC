package br.com.alura.gerenciador.acao;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import br.com.alura.gerenciador.modelo.Banco;
import br.com.alura.gerenciador.modelo.Empresa;

public class ListaEmpresas implements Acao {

	public String executa(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		System.out.println("listando empresas");
		
		/*HttpSession sessao = request.getSession();
		if(sessao.getAttribute("usuarioLogado")==null) {
			return "redirect:entrada?acao=LoginForm";
		}*/

		Banco banco = new Banco();
		List<Empresa> lista = banco.getEmpresas();

		request.setAttribute("empresas", lista);

		// AULA 02 ==> Esse tipo de tarefa deve ser executada no servlet
		// despachando a requisição e seus parâmetros para outra servlet
		// RequestDispatcher rd = request.getRequestDispatcher("/listaEmpresas.jsp");
		// 'passando para frente'
		// rd.forward(request, response);

		// O "forward:" serve para fazer um foward para o jsp
		// return "/listaEmpresas.jsp";
		return "forward:listaEmpresas.jsp";
	}

}
