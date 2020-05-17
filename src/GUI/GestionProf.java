package GUI;

import java.awt.BorderLayout;
import java.awt.Container;
import java.awt.Label;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyListener;
import java.util.ArrayList;
import javax.swing.Box;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JList;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextField;
import javax.swing.ListSelectionModel;
import javax.swing.ScrollPaneConstants;
import Gestiondesetudiants.Etudiants;
import Gestiondesetudiants.Prof;
import Gestiondesetudiants.ProfC;
import login.LoginFrame.ButtonListener;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;


public class GestionProf extends JPanel {
	JButton ajouterButton = new JButton ("Ajouter");
	JButton modifierButton = new JButton ("Modifier");
	JButton supprimerButton = new JButton ("Supprimer");
	JButton clearButton = new JButton ("Reset");
	JButton quitterButton = new JButton ("Quitter");
	
	JTextField id_profTextField = new JTextField();
	JTextField nomTextField = new JTextField();
	JTextField prenomTextField = new JTextField();
	JTextField emailTextField = new JTextField();
	JTextField addresseTextField = new JTextField();
	JTextField villeTextField = new JTextField();
	JTextField codePostalTextField = new JTextField();
	JTextField paysTextField = new JTextField();
	JTextField telefoneTextField = new JTextField();
	
	ArrayList<Prof> listeProf;
	JList prof;
	
	ArrayList<ProfC> listeProfC;
	JList profc;
	
	public GestionProf() 
	{
		listeProf = MainWindow.linkDB.getAllProf();  
		System.out.println(listeProf);
		
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
		Box bv1 = Box.createVerticalBox();
		Box bv2= Box.createVerticalBox();
		
		JLabel id_profLabel = new JLabel("ID_prof:");
		JLabel nomLabel = new JLabel("Nom:");
		JLabel prenomLabel = new JLabel("Prenom:");
		JLabel emailLabel = new JLabel("Email:");
		JLabel addresseLabel = new JLabel("Adresse:");
		JLabel villeLabel = new JLabel("Ville:");
		JLabel codePostalLabel = new JLabel("Code Postal:");
		JLabel paysLabel = new JLabel("Pays:");
		JLabel telefoneLabel = new JLabel("Telephone:");
		
		
		
		
		

	// etudiant1 , 2 vont etre remplacé par notre base de données)
	prof = new JList (listeProf.toArray());

	 prof.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
		
	 prof.addListSelectionListener(
             new ListSelectionListener() {
                  public void valueChanged(ListSelectionEvent e) {
                	
                	  Prof element = (Gestiondesetudiants.Prof) prof.getSelectedValue();
                	  
                	   if (element !=null) {
                	 
                	   id_profTextField.setText(element.getId_prof());
                	   nomTextField.setText(element.getNom());
                       prenomTextField.setText(element.getPrenom());
                       emailTextField.setText(element.getEmail());
                       addresseTextField.setText(element.getAddresse());
                       villeTextField.setText(element.getVille());
                       codePostalTextField.setText(element.getCodePostal());
                       paysTextField.setText(element.getPays());
                       telefoneTextField.setText(element.getTelefone());
                       
             }  
                               
             }
             });
	
	
	//pour ajouter scolling line
	JScrollPane listScroller = new JScrollPane(prof);
	//listScroller.setVerticalScrollBarPolicy(ScrollPaneConstants.VERTICAL_SCROLLBAR_ALWAYS);
	 
//mettre 2 box(bv1 et bv2) dans un box (bh)
	bh.add(Box.createHorizontalStrut(20));
	bh.add(bv1);
	bh.add(bv2);
	bv2.add(bh1);
	bv2.add(bh2);
	bv2.add(bh3);
	bv2.add(bh4);
	bv2.add(bh5);
	bv2.add(bh6);
	bv2.add(bh7);
	bv2.add(bh8);
	bv2.add(bh9);
	
	
	
	nomTextField.setColumns(30);
	prenomTextField.setColumns(30);
	
	bh1.add(id_profLabel);
	bh1.add(Box.createHorizontalGlue());
	bh1.add(id_profTextField);
	bh2.add(nomLabel);
	bh2.add(Box.createHorizontalGlue());
	bh2.add(nomTextField);
	bh3.add(prenomLabel);
	bh3.add(Box.createHorizontalGlue());
	bh3.add(prenomTextField);
	bh4.add(emailLabel);
	bh4.add(Box.createHorizontalGlue());
	bh4.add(emailTextField);
	bh5.add(addresseLabel);
	bh5.add(Box.createHorizontalGlue());
	bh5.add(addresseTextField);
	bh6.add(villeLabel);
	bh6.add(Box.createHorizontalGlue());
	bh6.add(villeTextField);
	bh7.add(codePostalLabel);
	bh7.add(Box.createHorizontalGlue());
	bh7.add(codePostalTextField);
	bh8.add(paysLabel);
	bh8.add(Box.createHorizontalGlue());
	bh8.add(paysTextField);
	bh9.add(telefoneLabel);
	bh9.add(Box.createHorizontalGlue());
	bh9.add(telefoneTextField);
	
	ajouterButton.addActionListener(new ButtonListener());
	bh10.add(ajouterButton);
	
	modifierButton.addActionListener(new ButtonListener());
	bh11.add(modifierButton);
	
	supprimerButton.addActionListener(new ButtonListener());
	bh12.add(supprimerButton);
	
	clearButton.addActionListener(new ButtonListener());
	bh13.add(clearButton);
	
	quitterButton.addActionListener(new ButtonListener());
	bh14.add(quitterButton);
	
	this.add(bh);
	bv1.add(listScroller);
	bv1.add(bh10);
	bv1.add(bh11);
	bv1.add(bh12);
	bv1.add(bh13);
	bv1.add(bh14);
	}
	public class ButtonListener implements ActionListener {

