package DB;
import java.awt.List;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

import Gestiondesetudiants.Cours;
import Gestiondesetudiants.Courss;
import Gestiondesetudiants.Etudiants;
import Gestiondesetudiants.Groupe;
import Gestiondesetudiants.Info;
import Gestiondesetudiants.Proba;
import Gestiondesetudiants.Prof;
import Gestiondesetudiants.ProfC;
import Gestiondesetudiants.Resultat;
import Gestiondesetudiants.Suivre;


import java.util.Date;

import javax.swing.DefaultComboBoxModel;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;


public class LinkDatabase {

	private Database db;

	public LinkDatabase () 
	{
		db = new Database ();

	}
	public  ArrayList<Etudiants> getAllEtudiants (){
		try {
			// On cree un statement
			Statement statement = db.getStatement();
			// on execute la requete
			ResultSet rs = statement.executeQuery("SELECT * FROM etudiants");
			//on initialise la liste des etudiantes
			ArrayList<Etudiants> liste = new ArrayList<Etudiants>();
			 
			
			//On remplit la liste des etudiantes
			while(rs.next()){

				String id_etudiant = rs.getString("id_etudiant");
				String groupe = rs.getString("groupe");
				String nom = rs.getString("nom");
				String prenom = rs.getString("prenom");
				String birth_day = rs.getString("birth_day");
				String sexe = rs.getString("sexe"); 
				String email = rs.getString("email");
				String addresse = rs.getString("addresse"); 
				String ville = rs.getString("ville");
				String codePostal = rs.getString("codePostal"); 
				String pays = rs.getString("pays");
				String telefone = rs.getString("telefone"); 

				
				Etudiants etudiant = new Etudiants(id_etudiant, groupe, nom, prenom, birth_day, sexe, email,  
						 addresse, ville, codePostal, pays, telefone);
				liste.add(etudiant);
				  
			} return liste;
		
		}
			catch(Exception ex)
			{	ex.printStackTrace() ;
			System.out.println("Connection failed...");
			ex.printStackTrace();}
     		return null;	
		}		
	
	
	
	/*Ajoute un etudiant*/
	
	public  void ajouterEtudiants(Etudiants etudiant1)  {
		
		PreparedStatement ps = null; 
		try {
			ps=db.getConnection().prepareStatement("INSERT INTO etudiants (id_etudiant, groupe, nom, prenom, birth_day, sexe, email,  addresse, ville, codePostal, pays, telefone) VALUES (?,?,?,?,?,?,?,?,?,?,?,?)");
			  //// remplacer le premier ? qui est le id_etudiant	
			    ps.setString(1,etudiant1.getid_etudiant());
			 // remplacer le deuxieme ? qui est le groupe	
			    ps.setString(2,etudiant1.getgroupe());
			    ps.setString(3,etudiant1.getnom());
				ps.setString(4,etudiant1.getprenom());
				ps.setString(5,etudiant1.getbirth_day());
				ps.setString(6,etudiant1.getsexe()); 
				ps.setString(6,etudiant1.getsexe()); 
				ps.setString(7,etudiant1.getemail());
				ps.setString(8,etudiant1.getaddresse()); 
			    ps.setString(9,etudiant1.getville());
				ps.setString(10,etudiant1.getcodePostal()); 
				ps.setString(11,etudiant1.getpays());
				ps.setString(12,etudiant1.gettelefone());  
				ps.executeUpdate();  
				JOptionPane.showMessageDialog(null, "Etudiant Ajouter");
				
		          ps.close();   
		 		
			
		} catch (Exception ex) {
			System.out.println("Ajout impossible à effectuer.\nErreur :" );
			ex.printStackTrace();}
	
	}
	
	
	/*Modifier un etudiant*/

	public void modifierEtudiants(Etudiants etudiant1) {
		
		PreparedStatement ps = null; 
		try {
			ps=db.getConnection().prepareStatement("UPDATE etudiants SET id_etudiant=?, groupe=?, prenom=?, birth_day=?, sexe=?, email=?,  addresse=?, ville=?, codePostal=?, pays=?, telefone=? WHERE nom=?");
			
			    ps.setString(1,etudiant1.getid_etudiant());
				ps.setString(2,etudiant1.getgroupe());
			   	ps.setString(3,etudiant1.getprenom());
				ps.setString(4,etudiant1.getbirth_day());
				ps.setString(5,etudiant1.getsexe());
				ps.setString(6,etudiant1.getemail());
				ps.setString(7,etudiant1.getaddresse()); 
			    ps.setString(8,etudiant1.getville());
				ps.setString(9,etudiant1.getcodePostal()); 
				ps.setString(10,etudiant1.getpays());
				ps.setString(11,etudiant1.gettelefone());  
				ps.setString(12,etudiant1.getnom());
				  ps.executeUpdate();   
				  JOptionPane.showMessageDialog(null, "Etudiant Modifier");
		          ps.close();   
		        
			  
			 			
			
		} catch (Exception ex) {
			System.out.println("Connection failed...");
			ex.printStackTrace();}
		
	}	
	
	
	/*Supprimer un etudiant*/

