package software.esig.todolist.bean;

import java.io.Serializable;
import java.util.List;

import javax.annotation.PostConstruct;
import javax.faces.bean.ManagedBean;
import javax.faces.event.ActionEvent;
import javax.faces.view.ViewScoped;

import org.omnifaces.util.Messages;

import software.esig.todolist.dao.LembreteDAO;
import software.esig.todolist.model.Lembrete;


@SuppressWarnings({ "deprecation", "serial" })
@ManagedBean
@ViewScoped
public class LembreteBean implements Serializable{
	private Lembrete lembrete;
	private List<Lembrete> lembretes;
	
	@PostConstruct
	public void novo() {
		lembrete = new Lembrete();	
	}
	public Lembrete getLembrete() {
		return lembrete;
	}	
	public void setLembrete(Lembrete lembrete) {
		this.lembrete = lembrete;
	}
	
	public List<Lembrete> getLembretes() {
		try {
			LembreteDAO lembreteDAO = new LembreteDAO();
			lembretes = lembreteDAO.listar();
			
		} catch (Exception e) {
			Messages.addGlobalError("Erro ao listar!");
			e.printStackTrace();
		}
		return lembretes;
	}
	
	public void setLembretes(List<Lembrete> lembretes) {
		this.lembretes = lembretes;
	}
	
	public void salvar() {
		try {
			LembreteDAO lembreteDAO = new LembreteDAO();
			if(lembrete.getId() < 1)
				lembreteDAO.salvar(lembrete);
			else
				lembreteDAO.atualizar(lembrete);
						
			Messages.addGlobalInfo("Nome: " + lembrete.getNome() + " foi salvo!");
			
			novo();
			lembretes = lembreteDAO.listar();
			
		} catch (Exception e) {
			Messages.addGlobalError("Erro ao salvar!");
			e.printStackTrace();
		}		
		
		novo();
	}
	
	public void excluir(ActionEvent evento) {
		try {
			lembrete = (Lembrete) evento.getComponent().getAttributes().get("selectLembrete");
			
			LembreteDAO LembreteDAO = new LembreteDAO();
			LembreteDAO.excluir(lembrete);
			
			lembretes = LembreteDAO.listar();
			
			Messages.addGlobalInfo(lembrete.getNome() + " removido com sucesso!");
		} catch (Exception e) {
			Messages.addFlashGlobalError("Erro ao excluir!");
			e.printStackTrace();
		}
		
	}
	
	public void editar(ActionEvent evento) {
		lembrete = (Lembrete) evento.getComponent().getAttributes().get("selectLembrete");
	}
	
}
