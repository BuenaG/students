package GUI;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Container;
import java.awt.Font;
import java.awt.Label;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.sql.Statement;
import java.util.ArrayList;

import javax.swing.Box;
import javax.swing.ComboBoxModel;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JList;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextField;
import javax.swing.ListSelectionModel;
import javax.swing.ScrollPaneConstants;

import Gestiondesetudiants.Etudiants;
import login.LoginFrame.ButtonListener;

import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;

import DB.LinkDatabase;






public class GestionEtudiants extends JPanel {
	JButton ajouterButton = new JButton ("Ajouter");
	JButton modifierButton = new JButton ("Modifier");
	JButton supprimerButton = new JButton ("Supprimer");
	JButton clearButton = new JButton ("Reset");
	JButton quitterButton = new JButton ("Quitter");
	JButton searchButton = new JButton ("Search");
	
	
	
	JTextField id_etudiantTextField = new JTextField();
	JTextField groupeTextField = new JTextField();
	JTextField nomTextField = new JTextField();
	JTextField prenomTextField = new JTextField();
	JTextField birth_dayTextField = new JTextField();
	JTextField sexeTextField = new JTextField();
	JTextField emailTextField = new JTextField();
	JTextField addresseTextField = new JTextField();
	JTextField villeTextField = new JTextField();
	JTextField codePostalTextField = new JTextField();
	JTextField paysTextField = new JTextField();
	JTextField telefoneTextField = new JTextField();
	JTextField searchTextField = new JTextField();
	
    JComboBox comboSexe;
	JComboBox comboGroupe;
	
	
	ArrayList<Etudiants> listeEtudiants;
	JList etudiants;
	
	public GestionEtudiants() 
	