	public void deleteEtudiants(Etudiants etudiant1) {
		
		PreparedStatement ps = null; 
		try {
			if(JOptionPane.showConfirmDialog(null,"Attention vous avez supprimer un etudiant, est ce que etes-vous sure?"
                     ,"supprimer etudiant",JOptionPane.YES_NO_OPTION) == JOptionPane.OK_OPTION)
         
			ps=db.getConnection().prepareStatement("DELETE FROM etudiants WHERE nom=?");
			  
			    
			      ps.setString(1,etudiant1.getnom()); //l'exeption  apparrait ici
				  
				  ps.executeUpdate();  ////execute delete SQL statement
				  JOptionPane.showMessageDialog(null, "Etudiant Suprimer");
		          ps.close();   
		        
			  			
			
		} catch (Exception ex) {
			System.out.println("Connection failed...");
			ex.printStackTrace();}

	
}
	
	
	/*  */
	
	
	public ArrayList<Prof> getAllProf (){
		try {
			Statement statement = db.getStatement();
			ResultSet rs = statement.executeQuery("SELECT * FROM prof");
			ArrayList<Prof> liste = new ArrayList<Prof>();

			while(rs.next()){

				String id_prof = rs.getString("id_prof");
				String nom = rs.getString("nom");
				String prenom = rs.getString("prenom");
				String email = rs.getString("email");
				String addresse = rs.getString("addresse"); 
				String ville = rs.getString("ville");
				String codePostal = rs.getString("codePostal"); 
				String pays = rs.getString("pays");
				String telefone = rs.getString("telefone"); 

				
				Prof proff = new Prof(id_prof, nom, prenom, email, 
						addresse, ville, codePostal, pays, telefone);
				liste.add(proff);
			} return liste;
		}
		////Creer Exception  
			catch(Exception ex)
			{	System.out.println("Connection failed...");
			    ex.printStackTrace();}
     		return null;	
		}	
	
	
	/*Ajouter un prof*/
	
	  public  void ajouterProf(Prof prof1)  {
			
			PreparedStatement ps = null; 
			try {
				ps=db.getConnection().prepareStatement("INSERT INTO prof (id_prof, nom, prenom,  email,  addresse, ville, codePostal, pays, telefone) VALUES (?,?,?,?,?,?,?,?,?)");
				  
				    ps.setString(1,prof1.getId_prof());
					ps.setString(2,prof1.getNom());
					ps.setString(3,prof1.getPrenom());
					ps.setString(4,prof1.getEmail());
					ps.setString(5,prof1.getAddresse()); 
				    ps.setString(6,prof1.getVille());
					ps.setString(7,prof1.getCodePostal()); 
					ps.setString(8,prof1.getPays());
					ps.setString(9,prof1.getTelefone());  
					ps.executeUpdate();  
					JOptionPane.showMessageDialog(null, "Prof Ajouter");
			          ps.close();   
				 		
				
			} catch (Exception ex) {
				System.out.println("Ajout impossible à effectuer.\nErreur :" );
				ex.printStackTrace();}
			
		}


	  
	  /*Modifier un prof*/

	  public  void modifierProf(Prof prof1)  {
			
			PreparedStatement ps = null; 
			try {
				ps=db.getConnection().prepareStatement("UPDATE prof SET id_prof=?,  prenom=?,  email=?,  addresse=?, ville=?, codePostal=?, pays=?, telefone=? WHERE nom=?");
				  
				    ps.setString(1,prof1.getId_prof());
					ps.setString(2,prof1.getPrenom());
					ps.setString(3,prof1.getEmail());
					ps.setString(4,prof1.getAddresse()); 
				    ps.setString(5,prof1.getVille());
					ps.setString(6,prof1.getCodePostal()); 
					ps.setString(7,prof1.getPays());
					ps.setString(8,prof1.getTelefone());
					ps.setString(9,prof1.getNom());
					ps.executeUpdate();  
					JOptionPane.showMessageDialog(null, "Prof Modifier");
			          ps.close();   
			        
			               
				 		
				
			} catch (Exception ex) {
				System.out.println("Modification impossible à effectuer.\nErreur :" );
				ex.printStackTrace();}
		     

			
		}


			
		/*Supprimer un prof*/

