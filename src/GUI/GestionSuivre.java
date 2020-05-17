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
import Gestiondesetudiants.Groupe;
import Gestiondesetudiants.Suivre;
import login.LoginFrame.ButtonListener;

import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;

public class GestionSuivre extends JPanel {
	JButton ajouterButton = new JButton ("Ajouter");
	JButton modifierButton = new JButton ("Modifier");
	JButton supprimerButton = new JButton ("Supprimer");
	JButton clearButton = new JButton ("Reset");
	JButton quitterButton = new JButton ("Quitter");
	
	JTextField id_etudiantTextField = new JTextField();
	JTextField id_coursTextField = new JTextField();
	ArrayList<Suivre> listeSuivre;
	
	public GestionSuivre() 
	{
		listeSuivre = MainWindow.linkDB.getAllSuivre();  
		System.out.println(listeSuivre);
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
		
		JLabel id_etudiantLabel = new JLabel("ID_etudiant:");
		JLabel id_coursLabel = new JLabel("ID_cours:");
		
		
		
	

	// etudiant1 , 2 vont etre remplacé par notre base de données)
	JList suivre = new JList (listeSuivre.toArray());

	 suivre.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
		
	 suivre.addListSelectionListener(
             new ListSelectionListener() {
                  public void valueChanged(ListSelectionEvent e) {
                	
                	  Suivre element = (Gestiondesetudiants.Suivre) suivre.getSelectedValue();
                	  
                	   id_etudiantTextField.setText(element.getId_etudiant());
                	   id_coursTextField.setText(element.getid_cours());
                	   
                  }
             });
	
	  
	
	
	
	//pour ajouter scolling line
	JScrollPane listScroller = new JScrollPane(suivre);
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
	bv2.add(bh10);
	
	
	id_etudiantTextField.setColumns(30);
	id_coursTextField.setColumns(30);
	
	bh1.add(id_etudiantLabel);
	bh1.add(Box.createHorizontalGlue());
	bh1.add(id_etudiantTextField);
	
	bh2.add(id_coursLabel);
	bh2.add(Box.createHorizontalGlue());
	bh2.add(id_coursTextField);
	
		
	ajouterButton.addActionListener(new ButtonListener());
	bh3.add(ajouterButton);
	
	modifierButton.addActionListener(new ButtonListener());
	bh4.add(modifierButton);
	
	supprimerButton.addActionListener(new ButtonListener());
	bh5.add(supprimerButton);
	
	clearButton.addActionListener(new ButtonListener());
	bh6.add(clearButton);
	
	quitterButton.addActionListener(new ButtonListener());
	bh7.add(quitterButton);
	
	this.add(bh);
	bv1.add(listScroller);
	bv1.add(bh3);
	bv1.add(bh4);
	bv1.add(bh5);
	bv1.add(bh6);
	bv1.add(bh7);
	}
	public class ButtonListener implements ActionListener {

		@Override
		public void actionPerformed(ActionEvent e) {
			// TODO Auto-generated method stub
			if (e.getSource()==ajouterButton) {
				ajouterButton.setToolTipText("Cliquez ici pour ajouter le étudiant.");
		//	MainWindow.linkDB.ajouterSuivre(null);
				
			
				
				/*
				
				
				
				
				String id_etudiant = rs.getString("id_etudiant");
				String id_cours = rs.getString("id_cours");
				JList suivre = new JList (listeSuivre.toArray());

				
				
				*/
				
				
			} else if (e.getSource() == modifierButton) {
		       
		    } else if (e.getSource() == supprimerButton) {
		    	supprimerButton.setToolTipText("Cliquez ici pour supprimer");
		    } else if (e.getSource() == clearButton) {
		        // do other stuff
		    	
		    	 id_etudiantTextField.setText("");
	             id_coursTextField.setText("");
		    	
		    	
		    } else if (e.getSource() == quitterButton) {
		    	quitterButton.setToolTipText("Cliquez ici pour fermer le programme.");
		    	
		    	System.exit(0);
		    }
				System.out.println(e.getSource());
				
			} 
		
			
		}
		
		

	}  		