	{
		listeEtudiants = MainWindow.linkDB.getAllEtudiants();  
	
		System.out.println(listeEtudiants);
		
    	Box bh = Box.createHorizontalBox();
    	Box bh1 = Box.createHorizontalBox();
    	Box bh2 = Box.createHorizontalBox();
    	Box bh3 = Box.createHorizontalBox();
    	Box bh4 = Box.createHorizontalBox();
    	Box bh5 = Box.createHorizontalBox();
    	Box bh6 = Box.createHorizontalBox();
    	Box bh7 = Box.createHorizontalBox();
    	Box bh8 = Box.createHorizontalBox();
    	Box bh9 = Box.createHorizontalBox();
    	Box bh10 = Box.createHorizontalBox();
    	Box bh11 = Box.createHorizontalBox();
    	Box bh12 = Box.createHorizontalBox();
    	Box bh13 = Box.createHorizontalBox();
    	Box bh14 = Box.createHorizontalBox();
    	Box bh15 = Box.createHorizontalBox();
    	Box bh16 = Box.createHorizontalBox();
    	Box bh17 = Box.createHorizontalBox();
    	Box bh18 = Box.createHorizontalBox();
    	
		Box bv1 = Box.createVerticalBox();
		Box bv2= Box.createVerticalBox();
		
		JLabel id_etudiantLabel = new JLabel("ID etudiant:");
		JLabel groupeLabel = new JLabel("Groupe:");
		JLabel nomLabel = new JLabel("Nom:");
		JLabel prenomLabel = new JLabel("Prenom:");
		JLabel birth_dayLabel = new JLabel("Date de Naissance:");
		JLabel sexeLabel = new JLabel("Sexe:");
		JLabel emailLabel = new JLabel("Email:");
		JLabel addresseLabel = new JLabel("Adresse:");
		JLabel villeLabel = new JLabel("Ville:");
		JLabel codePostalLabel = new JLabel("Code Postal:");
		JLabel paysLabel = new JLabel("Pays:");
		JLabel telefoneLabel = new JLabel("Telephone:");
		JLabel searchLabel = new JLabel("");
			
		comboSexe= new JComboBox();
		
	
		comboSexe.setModel(new DefaultComboBoxModel(new String[] {"Select", "F", "M"}));
		
			
		 comboSexe.addActionListener(new ActionListener() {
	            public void comboSexeActionPerformed(ActionEvent e) {
	            	
	            }

				@Override
				public void actionPerformed(ActionEvent e) {
					// TODO Auto-generated method stub
					
				}
	        });	
		
		 comboGroupe= new JComboBox();
		 comboGroupe.setModel(new DefaultComboBoxModel(new String[] {"Select", "1", "2", "3"})); 

		searchTextField.setBackground(Color.GREEN);
		searchTextField.setForeground(Color.BLACK);
		searchTextField.setBounds(465, 86, 117, 22);
		searchTextField.setColumns(10);
		
		
		
		

	// etudiant1 , 2 vont etre remplacé par notre base de données)
		
		//afficher les etudiants
	 etudiants = new JList (listeEtudiants.toArray());
		
	 etudiants.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
	
	 etudiants.addListSelectionListener(
             new ListSelectionListener() {
                  public void valueChanged(ListSelectionEvent e) {
                      //renvoie la valeur sélectionnée de l'élément de la liste
                	  
                	  Etudiants element = (Gestiondesetudiants.Etudiants) etudiants.getSelectedValue();
                	  if (element !=null) {               	                   	 
                	   id_etudiantTextField.setText(element.getid_etudiant());
                	   comboGroupe.setSelectedItem(element.getgroupe());
                	   nomTextField.setText(element.getnom());
                       prenomTextField.setText(element.getprenom());
                       birth_dayTextField.setText(element.getbirth_day());
                       comboSexe.setSelectedItem(element.getsexe());
                       emailTextField.setText(element.getemail());
                       addresseTextField.setText(element.getaddresse());
                       villeTextField.setText(element.getville());
                       codePostalTextField.setText(element.getcodePostal());
                       paysTextField.setText(element.getpays());
                       telefoneTextField.setText(element.gettelefone());
                     
                       
                  }
                  
                  }
                  } );
	
	
	 
	 
	//pour ajouter scolling line
	JScrollPane listScroller = new JScrollPane(etudiants);
	//listScroller.setVerticalScrollBarPolicy(ScrollPaneConstants.VERTICAL_SCROLLBAR_ALWAYS);
	 
//mettre 2 box(bv1 et bv2) dans un box (bh)
	bh.add(Box.createHorizontalStrut(20));
	
	bh.add(bv1);
	bh.add(bv2);
	bh.add(bh18);
	
	bv2.add(bh1);
	bv2.add(bh2);
	bv2.add(bh3);
	bv2.add(bh4);
	bv2.add(bh5);
	bv2.add(bh6);
	bv2.add(bh7);
	bv2.add(bh8);
	bv2.add(bh9);
	bv2.add(bh10);
	bv2.add(bh11);
	bv2.add(bh12);
	bv2.add(bh18);
	
	
	nomTextField.setColumns(30);
	prenomTextField.setColumns(30);
	
	
	bh1.add(id_etudiantLabel);
	bh1.add(Box.createHorizontalGlue());
	bh1.add(id_etudiantTextField);
	
	bh2.add(groupeLabel);
	bh2.add(Box.createHorizontalGlue());
	//bh2.add(groupeTextField);
	
	bh3.add(nomLabel);
	bh3.add(Box.createHorizontalGlue());
	bh3.add(nomTextField);
	
	bh4.add(prenomLabel);
	bh4.add(Box.createHorizontalGlue());
	bh4.add(prenomTextField);
	
	bh5.add(birth_dayLabel);
	bh5.add(Box.createHorizontalGlue());
	bh5.add(birth_dayTextField);
	
	bh6.add(sexeLabel);
	bh6.add(Box.createHorizontalGlue());
	//bh6.add(sexeTextField);
	
	bh7.add(emailLabel);
	bh7.add(Box.createHorizontalGlue());
	bh7.add(emailTextField);
	
	bh8.add(addresseLabel);
	bh8.add(Box.createHorizontalGlue());
	bh8.add(addresseTextField);
	
	bh9.add(villeLabel);
	bh9.add(Box.createHorizontalGlue());
	bh9.add(villeTextField);
	
	bh10.add(codePostalLabel);
	bh10.add(Box.createHorizontalGlue());
	bh10.add(codePostalTextField);
	
	bh11.add(paysLabel);
	bh11.add(Box.createHorizontalGlue());
	bh11.add(paysTextField);
	
	bh12.add(telefoneLabel);
	bh12.add(Box.createHorizontalGlue());
	bh12.add(telefoneTextField);
	
	bh18.add(searchLabel);
	bh18.add(Box.createHorizontalGlue());
	bh18.add(searchTextField);
	
	bh6.add(comboSexe);
	bh6.add(Box.createHorizontalGlue());
	bh6.add(comboSexe);
	
	bh2.add(comboGroupe);
	bh2.add(Box.createHorizontalGlue());
	bh2.add(comboGroupe);
	
	ajouterButton.addActionListener(new ButtonListener());
	bh13.add(Box.createHorizontalStrut(20));
	bh13.add(ajouterButton);
	bh13.add(Box.createHorizontalGlue());
	
	modifierButton.addActionListener(new ButtonListener());
	bh14.add(modifierButton);
	
	supprimerButton.addActionListener(new ButtonListener());
	bh15.add(supprimerButton);
	
	clearButton.addActionListener(new ButtonListener());
	bh16.add(clearButton);
	
	quitterButton.addActionListener(new ButtonListener());
	bh17.add(quitterButton);
	
	searchButton.addActionListener(new ButtonListener());
	bh18.add(searchButton);
	
	this.add(bh);
	bv1.add(listScroller);
	bv1.add(bh13);
	bv1.add(bh14);
	bv1.add(bh15);
	bv1.add(bh16);
	bv1.add(bh17);
	
	}
	    