		public void deleteProf(Prof prof1) {
			
			PreparedStatement ps = null; 
			try {
				if(JOptionPane.showConfirmDialog(null,"Attention vous avez supprimer un prof, est ce que etes-vous sure?"
	                     ,"supprimer prof",JOptionPane.YES_NO_OPTION) == JOptionPane.OK_OPTION)
	         
				ps=db.getConnection().prepareStatement("DELETE FROM prof WHERE nom=?");
				  
				    
				      ps.setString(1,prof1.getNom()); //l'exeption  apparrait ici
					  
					  ps.executeUpdate();  ////execute delete SQL statement
					  JOptionPane.showMessageDialog(null, "Prof Suprimer");
			          ps.close();   
			        
				  			
				
			} catch (Exception ex) {
				System.out.println("Connection failed...");
				ex.printStackTrace();}

		
	}
		
		
		/*  */
		  
	  
		
	public ArrayList<Cours> getAllCours (){
		try {
			Statement statement = db.getStatement();
			ResultSet rs = statement.executeQuery("SELECT c.id_cours, c.prof, CONCAT(p.nom,\" \", p.prenom) as nom,  c.nom_cours  FROM cours c, prof p WHERE c.prof=p.id_prof");
			ArrayList<Cours> liste = new ArrayList<Cours>();

			while(rs.next()){

				
				
				String id_cours = rs.getString("id_cours");
				String nom_cours = rs.getString("nom_cours");
				String prof = rs.getString("prof");
				String nom = rs.getString("nom");
			
				Cours cour = new Cours(id_cours,nom_cours, prof, nom);
				liste.add(cour);
				
			} 
			return liste;
		}
			catch(Exception ex) {
				System.out.println("Connection failed...");
				ex.printStackTrace();}
		
	
	return null;
}
	
	/*liste */
	
	public ArrayList<Courss> getAllCourss (){
		try {
			Statement statement = db.getStatement();
			ResultSet rs = statement.executeQuery("SELECT * FROM cours");
			ArrayList<Courss> liste = new ArrayList<Courss>();

			while(rs.next()){

				
				
				String id_cours = rs.getString("id_cours");
				String nom_cours = rs.getString("nom_cours");
				String prof = rs.getString("prof");
				
			
				Courss cour = new Courss(id_cours,nom_cours, prof);
				liste.add(cour);
				
			} 
			return liste;
		}
			catch(Exception ex) {
				System.out.println("Connection failed...");
				ex.printStackTrace();}
		
	
	return null;
}
	
	
		
	
	/* list pour comboBox Prof */
	
	public ArrayList<ProfC> getAllProfC (){
		try {
			Statement statement = db.getStatement();
			//ResultSet rs = statement.executeQuery("SELECT c.id_cours, c.prof, CONCAT(p.nom,\" \", p.prenom) as nom,  c.nom_cours  FROM cours c, prof p WHERE c.prof=p.id_prof");
			ResultSet rs = statement.executeQuery("SELECT DISTINCT CONCAT(nom,\" \", prenom) as nom FROM prof");
			ArrayList<ProfC> liste = new ArrayList<ProfC>();

			while(rs.next()){

				//String id_cours = rs.getString("id_cours");
				//String nom_cours = rs.getString("nom_cours");
				//String prof = rs.getString("prof");
				String nom = rs.getString("nom").toString();
				
			
				
				ProfC prof1 = new ProfC(nom);
				//ProfC prof1 = new ProfC(id_cours, nom_cours, prof, nom);
				
				liste.add(prof1);
				
			} 
			return liste;
		}
			catch(Exception ex) {
				System.out.println("Connection failed...");
				ex.printStackTrace();}
		
	
	return null;
}
	
