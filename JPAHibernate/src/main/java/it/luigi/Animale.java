package it.luigi;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "animale")
public class Animale {

	@Id
	@Column(name = "microchip", unique = true)
	private int microchip;
	
	@Column(name = "razza", nullable = false)
	private String razza;

	@Column(name = "eta", nullable = false)
	private int eta;

	public int getMicrochip() {
		return microchip;
	}

	public void setMicrochip(int microchip) {
		this.microchip = microchip;
	}

	public String getRazza() {
		return razza;
	}

	public void setRazza(String razza) {
		this.razza = razza;
	}

	public int getEta() {
		return eta;
	}

	public void setEta(int eta) {
		this.eta = eta;
	}
	
	@Override
	public String toString() {
		return "Animale [microchip=" + microchip + ", razza=" + razza + ", eta=" + eta + "]";
	}
	
}
