package GUI;



import java.awt.Color;
import java.awt.Dimension;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.ArrayList;

import javax.swing.Box;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.JList;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.ListSelectionModel;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;
import javax.swing.table.DefaultTableModel;

import GUI.GestionEtudiants.ButtonListener;
import Gestiondesetudiants.Etudiants;
import Gestiondesetudiants.Info;

public class GestionInfo extends JPanel  {
	JButton loadTable = new JButton ("Load Data");
	JButton modifierButton = new JButton ("Modifier");
	JButton supprimerButton = new JButton ("Supprimer");
	JButton clearButton = new JButton ("Reset");
	JButton quitterButton = new JButton ("Quitter");
	JButton searchButton = new JButton ("Search");
	
	JComboBox<String> comboBoxNom;
	JTable table;
	
	
	JTextField id_etudiantTextField = new JTextField();
	JTextField groupeTextField = new JTextField();
	JTextField nomTextField = new JTextField();
	JTextField prenomTextField = new JTextField();
	JTextField nom_coursTextField = new JTextField();
	JTextField pointsTextField = new JTextField();
	/*JTextField emailTextField = new JTextField();
	JTextField addresseTextField = new JTextField();
	JTextField villeTextField = new JTextField();
	JTextField codePostalTextField = new JTextField();
	JTextField paysTextField = new JTextField();
	JTextField telefoneTextField = new JTextField();*/
	JTextField searchTextField = new JTextField();
	
	private JComboBox comboSexe;
	
	ArrayList<Info> listeInfo;
	JList info;
	public GestionInfo() 
	
	{
		listeInfo = MainWindow.linkDB.getAllInfo();  
	
		System.out.println(listeInfo);
		
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
		JLabel nom_coursLabel = new JLabel("Cours:");
		JLabel pointsLabel = new JLabel("Resultat:");
		/*JLabel emailLabel = new JLabel("Email:");
		JLabel addresseLabel = new JLabel("Adresse:");
		JLabel villeLabel = new JLabel("Ville:");
		JLabel codePostalLabel = new JLabel("Code Postal:");
		JLabel paysLabel = new JLabel("Pays:");
		JLabel telefoneLabel = new JLabel("Telephone:");*/
		JLabel searchLabel = new JLabel("");
	
		
		searchTextField.setBackground(Color.GREEN);
		searchTextField.setForeground(Color.BLACK);
		searchTextField.setBounds(465, 86, 117, 22);
		searchTextField.setColumns(10);
		
		
	JTable table= new JTable();
	JScrollPane tableScrollPage= new JScrollPane();
	tableScrollPage.setPreferredSize(new Dimension(400,400));
	
	
		

	// etudiant1 , 2 vont etre remplacé par notre base de données)
		
		//afficher les etudiants
	 info = new JList (listeInfo.toArray());
		
	 info.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
	
	 info.addListSelectionListener(
             new ListSelectionListener() {
                 
            	 public void valueChanged(ListSelectionEvent e) {
                      //renvoie la valeur sélectionnée de l'élément de la liste
                	  
                	  Info element = (Gestiondesetudiants.Info) info.getSelectedValue();
                	  if (element !=null) {               	                   	 
                	   id_etudiantTextField.setText(element.getid_etudiant());
                	   groupeTextField.setText(element.getgroupe());
                	   nomTextField.setText(element.getnom());
                       prenomTextField.setText(element.getprenom());
                       nom_coursTextField.setText(element.getnom_cours());
                       pointsTextField.setText(element.getpoints());
                       
                     
                       
                  }
                  
                  }
                  } );
	
	
	 
	 
	//pour ajouter scolling line
	JScrollPane listScroller = new JScrollPane(info);
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
	bh2.add(groupeTextField);
	
	bh3.add(nomLabel);
	bh3.add(Box.createHorizontalGlue());
	bh3.add(nomTextField);
	
	bh4.add(prenomLabel);
	bh4.add(Box.createHorizontalGlue());
	bh4.add(prenomTextField);
	
	bh5.add(nom_coursLabel);
	bh5.add(Box.createHorizontalGlue());
	bh5.add(nom_coursTextField);
	
	bh6.add(pointsLabel);
	bh6.add(Box.createHorizontalGlue());
	bh6.add(pointsTextField);
	
	
	
	bh18.add(searchLabel);
	bh18.add(Box.createHorizontalGlue());
	bh18.add(searchTextField);
	
	
	
	loadTable.addActionListener(new ButtonListener());
	bh13.add(loadTable);
	
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
			if (e.getSource()==loadTable) {
			
				/*ajouterButton.setToolTipText("Cliquez ici pour ajouter le étudiant.");
			  
				
			            
            
				String id_etudiant = id_etudiantTextField.getText();
				String groupe = groupeTextField.getText();
				String nom = nomTextField.getText();
				String prenom = prenomTextField.getText();
				
			
				
				Etudiants etudiant1 = new Etudiants(id_etudiant, groupe, nom, prenom, );
				// appel au DAO pour ajoute etudiant 
				MainWindow.linkDB.ajouterEtudiants(etudiant1);
				listeEtudiants=MainWindow.linkDB.getAllEtudiants();
				etudiants.setListData(listeEtudiants.toArray());*/
					
				
				
			} else if (e.getSource() == modifierButton) {
				
			
				
				
			
				
		    }  
			else if (e.getSource() == supprimerButton) {
		    	supprimerButton.setToolTipText("Cliquez ici pour supprimer le étudiant");
		    	 
		    	
				/*	String id_etudiant = id_etudiantTextField.getText();
					String groupe = groupeTextField.getText();
					String prenom = prenomTextField.getText();
					String birth_day = coursTextField.getText();
					String sexe = resultatTextField.getText();
					
					String nom = nomTextField.getText();
					
				Info info1 = new Info(id_etudiant, groupe, nom, prenom, cours, resultat);
					MainWindow.linkDB.deleteEtudiants(etudiant1);	
					listeEtudiants=MainWindow.linkDB.getAllEtudiants();
					etudiants.setListData(listeEtudiants.toArray());*/
		    	
		    	
		    } else if (e.getSource() == clearButton) {
		        // do other stuff
		    	 
		             //Clearing Fields
		            
		    	     id_etudiantTextField.setText("");
		             groupeTextField.setText("");
		             nomTextField.setText("");
		             prenomTextField.setText("");
		            // coursTextField.setText("");
		             pointsTextField.setText("");
		            
		             
		         
		    	
		    	
		    } else if (e.getSource() == quitterButton) {
		    	quitterButton.setToolTipText("Cliquez ici pour fermer le programme.");
		    	
		    	System.exit(0);
		    	
		    }
		   else if (e.getSource() == searchButton) {
		    	searchButton.setToolTipText("Cliquez ici pour chercher .");
		    	
		    	
		    	
		    	
		    	
		    	
		    	
		    	
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




