package br.com.alura.gerenciador.servlet;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import br.com.alura.gerenciador.acao.AlteraEmpresa;
import br.com.alura.gerenciador.acao.ListaEmpresas;
import br.com.alura.gerenciador.acao.MostraEmpresa;
import br.com.alura.gerenciador.acao.NovaEmpresa;
import br.com.alura.gerenciador.acao.NovaEmpresaForm;
import br.com.alura.gerenciador.acao.RemoveEmpresa;

/*
 * Nossa abordagem é funcional, mas vários controladores do mercado 
 * usam uma outra abordagem para definir o nome da ação. 
 * A ideia é que nosso controlador receba qualquer requisição para 
 * qualquer URL, através do mapeamento /:
 * 
 * @WebServlet("/")
 * */

@WebServlet("/entrada")
public class UnicaEntradaServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	public UnicaEntradaServlet() {
		super();
	}

	protected void service(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		/*
		 * O método getRequestURI(), do objeto HttpServletRequest, devolve exatamente
		 * essa informação:
		 */
		String url = request.getRequestURI();
		System.out.println("URL: " + url);

		String paramAcao = request.getParameter("acao");

		String nome = null;
		String URL_VIEW = "WEB-INF/view/";
		
		if (paramAcao.equals("ListaEmpresas")) {
			ListaEmpresas acao = new ListaEmpresas();
			nome = acao.executa(request, response);

		} else if (paramAcao.equals("RemoveEmpresa")) {
			RemoveEmpresa acao = new RemoveEmpresa();
			nome = acao.executa(request, response);
		} else if (paramAcao.equals("MostraEmpresa")) {
			MostraEmpresa acao = new MostraEmpresa();
			nome = acao.executa(request, response);
		} else if (paramAcao.equals("AlteraEmpresa")) {
			AlteraEmpresa acao = new AlteraEmpresa();
			nome = acao.executa(request, response);
		} else if (paramAcao.equals("NovaEmpresa")) {
			NovaEmpresa acao = new NovaEmpresa();
			nome = acao.executa(request, response);
		}else if (paramAcao.equals("NovaEmpresaForm")) {
			NovaEmpresaForm acao = new NovaEmpresaForm();
			nome = acao.executa(request, response);
		}

		// para quebrar valores retornados a partir de classes de ação
		String[] tipoEndereco = nome.split(":");

		if (tipoEndereco[0].equals("forward")) {
			RequestDispatcher rd = request.getRequestDispatcher(URL_VIEW+tipoEndereco[1]);
			rd.forward(request, response);
		} else {
			response.sendRedirect(tipoEndereco[1]);
		}
	}

}
