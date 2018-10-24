package br.com.alura.gerenciador.modelo;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

/*
 * Classe Banco
 * 
 * Simulando um bando de dados para o sistema gerenciador
 * 
 * */
public class Banco {

	private static List<Empresa> lista = new ArrayList<>();
	private static List<Usuario> listaUsuarios = new ArrayList<>();

	// simulando uma primary key
	private static Integer chaveSequencial = 1;

	// Toda a evz que o sistema for reiniciado, ser� inicializado com as empresas
	// abaixo
	static {
		//CADASTRANDO EMPRESAS NO BANCO
		Empresa empresa = new Empresa();
		empresa.setId(chaveSequencial++);
		empresa.setNome("Alura");
		Empresa empresa2 = new Empresa();
		empresa2.setId(chaveSequencial++);
		empresa2.setNome("Caelum");
		lista.add(empresa);
		lista.add(empresa2);
		
		//CADASTRANDO USU�RIOS NO BANCO
		Usuario u1 = new Usuario();
		u1.setLogin("and");
		u1.setSenha("123");
		Usuario u2 = new Usuario();
		u2.setLogin("pry");
		u2.setSenha("123");
		listaUsuarios.add(u1);
		listaUsuarios.add(u2);
	}

	
	public void adiciona(Empresa empresa) {
		empresa.setId(Banco.chaveSequencial++);
		Banco.lista.add(empresa);
	}

	public List<Empresa> getEmpresas() {
		return Banco.lista;
	}

	public void removeEmpresa(Integer id) {
		// pederia ser feito com foreach
		Iterator<Empresa> it = lista.iterator();

		while (it.hasNext()) {
			Empresa emp = it.next();

			if (emp.getId() == id) {	
				it.remove();
			}
		}
	}
	// Exemplo do que foi dito n0 coment�rio anterior:
	/*
	 * for (Empresa empresa : lista) { if(empresa.getId() == id) { it.remove(); } }
	 */

	public Empresa buscaEmpresaPelaId(Integer id) {
		for (Empresa empresa : lista) {
			if (empresa.getId() == id) {
				return empresa;
			}
		}
		return null;
	}

	public Usuario existeUsuario(String login, String senha) {
		System.out.println("(VALORES RECEBIDOS PARA VERIFICA��O NO BD): "+login +" :: "+senha );
		int i =0;
		for (Usuario usuario : listaUsuarios) {
			System.out.println("USUARIO N�: "+ i++ +" - "+ usuario.getLogin());
			if (usuario.ehIgual(login, senha)) {
				return usuario;
			}
		}
		return null;
	}
}