	public class ButtonListener implements ActionListener {

		@Override
		public void actionPerformed(ActionEvent e) {
			// TODO Auto-generated method stub
			if (e.getSource()==ajouterButton) {
				ajouterButton.setToolTipText("Cliquez ici pour ajouter le étudiant.");
			              
            
				String id_etudiant = id_etudiantTextField.getText();
				String groupe = (String)comboGroupe.getSelectedItem();
				String nom = nomTextField.getText();
				String prenom = prenomTextField.getText();
				String birth_day = birth_dayTextField.getText();
				String sexe = (String)comboSexe.getSelectedItem();
				String email = emailTextField.getText();
				String addresse = addresseTextField.getText();
				String ville = villeTextField.getText();
				String codePostal = codePostalTextField.getText();
				String pays = paysTextField.getText();
				String telefone = telefoneTextField.getText();
				
							
				Etudiants etudiant1 = new Etudiants(id_etudiant, groupe, nom, prenom, birth_day, sexe, email,  
					 addresse, ville, codePostal, pays, telefone);
				// appel au DAO pour ajoute etudiant 
				MainWindow.linkDB.ajouterEtudiants(etudiant1);
				listeEtudiants=MainWindow.linkDB.getAllEtudiants();	
				etudiants.setListData(listeEtudiants.toArray());
				
				
			} else if (e.getSource() == modifierButton) {
			  modifierButton.setToolTipText("Cliquez ici pour modifier le étudiant.");	
			
				
				String id_etudiant = id_etudiantTextField.getText();
				String groupe = (String)comboGroupe.getSelectedItem();
				String prenom = prenomTextField.getText();
				String birth_day = birth_dayTextField.getText();
				String sexe = (String) comboSexe.getSelectedItem();
				String email = emailTextField.getText();
				String addresse = addresseTextField.getText();
				String ville = villeTextField.getText();
				String codePostal = codePostalTextField.getText();
				String pays = paysTextField.getText();
				String telefone = telefoneTextField.getText();
				String nom = nomTextField.getText();
			
				Etudiants etudiant1 = new Etudiants(id_etudiant, groupe, nom, prenom, birth_day, sexe, email,  
						 addresse, ville, codePostal, pays, telefone);
					MainWindow.linkDB.modifierEtudiants(etudiant1);	
					listeEtudiants=MainWindow.linkDB.getAllEtudiants();
				etudiants.setListData(listeEtudiants.toArray());
				
		    }  
			else if (e.getSource() == supprimerButton) {
		    	supprimerButton.setToolTipText("Cliquez ici pour supprimer le étudiant");
		    	 
		    	
					String id_etudiant = id_etudiantTextField.getText();
					String groupe = groupeTextField.getText();
					String prenom = prenomTextField.getText();
					String birth_day = birth_dayTextField.getText();
					String sexe = (String) comboSexe.getSelectedItem().toString();
					String email = emailTextField.getText();
					String addresse = addresseTextField.getText();
					String ville = villeTextField.getText();
					String codePostal = codePostalTextField.getText();
					String pays = paysTextField.getText();
					String telefone = telefoneTextField.getText();
					String nom = nomTextField.getText();
					
				Etudiants etudiant1 = new Etudiants(id_etudiant, groupe, nom, prenom, birth_day, sexe, email,  
							 addresse, ville, codePostal, pays, telefone);
					MainWindow.linkDB.deleteEtudiants(etudiant1);	
					listeEtudiants=MainWindow.linkDB.getAllEtudiants();
					etudiants.setListData(listeEtudiants.toArray());
		    	
		    	
		    } else if (e.getSource() == clearButton) {
		        // do other stuff
		    	 
		             //Clearing Fields
		            
		    	     id_etudiantTextField.setText("");
		    	     comboGroupe.setSelectedIndex(0);
		             nomTextField.setText("");
		             prenomTextField.setText("");
		             birth_dayTextField.setText("");
		             comboSexe.setSelectedIndex(0);
		             emailTextField.setText("");
		             addresseTextField.setText("");
		             villeTextField.setText("");
		             codePostalTextField.setText("");
		             paysTextField.setText("");
		             telefoneTextField.setText("");
		                 	
		    	
		    } else if (e.getSource() == quitterButton) {
		    	quitterButton.setToolTipText("Cliquez ici pour fermer le programme.");
		    	
		    	System.exit(0);
		    	
		    }
		   else if (e.getSource() == searchButton) {
		    	searchButton.setToolTipText("Cliquez ici pour chercher .");	    	
		    	
		    	String id_etudiant = id_etudiantTextField.getText();
		    	String groupe = (String)comboGroupe.getSelectedItem();
		    	//String groupe = groupeTextField.getText();
				String prenom = prenomTextField.getText();
				String birth_day = birth_dayTextField.getText();
				String sexe = (String) comboSexe.getSelectedItem().toString();
			//	String sexe = sexeTextField.getText();
				String email = emailTextField.getText();
				String addresse = addresseTextField.getText();
				String ville = villeTextField.getText();
				String codePostal = codePostalTextField.getText();
				String pays = paysTextField.getText();
				String telefone = telefoneTextField.getText();
				String nom = searchTextField.getText();
				
			Etudiants etudiant1 = new Etudiants(id_etudiant, groupe, nom, prenom, birth_day, sexe, email,  
						 addresse, ville, codePostal, pays, telefone);
				MainWindow.linkDB.searchEtudiants(etudiant1);	
				listeEtudiants=MainWindow.linkDB.getAllEtudiants();
			//	etudiants.setListData(listeEtudiants.toArray());
	    	
		    	
		    	
			 		    	
		    	/*MainWindow.linkDB.searchEtudiants(null);
		    	String selection = (String)comboBoxSelect.getSelectedItem();
		    	//setString(1, searchTextField.getText());	    	
		    	 nomTextField.setText(searchTextField.getText());
		    	//ps.setString(1, searchTextField.getText());
		    	*/
		    }
			
			
			
			
				System.out.println(e.getSource());
				
			} 
		
			
		}
		
	

	}  		
