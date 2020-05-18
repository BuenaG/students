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
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.ListSelectionModel;
import javax.swing.ScrollPaneConstants;

import Gestiondesetudiants.Etudiants;
import login.LoginFrame.ButtonListener;

import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;

import DB.LinkDatabase;






public class GestionEtudiants extends JPanel {
	//initializing elements of the window
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
	Object[][] listeEtudiants2;
	
	public GestionEtudiants() 
	
	{
		listeEtudiants = MainWindow.linkDB.getAllEtudiants();  
//		listeEtudiants2 = MainWindow.linkDB.getAllEtudiants(); 
	
		System.out.println(listeEtudiants);
		
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
		
		
		
		

	// etudiant1 , 2 vont etre remplac� par notre base de donn�es)
		
		//afficher les etudiants
	 etudiants = new JList (listeEtudiants.toArray());
	 etudiants.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
	 //listen to list item selection to fill the textfields for viewing and editing 
	 etudiants.addListSelectionListener(
             new ListSelectionListener() {
                  public void valueChanged(ListSelectionEvent e) {
                      //renvoie la valeur s�lectionn�e de l'�l�ment de la liste
                	  
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
                } 
             );
	
	
	 
	 
	//pour ajouter scolling line
	JScrollPane listScroller = new JScrollPane(etudiants);
	//create table with data
	//listScroller.setVerticalScrollBarPolicy(ScrollPaneConstants.VERTICAL_SCROLLBAR_ALWAYS);
	
//  BEGINNING OF LAYOUT CODE
//	creation of the main panel layout boxe
	Box mainBoxV = Box.createVerticalBox();
//  vertical box elements	
	Box bh = Box.createHorizontalBox();
	Box menuBoxH = Box.createHorizontalBox();
	Box searchBoxH = Box.createHorizontalBox();
	Box tableBoxH = Box.createHorizontalBox();
	
	Box bv1 = Box.createVerticalBox();
	Box formElementsBoxV= Box.createVerticalBox();
	
//	devid the panel into 3 or more vertical columns 
	mainBoxV.add(bh);
	// use of createVerticalstrut to space the main buttons from the from elements
	mainBoxV.add(Box.createVerticalStrut(20));
	mainBoxV.add(menuBoxH);
	mainBoxV.add(Box.createVerticalStrut(10));
	mainBoxV.add(searchBoxH);
	mainBoxV.add(Box.createVerticalStrut(10));
	mainBoxV.add(tableBoxH);
//	addint table to the table box horizontal
	tableBoxH.add(bv1);
//mettre 2 box(bv1 et formElementsBoxV) dans un box (bh)
	bh.add(Box.createHorizontalStrut(20));
	
//	bh.add(bv1);
	bh.add(formElementsBoxV);
//	bh.add(searchBoxH);
	
//	box assignment and elements
//	form elements and box creations	
	Box bh1 = Box.createHorizontalBox();
	bh1.add(id_etudiantLabel);
	bh1.add(Box.createHorizontalGlue());
	bh1.add(id_etudiantTextField);
	
	Box bh2 = Box.createHorizontalBox();
	bh2.add(groupeLabel);
	bh2.add(Box.createHorizontalGlue());
	bh2.add(comboGroupe);
	bh2.add(Box.createHorizontalGlue());
	bh2.add(comboGroupe);
	
	Box bh3 = Box.createHorizontalBox();
	bh3.add(nomLabel);
	bh3.add(Box.createHorizontalGlue());
	bh3.add(nomTextField);
	
	Box bh4 = Box.createHorizontalBox();
	bh4.add(prenomLabel);
	bh4.add(Box.createHorizontalGlue());
	bh4.add(prenomTextField);
	
	Box bh5 = Box.createHorizontalBox();
	bh5.add(birth_dayLabel);
	bh5.add(Box.createHorizontalGlue());
	bh5.add(birth_dayTextField);
	
	Box bh6 = Box.createHorizontalBox();
	bh6.add(sexeLabel);
	bh6.add(Box.createHorizontalGlue());
	bh6.add(comboSexe);
	bh6.add(Box.createHorizontalGlue());
	bh6.add(comboSexe);
	//bh6.add(sexeTextField);
	
	Box bh7 = Box.createHorizontalBox();
	bh7.add(emailLabel);
	bh7.add(Box.createHorizontalGlue());
	bh7.add(emailTextField);
	
	Box bh8 = Box.createHorizontalBox();
	bh8.add(addresseLabel);
	bh8.add(Box.createHorizontalGlue());
	bh8.add(addresseTextField);
	
	Box bh9 = Box.createHorizontalBox();
	bh9.add(villeLabel);
	bh9.add(Box.createHorizontalGlue());
	bh9.add(villeTextField);
	
	Box bh10 = Box.createHorizontalBox();
	bh10.add(codePostalLabel);
	bh10.add(Box.createHorizontalGlue());
	bh10.add(codePostalTextField);
	
	Box bh11 = Box.createHorizontalBox();
	bh11.add(paysLabel);
	bh11.add(Box.createHorizontalGlue());
	bh11.add(paysTextField);
	
	Box bh12 = Box.createHorizontalBox();
	bh12.add(telefoneLabel);
	bh12.add(Box.createHorizontalGlue());
	bh12.add(telefoneTextField);


	formElementsBoxV.add(bh1);
	formElementsBoxV.add(bh2);
	formElementsBoxV.add(bh3);
	formElementsBoxV.add(bh4);
	formElementsBoxV.add(bh5);
	formElementsBoxV.add(bh6);
	formElementsBoxV.add(bh7);
	formElementsBoxV.add(bh8);
	formElementsBoxV.add(bh9);
	formElementsBoxV.add(bh10);
	formElementsBoxV.add(bh11);
	formElementsBoxV.add(bh12);
//	formElementsBoxV.add(searchBoxH);
//	form elements extract properties
	nomTextField.setColumns(30);
	prenomTextField.setColumns(30);
	
//	action/menu buttons
	Box ajouterBoxH = Box.createHorizontalBox();
	ajouterButton.addActionListener(new ButtonListener());
	ajouterBoxH.add(ajouterButton);
	
	Box modifierBoxH = Box.createHorizontalBox();
	modifierButton.addActionListener(new ButtonListener());
	modifierBoxH.add(modifierButton);
	
	Box supprimerBoxH = Box.createHorizontalBox();
	supprimerButton.addActionListener(new ButtonListener());
	supprimerBoxH.add(supprimerButton);
	
	Box clearBoxH = Box.createHorizontalBox();
	clearButton.addActionListener(new ButtonListener());
	clearBoxH.add(clearButton);
	
	Box quitterBoxH = Box.createHorizontalBox();
	quitterButton.addActionListener(new ButtonListener());
	quitterBoxH.add(quitterButton);
	
	searchButton.addActionListener(new ButtonListener());

	this.add(mainBoxV);
	bv1.add(listScroller);
//	button layout a horizontal box
	menuBoxH.add(ajouterBoxH);
	menuBoxH.add(modifierBoxH);
	menuBoxH.add(supprimerBoxH);
	menuBoxH.add(clearBoxH);
	menuBoxH.add(quitterBoxH);
//	Search area vertical box and elements
	
	searchBoxH.add(searchLabel);
	searchBoxH.add(Box.createHorizontalGlue());
	searchBoxH.add(searchTextField);
	searchBoxH.add(searchButton);
	
	
	
	}
	    
	public class ButtonListener implements ActionListener {

		@Override
		public void actionPerformed(ActionEvent e) {
			// TODO Auto-generated method stub
			if (e.getSource()==ajouterButton) {
				ajouterButton.setToolTipText("Cliquez ici pour ajouter le �tudiant.");
			              
            
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
			  modifierButton.setToolTipText("Cliquez ici pour modifier le �tudiant.");	
			
				
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
		    	supprimerButton.setToolTipText("Cliquez ici pour supprimer le �tudiant");
		    	 
		    	
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
