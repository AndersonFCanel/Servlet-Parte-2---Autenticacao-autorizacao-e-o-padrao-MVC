package br.com.alura.gerenciador.acao;

import java.io.IOException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import br.com.alura.gerenciador.modelo.Banco;
import br.com.alura.gerenciador.modelo.Empresa;

public class AlteraEmpresa {

	public AlteraEmpresa() {
		// TODO Auto-generated constructor stub
	}

	public String executa(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		


		String nomeEmpresa = request.getParameter("nome");
		String paramDataEmpresa = request.getParameter("data");
		String paramId = request.getParameter("id");
		Integer id = Integer.valueOf(paramId);
		
		System.out.println("Ação: altera empresa" + id);
		
		Date dataAbertura = null;
		try {
			// definindo sdf para formato de dia/mes/ano
			SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
			// 'parseando a data para um objeto do tipo Date'
			dataAbertura = sdf.parse(paramDataEmpresa);
		} catch (ParseException e) {
			throw new ServletException(e);
		}

		System.out.println(id);

		Banco banco = new Banco();
		Empresa empresa = banco.buscaEmpresaPelaId(id);

		// aleerando os dados da empresa
		empresa.setNome(nomeEmpresa);
		empresa.setDataAbertura(dataAbertura);
		
		//AULA 02 ==> Esse tipo de tarefa deve ser executada no servlet
		//response.sendRedirect("entrada?acao=ListaEmpresas");
		
		return "redirect:entrada?acao=ListaEmpresas";
	}

}