	/*ajouter cours*/
	
	
public void ajouterCours(Courss cour2)  {
		
		PreparedStatement ps = null; 
		try {
			ps=db.getConnection().prepareStatement("INSERT INTO cours (id_cours, nom_cours, prof) VALUES (?,?,?)");
			  
			    ps.setString(1,cour2.getId_cours());
				ps.setString(2,cour2.getNom_cours());
			    ps.setString(3,cour2.getProf());
				ps.executeUpdate();  
				  JOptionPane.showMessageDialog(null, "Cours Ajouter");
		          ps.close();   
		     
			  		 			
			
		} catch (Exception ex) {
			System.out.println("Connection failed...");
			ex.printStackTrace();}
		
		
	}
	
	
	/*modifier cours*/

public void modifierCours(Courss cour2)  {
	
	PreparedStatement ps = null; 
	try {
		ps=db.getConnection().prepareStatement("UPDATE cours SET nom_cours=?,  prof=? WHERE id_cour=?");
		  
		    
			ps.setString(1,cour2.getNom_cours());
		    ps.setString(2,cour2.getProf());
		    ps.setString(3,cour2.getId_cours());
			ps.executeUpdate();  
			  JOptionPane.showMessageDialog(null, "Cours Modifier");
	          ps.close();   
	     
		  		 			
		
	} catch (Exception ex) {
		System.out.println("Connection failed...");
		ex.printStackTrace();}
	
	
}
	
	
	
/*Supprimer un cours*/

public void deleteCours(Courss cour2) {
	
	PreparedStatement ps = null; 
	try {
		if(JOptionPane.showConfirmDialog(null,"Attention vous avez supprimer un cours, est ce que etes-vous sure?"
                 ,"supprimer prof",JOptionPane.YES_NO_OPTION) == JOptionPane.OK_OPTION)
     
		ps=db.getConnection().prepareStatement("DELETE FROM cours WHERE nom_cours=?");
		  
		    
		      ps.setString(1,cour2.getNom_cours()); //l'exeption  apparrait ici
			  
			  ps.executeUpdate();  ////execute delete SQL statement
			  JOptionPane.showMessageDialog(null, "Cours Suprimer");
	          ps.close();   
	        
		  			
		
	} catch (Exception ex) {
		System.out.println("Connection failed...");
		ex.printStackTrace();}


}
	
	
	



	
	
	
	
	
	public void loadList(){
		//DefaultTableModel model=new DefaultTableModel();
		   
		              
		
		try {
			Statement statement = db.getStatement();
			ResultSet rs = statement.executeQuery("SELECT e.id_etudiant, e.groupe, e.nom, e.prenom, r.points, c.nom_cours FROM etudiants e  INNER JOIN resultat r ON r.etudiant=e.id_etudiant INNER JOIN cours c ON c.id_cours=r.cours ORDER BY nom");
			ArrayList<Proba> liste = new ArrayList<Proba>();
            DefaultTableModel model=new DefaultTableModel();
           // List<Row> rows = new ArrayList<Row>();
            Object[] values = new Object[6];
			while(rs.next()){

				 values = new Object[6];
				 values[0]=rs.getString("id_etudiant");
				 values[1] =rs.getString("groupe");
				 values[2]=rs.getString("nom");
				 values[3]=rs.getString("prenom");
				 values[4]=rs.getString("nom_cours");
				 values[5]=rs.getString("points");
				 
			//	 Proba prob = new Proba(id_etudiant, groupe, nom, prenom,nom_cours, points);
	          //      liste.add(prob);   
	       //     model.addRow(new Object[]{id_etudiant, groupe, nom, prenom,nom_cours, points});
			
	               
	               
	                        
	            
	            
	            
	            
	            
			} 
			
			
		}
			catch(Exception ex) {
				System.out.println("Connection failed...");
				ex.printStackTrace();}
		
		
	
}
		
	
	
	
	
	
	
	
	
	public ArrayList<Groupe> getAllGroupe (){
		try {
			Statement statement = db.getStatement();
			ResultSet rs = statement.executeQuery("SELECT * FROM groupe");
			
			ArrayList<Groupe> liste = new ArrayList<Groupe>();

			while(rs.next()){

				
				
				String id_groupe = rs.getString("id_groupe");
				String groupeName = rs.getString("groupeName");
				
			
				
				Groupe grou = new Groupe(id_groupe, groupeName);
				liste.add(grou);
				
			} 
			return liste;
		}
			catch(Exception ex) {
				System.out.println("Connection failed...");
				ex.printStackTrace();}
		
	
	return null;
}
	
	public ArrayList<Resultat> getAllResultat (){
		try {
			Statement statement = db.getStatement();
			ResultSet rs = statement.executeQuery("SELECT * FROM resultat");
			
			ArrayList<Resultat> liste = new ArrayList<Resultat>();

			while(rs.next()){

				
				
				String id_resultat = rs.getString("id_resultat");
				String etudiant = rs.getString("etudiant");
				String points = rs.getString("points");
				String cours = rs.getString("cours");
				
			
				
				Resultat resul = new Resultat(id_resultat, etudiant, points, cours);
				liste.add(resul);
				
			} 
			return liste;
		}
			catch(Exception ex) {
				System.out.println("Connection failed...");
				ex.printStackTrace();}
		
	
	return null;
}
	
