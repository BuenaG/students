package Gestiondesetudiants;

public class Proba {
public String id_etudiant, groupe, nom, prenom;
	
	private String  nom_cours, points;


	public Proba() {}

	
	public Proba(String id_etudiant, String groupe, String nom, String prenom, String nom_cours, String points) {
		super();
		this.id_etudiant = id_etudiant;
		this.groupe = groupe;
		this.nom = nom;
		this.prenom = prenom;
		this.nom_cours = nom_cours;
		this.points = points;
	}

	public String getid_etudiant() {
		return id_etudiant;
	}
	public void setid_etudiant(String id_etudiant) {
		this.id_etudiant = id_etudiant;
	}
	public String getgroupe() {
		return groupe;
	}
	public void setgroupe(String groupe) {
		this.groupe = groupe;
	}
	public String getnom() {
		return nom;
	}
	public void setnom(String nom) {
		this.nom = nom;
	}
	public String getprenom() {
		return prenom;
	}
	public void setprenom(String prenom) {
		this.prenom = prenom;
	}
	
	public String getnom_cours() {
		return nom_cours;
	}
	public void setcours(String nom_cours) {
		this.nom_cours = nom_cours;
	}
	public String getpoints() {
		return points;
	}
	public void setresultat(String points) {
		this.points = points;
	}
	
	public String toString()
	{
		return id_etudiant+" "+nom+" "+prenom;
	}



}
