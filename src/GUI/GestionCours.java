package GUI;

import java.awt.BorderLayout;
import java.awt.Container;
import java.awt.Label;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.ArrayList;
import javax.swing.Box;
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

import Gestiondesetudiants.Cours;
import Gestiondesetudiants.Courss;
import Gestiondesetudiants.Etudiants;
import Gestiondesetudiants.Prof;
import Gestiondesetudiants.ProfC;
import login.LoginFrame.ButtonListener;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;
import javax.swing.JPanel;

public class GestionCours extends JPanel {
	

	JButton ajouterButton = new JButton ("Ajouter");
	JButton modifierButton = new JButton ("Modifier");
	JButton supprimerButton = new JButton ("Supprimer");
	JButton clearButton = new JButton ("Reset");
	JButton quitterButton = new JButton ("Quitter");
	
	JTextField id_coursTextField = new JTextField();
	JTextField nom_coursTextField = new JTextField();
	JTextField profTextField = new JTextField();
	JTextField nomTextField = new JTextField();
	
	JComboBox<String> comboProf;
	
	ArrayList<Cours> listeCours;
    JList cours;
    
    ArrayList<Courss> listeCourss;
    JList courss;
    
    ArrayList<ProfC> listeProfC;
    JList profc;
    
    ArrayList<Prof> listeProf;
	JList prof;
    
	public GestionCours()
	{
	
		listeCours = MainWindow.linkDB.getAllCours();  
		System.out.println(listeCours);
		
		listeCourss = MainWindow.linkDB.getAllCourss();  
		System.out.println(listeCourss);
		
		listeProf = MainWindow.linkDB.getAllProf();  
		System.out.println(listeProf);
		
		listeProfC = MainWindow.linkDB.getAllProfC();  
		System.out.println(listeProfC);
		
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
    	
		Box bv1 = Box.createVerticalBox();
		Box bv2= Box.createVerticalBox();
		
		JLabel id_coursLabel = new JLabel("ID cours:");
		JLabel nom_coursLabel = new JLabel("Nom de cours:");
		JLabel profLabel = new JLabel("ID prof:");
		JLabel nomLabel = new JLabel("Professeur:");
		
		comboProf= new JComboBox();
		
		//comboProf=new JComboBox(listeProfC.toArray());!!!!
		
		//comboProf.setModel(new DefaultComboBoxModel<String>(listeProfC.toArray(new String[0])));
		
		DefaultComboBoxModel dml= new DefaultComboBoxModel();
		for (int i = 0; i < listeProfC.size(); i++) {
		  dml.addElement(listeProfC.get(i).getnom());
		  
		}

		comboProf.setModel(dml);
    	comboProf.revalidate();
		    comboProf.repaint(); 
		
		comboProf.addMouseListener(new MouseAdapter() {
			public void mouseClicked(MouseEvent e) {
				
			}
		});
	
		comboProf.addActionListener(new ActionListener() {
	            public void comboProfActionPerformed(ActionEvent e) {
	            	
	            }

				@Override
				public void actionPerformed(ActionEvent e) {
					// TODO Auto-generated method stub
					
				}
	        });	

		
		
		
		
		
		
		
		
		
		
		
		
		
	// etudiant1 , 2 vont etre remplacé par notre base de données)
		
	cours = new JList (listeCours.toArray());

	cours.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
	
	 cours.addListSelectionListener(
            new ListSelectionListener() {
                 public void valueChanged(ListSelectionEvent e) {
               
               	  Cours element = (Gestiondesetudiants.Cours) cours.getSelectedValue();
               	     if (element !=null) {
               	                 	 
               	      id_coursTextField.setText(element.getId_cours());
               	      nom_coursTextField.setText(element.getNom_cours());
               	      profTextField.setText(element.getProf());
               	      comboProf.setSelectedItem(element.getnom());
                      
                      
                 }
                 }
            });
      
	 courss = new JList (listeCourss.toArray());

		courss.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
		
		 courss.addListSelectionListener(
	            new ListSelectionListener() {
	                 public void valueChanged(ListSelectionEvent e) {
	               
	               	  Cours element = (Gestiondesetudiants.Cours) courss.getSelectedValue();
	               	     if (element !=null) {
	               	                 	 
	               	      id_coursTextField.setText(element.getId_cours());
	               	      nom_coursTextField.setText(element.getNom_cours());
	               	      profTextField.setText(element.getProf());
	               	    
	                      
	                      
	                 }
	                 }
	            });
	      	
	 
	 
	 
	
	//pour ajouter scolling line
    JScrollPane listScroller = new JScrollPane(cours);
	listScroller.setVerticalScrollBarPolicy(ScrollPaneConstants.VERTICAL_SCROLLBAR_ALWAYS);
	 
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
	bv2.add(bh10);
	
	
	id_coursTextField.setColumns(30);
	nom_coursTextField.setColumns(30);
	nomTextField.setColumns(30);
	
	bh1.add(id_coursLabel);
	bh1.add(Box.createHorizontalGlue());
	bh1.add(id_coursTextField);
	
	bh2.add(nom_coursLabel);
	bh2.add(Box.createHorizontalGlue());
	bh2.add(nom_coursTextField);
	
	bh10.add(profLabel);
	bh10.add(Box.createHorizontalGlue());
	bh10.add(profTextField);
	
	
	bh3.add(nomLabel);
	bh3.add(Box.createHorizontalGlue());
	//bh3.add(nomTextField);
	
	bh3.add(comboProf);
	bh3.add(Box.createHorizontalGlue());
	bh3.add(comboProf);
	
	
	ajouterButton.addActionListener(new ButtonListener());
	bh5.add(ajouterButton);
	
	modifierButton.addActionListener(new ButtonListener());
	bh6.add(modifierButton);
	
	supprimerButton.addActionListener(new ButtonListener());
	bh7.add(supprimerButton);
	
	clearButton.addActionListener(new ButtonListener());
	bh8.add(clearButton);
	
	quitterButton.addActionListener(new ButtonListener());
	bh9.add(quitterButton);
		
	
	this.add(bh);
	bv1.add(listScroller);
	bv1.add(bh5);
	bv1.add(bh6);
	bv1.add(bh7);
	bv1.add(bh8);
	bv1.add(bh9);
	}


	
    public class ButtonListener implements ActionListener {

