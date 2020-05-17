package Gestiondesetudiants;

public class ProfC {

   // private String id_cours;
	//private String nom_cours, prof;
	private String nom;
	
	
	public ProfC() {}

	public ProfC(String nom ) {
		super();
		/*this.id_cours = id_cours;
		this.nom_cours = nom_cours;
		this.prof = prof;*/
		this.nom = nom;
	}

	
	/*public String getId_cours() {
		return id_cours;
	}
	public void setId_cours(String id_cours) {
		this.id_cours = id_cours;
	}
	public String getNom_cours() {
		return nom_cours;
	}
	public void setNom_cours(String nom_cours) {
		this.nom_cours = nom_cours;
	}
	public String getProf() {
		return prof;
	}
	public void setProf(String prof) {
		this.prof = prof;
	}*/
	public String getnom() {
		return nom;
	}
	public void setnom(String nom) {
		this.nom = nom;
	}
	public String toString()
	{
		return nom;
	}
}


