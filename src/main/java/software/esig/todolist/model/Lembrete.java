package software.esig.todolist.model;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

@SuppressWarnings("serial")
@Entity
public class Lembrete extends GenericModel{
	@Column(length = 150, nullable = false)
	private String nome;
	
	@Column(length = 200, nullable = false)
	private String descricao;
	
	@Column(nullable = false)
	@Temporal(TemporalType.DATE)
	private Date horario;
	
	public Date getHorario() {
		return horario;
	}
	
	public void setHorario(Date horario) {
		this.horario = horario;
	}
	
	public String getNome() {
		return nome;
	}
	public void setNome(String nome) {
		this.nome = nome;
	}
	public String getDescricao() {
		return descricao;
	}
	public void setDescricao(String descricao) {
		this.descricao = descricao;
	}
	
}
