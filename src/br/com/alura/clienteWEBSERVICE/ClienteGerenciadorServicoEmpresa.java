package br.com.alura.clienteWEBSERVICE;

import java.io.IOException;
import org.apache.http.client.fluent.Request;
import org.apache.http.entity.ContentType;

//Classe que envia uma requisi��o HTTP e consome WEB-SERVICE
public class ClienteGerenciadorServicoEmpresa {

    public static void main(String[] args) throws Exception, IOException {

        String retorno = Request
                .Post("http://localhost:8080/gerenciador/empresas") //fazendo a requisi��o
                .addHeader("accept", "application/json") //adicionando um cabe�alho, definindo o que � aceito
                .bodyString("{'api-key':'a12bc8e423'}", ContentType.APPLICATION_JSON) //
                .execute()
                .returnContent()
                .asString();

        //Ser� devolvido um json ou xml e impresso no console
        System.out.println(retorno);       
        
    }    
}