		@Override
		public void actionPerformed(ActionEvent e) {
			// TODO Auto-generated method stub
			if (e.getSource()==ajouterButton) {
				
				ajouterButton.setToolTipText("Cliquez ici pour ajouter le prof.");
				   	            
	            
					String id_prof = id_profTextField.getText();
					String nom = nomTextField.getText();
					String prenom = prenomTextField.getText();
					String email = emailTextField.getText();
					String addresse = addresseTextField.getText();
					String ville = villeTextField.getText();
					String codePostal = codePostalTextField.getText();
					String pays = paysTextField.getText();
					String telefone = telefoneTextField.getText();
					
				
					
					Prof prof1 = new Prof(id_prof, nom, prenom, email,addresse, ville, codePostal, pays, telefone);
					
					MainWindow.linkDB.ajouterProf(prof1);	
					listeProf = MainWindow.linkDB.getAllProf();
				    prof.setListData(listeProf.toArray());
				  
				   
				    
		            	} else if (e.getSource() == modifierButton) {
				modifierButton.setToolTipText("Cliquez ici pour modifier le prof.");
   	            
	            
				String id_prof = id_profTextField.getText();
				String prenom = prenomTextField.getText();
				String email = emailTextField.getText();
				String addresse = addresseTextField.getText();
				String ville = villeTextField.getText();
				String codePostal = codePostalTextField.getText();
				String pays = paysTextField.getText();
				String telefone = telefoneTextField.getText();
				String nom = nomTextField.getText();
			
				
				Prof prof1 = new Prof(id_prof, nom, prenom, email, addresse, ville, codePostal, pays, telefone);
				
				MainWindow.linkDB.modifierProf(prof1);	
				listeProf = MainWindow.linkDB.getAllProf();
			    prof.setListData(listeProf.toArray());			
				
			   
			    
					    } else if (e.getSource() == supprimerButton) {
					    	supprimerButton.setToolTipText("Cliquez ici pour supprimer le prof");
					    
					    	String id_prof = id_profTextField.getText();
							String prenom = prenomTextField.getText();
							String email = emailTextField.getText();
							String addresse = addresseTextField.getText();
							String ville = villeTextField.getText();
							String codePostal = codePostalTextField.getText();
							String pays = paysTextField.getText();
							String telefone = telefoneTextField.getText();
							String nom = nomTextField.getText();
							
							Prof prof1 = new Prof(id_prof, nom, prenom, email, addresse, ville, codePostal, pays, telefone);
							
							MainWindow.linkDB.deleteProf(prof1);	
							listeProf = MainWindow.linkDB.getAllProf();
						    prof.setListData(listeProf.toArray());	
					    	
					    	
					    } else if (e.getSource() == clearButton) {
					        // do other stuff
					    	 
					             //Clearing Fields
					            
					    	     id_profTextField.setText("");
					             nomTextField.setText("");
					             prenomTextField.setText("");
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
			
				System.out.println(e.getSource());
				
			}
		
			
		
		
		
		
		}
		
		

	}  		
   	