	public ArrayList<Suivre> getAllSuivre (){
		try {
			Statement statement = db.getStatement();
			ResultSet rs = statement.executeQuery("SELECT * FROM suivre");
			
			ArrayList<Suivre> liste = new ArrayList<Suivre>();

			while(rs.next()){

				
				
				String id_etudiant = rs.getString("id_etudiant");
				String id_cours = rs.getString("id_cours");
				
			
				
				Suivre suiv = new Suivre(id_etudiant, id_cours);
				liste.add(suiv);
				
			} 
			return liste;
		}
			catch(Exception ex) {
				System.out.println("Connection failed...");
				ex.printStackTrace();}
		
	
	return null;
}	

	
	
	public  ArrayList<Info> getAllInfo (){
		try {
			// On cree un statement
			Statement statement = db.getStatement();
			// on execute la requete
			ResultSet rs = statement.executeQuery("SELECT e.id_etudiant, e.groupe, e.nom, e.prenom, r.points, c.nom_cours FROM etudiants e  INNER JOIN resultat r ON r.etudiant=e.id_etudiant INNER JOIN cours c ON c.id_cours=r.cours ORDER BY nom");
			
			//on initialise la liste des etudiantes
			ArrayList<Info> liste = new ArrayList<Info>();
			 
			
			
			
			//On remplit la liste des etudiantes
			while(rs.next()){

				String id_etudiant = rs.getString("id_etudiant");
				String groupe = rs.getString("groupe");
				String nom = rs.getString("nom");
				String prenom = rs.getString("prenom");
				String nom_cours = rs.getString("nom_cours");
				String points = rs.getString("points"); 
				

				
				Info inf = new Info(id_etudiant, groupe, nom, prenom, nom_cours, points);
				liste.add(inf);
				  
			} return liste;
		
		}
			catch(Exception ex)
			{	ex.printStackTrace() ;
			System.out.println("Connection failed...");
			ex.printStackTrace();}
     		return null;	
		}		
		
	public  ArrayList<Proba> getAllProba (){
		try {
			// On cree un statement
			Statement statement = db.getStatement();
			// on execute la requete
			ResultSet rs = statement.executeQuery("SELECT e.id_etudiant, e.groupe, e.nom, e.prenom, r.points, c.nom_cours FROM etudiants e  INNER JOIN resultat r ON r.etudiant=e.id_etudiant INNER JOIN cours c ON c.id_cours=r.cours ORDER BY nom");
			
			//on initialise la liste des etudiantes
			ArrayList<Proba> liste = new ArrayList<Proba>();
			 
			
			
			
			//On remplit la liste des etudiantes
			while(rs.next()){

				String id_etudiant = rs.getString("id_etudiant");
				String groupe = rs.getString("groupe");
				String nom = rs.getString("nom");
				String prenom = rs.getString("prenom");
				String nom_cours = rs.getString("nom_cours");
				String points = rs.getString("points"); 
				

				
				Proba prob = new Proba(id_etudiant, groupe, nom, prenom, nom_cours, points);
				liste.add(prob);
				  
			} return liste;
		
		}
			catch(Exception ex)
			{	ex.printStackTrace() ;
			System.out.println("Connection failed...");
			ex.printStackTrace();}
     		return null;	
		}		
		
	
	

    




	
	
	
	public void ajouterGroupe(Groupe groupe1) {
		// TODO Auto-generated method stub
		
	}
	
	
	
	

	
		
    public void searchEtudiants(Etudiants etudiant1) {
			
			PreparedStatement ps = null; 
			try {
				Statement statement = db.getStatement();
				// on execute la requete
				ResultSet rs = statement.executeQuery("SELECT * FROM etudiants WHERE nom=?");
				//on initialise la liste des etudiantes
				
				//String nom = rs.getString("nom");
			//	ps.setString(1,searchTextField.getText());
				 ps.setString(1,etudiant1.getnom());
				/*String id_etudiant = rs.getString("id_etudiant");
				String groupe = rs.getString("groupe");
				String nom = rs.getString("nom");
				String prenom = rs.getString("prenom");
				String birth_day = rs.getString("birth_day");
				String sexe = rs.getString("sexe"); 
				String email = rs.getString("email");
				String addresse = rs.getString("addresse"); 
				String ville = rs.getString("ville");
				String codePostal = rs.getString("codePostal"); 
				String pays = rs.getString("pays");
				String telefone = rs.getString("telefone"); */
			        
				  
				 			
				
			} catch (Exception ex) {
				System.out.println("Connection failed...");
				ex.printStackTrace();}

		
	}
		

		
	
		
}


