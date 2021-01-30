package fr.epsi.entite;

import java.util.Date;
import java.util.List;

import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

public class Facture {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	private Date date;
	private String numero;
	private double prix;
	
	public Facture() {}
	
	public Facture(Date date, String numero, double prix) {
		this.date = date;
		this.numero = numero;
		this.prix = prix;
	}
	
	public Facture(Date date, String numero, LigneFacture ligneFacture) {
		this.date = date;
		this.numero = numero;
		this.prix = ligneFacture.getPrix();
	}
	
	public Facture(Date date, String numero, List<LigneFacture> ligneFacture) {
		this.date = date;
		this.numero = numero;
		
		double tmpPrix = 0;
		for (LigneFacture lf : ligneFacture) {
			tmpPrix += lf.getPrix();
		}
		this.prix = tmpPrix;
	}
	
	public void addLigneFacture(LigneFacture ligneFacture) {
		this.prix += ligneFacture.getPrix();
	}
	
	public Date getDate() {
		return date;
	}
	public void setDate(Date date) {
		this.date = date;
	}
	public String getNumero() {
		return numero;
	}
	public void setNumero(String numero) {
		this.numero = numero;
	}
	public double getPrix() {
		return prix;
	}
	public void setPrix(double prix) {
		this.prix = prix;
	}

}