             		@Override
             		public void actionPerformed(ActionEvent e) {
             			// TODO Auto-generated method stub
             			if (e.getSource()==ajouterButton) {
             				ajouterButton.setToolTipText("Cliquez ici pour ajouter le cours.");
             		
             				
             		
             		String id_cours = id_coursTextField.getText();
    				String nom_cours = nom_coursTextField.getText();
    				String prof = profTextField.getText();
    				//String nom = (String) comboProf.getSelectedItem();
    				          			
             		Courss cour2 = new Courss(id_cours, nom_cours, prof);		
             		
             		MainWindow.linkDB.ajouterCours(cour2);	
             		listeCourss=MainWindow.linkDB.getAllCourss();
             		courss.setListData(listeCourss.toArray());
  
             		
             		listeCours = MainWindow.linkDB.getAllCours(); 
             		cours.setListData(listeCours.toArray());
             		
             		
             		
             		
             		
             				
             			} else if (e.getSource() == modifierButton) {
             				 modifierButton.setToolTipText("Cliquez ici pour modifier le cours.");
                     		
             				
                     		
                     String id_cours = id_coursTextField.getText();
            		 String nom_cours = nom_coursTextField.getText();
            		 String prof = profTextField.getText();
            		
            				          			
            		 Courss cour2 = new Courss(id_cours, nom_cours, prof);		
              		
              		MainWindow.linkDB.modifierCours(cour2);	
              		listeCourss=MainWindow.linkDB.getAllCourss();
              		courss.setListData(listeCourss.toArray());
   
              		
              		listeCours = MainWindow.linkDB.getAllCours(); 
              		cours.setListData(listeCours.toArray());		
                     		
             		       
             		    } else if (e.getSource() == supprimerButton) {
             		    	supprimerButton.setToolTipText("Cliquez ici pour supprimer le cours");
             		    } else if (e.getSource() == clearButton) {
             		        // do other stuff
             		                 		    	
							id_coursTextField.setText("");
             	            nom_coursTextField.setText("");
             	            profTextField.setText("");
             	            
             	            
             		    	
             		    	
             		    } else if (e.getSource() == quitterButton) {
             		    	quitterButton.setToolTipText("Cliquez ici pour fermer le programme.");
             		    	
             		    	
             		    	
             		    	
             		    	
             		    	
             		    	//System.exit(0);
             		    }
             				System.out.println(e.getSource());
             				
             			
             		}
             		
    }   
    
}
             			
             		
             		
             		
            
                	