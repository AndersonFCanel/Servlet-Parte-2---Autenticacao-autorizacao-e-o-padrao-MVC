package br.com.alura.clienteWEBSERVICE;

import org.apache.http.client.fluent.Request;

//Classe que envia uma requisição HTTP e consome WEB-SERVICE
public class ClienteWebService {

	public static void main(String[] args) throws Exception {
		
		String conteudo = Request
			.Post("http://localhost:8080/gerenciador/empresas")
			.addHeader("Accept", "application/json")
			.execute()
			.returnContent()
			.asString();
		
		//Será devolvido um json ou xml e impresso no console
		System.out.println(conteudo);
		
	}

}
