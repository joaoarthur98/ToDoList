package software.esig.clinica.dao;

import java.util.Date;
import java.util.List;

import org.junit.Ignore;
import org.junit.Test;

import software.esig.todolist.dao.LembreteDAO;
import software.esig.todolist.model.Lembrete;

public class LembreteDAOTest {
	@Test
	@Ignore
	public void salvar() {
		Lembrete lembrete = new Lembrete();

		lembrete.setNome("Estudar - Análise Combinatória");
		lembrete.setDescricao("Assuntos: - Princípios fundamentais; Casa dos pombos.");
		lembrete.setHorario(new Date());
		
		LembreteDAO dao = new LembreteDAO();
		
		dao.salvar(lembrete);
	}
	
	@Test
	@Ignore
	public void listar() {
		LembreteDAO dao = new LembreteDAO();
		
		List<Lembrete> resultado = dao.listar();
		
		for (Lembrete Lembrete : resultado) {
			System.out.println("Resultados encontrados: " + resultado.size());
			System.out.println("Nome:" + Lembrete.getNome());
			System.out.println("---------------------");
		}
	}
	
	@Test
	@Ignore
	public void buscarPorCodigo() {
		long codigo = 1L;
		
		LembreteDAO dao = new LembreteDAO();
		
		Lembrete lembrete = dao.buscarPorCodigo(codigo);
		if(lembrete == null) {
			System.out.println("Nenhum registro foi encontrado!");
		}else {
			System.out.println("Registro encontrado!");
			System.out.println(lembrete.getNome());
		}
		
	}
	@Test
	@Ignore
	public void excluir() {
		long codigo = 1L;
		LembreteDAO dao = new LembreteDAO();
		
		Lembrete lembrete = dao.buscarPorCodigo(codigo);
		
		if(lembrete == null) {
			System.out.println("Nenhum registro foi encontrado!");
		}else {
			dao.excluir(lembrete);
			System.out.println("Registro removido!");
			System.out.println(lembrete.getNome());
		}
		
	}
	
	@Test
	@Ignore
	public void atualizar() {
		long codigo = 1L;
		LembreteDAO dao = new LembreteDAO();
		
		Lembrete lembrete = dao.buscarPorCodigo(codigo);
		
		if(lembrete == null) {
			System.out.println("Nenhum registro foi encontrado!");
		}else {
			System.out.println("Registro Atualizado: antes " + lembrete.getNome());
			lembrete.setNome("Estudar - AC");
			dao.atualizar(lembrete);
			System.out.println("Registro Atualizado: depois " + lembrete.getNome());
		}
		
		
	}
	
	@Test
	public void merge() {
		LembreteDAO dao = new LembreteDAO();
		Lembrete Lembrete = dao.buscarPorCodigo(1L);

		Lembrete.setNome("Estudar - Análise Combinatória");
		dao.merge(Lembrete);
	}
}
