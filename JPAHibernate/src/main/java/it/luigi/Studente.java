package it.luigi;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "studente")
public class Studente{
	
	@Id
	@Column(name = "id", unique = true)
	private int id;

	@Column(name = "nome", nullable = false)
	private String nome;

	@Column(name = "eta", nullable = false)
	private int eta;

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public int getEta() {
		return eta;
	}

	public void setEta(int eta) {
		this.eta = eta;
	}
	
	@Override
	public String toString() {
		return "Studente [id=" + id + ", nome=" + nome + ", eta=" + eta + "]";
	}
	


}