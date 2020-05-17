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
import Gestiondesetudiants.Resultat;
import login.LoginFrame.ButtonListener;

import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;


public class GestionResultat extends JPanel {
	JButton ajouterButton = new JButton ("Ajouter");
	JButton modifierButton = new JButton ("Modifier");
	JButton supprimerButton = new JButton ("Supprimer");
	JButton clearButton = new JButton ("Reset");
	JButton quitterButton = new JButton ("Quitter");
	
	JTextField id_resultatTextField = new JTextField();
	JTextField etudiantTextField = new JTextField();
	JTextField pointsTextField = new JTextField();
	//JTextField profTextField = new JTextField();
	JTextField coursTextField = new JTextField();
	
	ArrayList<Resultat> listeResultat;
	
	public GestionResultat() 
	{
		listeResultat = MainWindow.linkDB.getAllResultat();  
		System.out.println(listeResultat);
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
		
		JLabel id_resultatLabel = new JLabel("ID_Resultat:");
		JLabel etudiantLabel = new JLabel("Etudiant:");
		JLabel pointsLabel = new JLabel("Points:");
		//JLabel profLabel = new JLabel("Professeur:");
		JLabel coursLabel = new JLabel("Cours:");
		
		
		
		
		
		

	// etudiant1 , 2 vont etre remplac� par notre base de donn�es)
	JList resultat = new JList (listeResultat.toArray());
	
	resultat.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
	
	 resultat.addListSelectionListener(
            new ListSelectionListener() {
                 public void valueChanged(ListSelectionEvent e) {
               	
               	  Resultat element = (Gestiondesetudiants.Resultat) resultat.getSelectedValue();
               	  
               	   
               	 
               	      id_resultatTextField.setText(element.getId_resultat());
               	      etudiantTextField.setText(element.getEtudiant());
                      pointsTextField.setText(element.getpoints());
                 //     profTextField.setText(element.getprof());
                      coursTextField.setText(element.getcours());
                       
                 }
            });
	 
	
	//pour ajouter scolling line
	JScrollPane listScroller = new JScrollPane(resultat);
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
	
	
	id_resultatTextField.setColumns(30);
	etudiantTextField.setColumns(30);
	coursTextField.setColumns(30);
	bh1.add(id_resultatLabel);
	bh1.add(Box.createHorizontalGlue());
	bh1.add(id_resultatTextField);
	
	bh2.add(etudiantLabel);
	bh2.add(Box.createHorizontalGlue());
	bh2.add(etudiantTextField);
	
	bh3.add(pointsLabel);
	bh3.add(Box.createHorizontalGlue());
	bh3.add(pointsTextField);
	
	/*bh4.add(profLabel);
	bh4.add(Box.createHorizontalGlue());
	bh4.add(profTextField);
	*/
	bh5.add(coursLabel);
	bh5.add(Box.createHorizontalGlue());
	bh5.add(coursTextField);
	
	
	
	ajouterButton.addActionListener(new ButtonListener());
	bh6.add(ajouterButton);
	
	modifierButton.addActionListener(new ButtonListener());
	bh7.add(modifierButton);
	
	supprimerButton.addActionListener(new ButtonListener());
	bh8.add(supprimerButton);
	
	clearButton.addActionListener(new ButtonListener());
	bh9.add(clearButton);
	
	quitterButton.addActionListener(new ButtonListener());
	bh10.add(quitterButton);
	
	this.add(bh);
	bv1.add(listScroller);
	bv1.add(bh6);
	bv1.add(bh7);
	bv1.add(bh8);
	bv1.add(bh9);
	bv1.add(bh10);
	}
	
	
	
   
	
    
	public class ButtonListener implements ActionListener {

		@Override
		public void actionPerformed(ActionEvent e) {
			// TODO Auto-generated method stub
			if (e.getSource()==ajouterButton) {
				
			}
			
			else if (e.getSource() == modifierButton) {
				
				//			 MainWindow.linkDB.modifierEtudiants(null);
							
							
					       
					    } else if (e.getSource() == supprimerButton) {
					    	supprimerButton.setToolTipText("Cliquez ici pour supprimer");
					    //	 MainWindow.linkDB.modifierEtudiants(null);
					    	 
					    	
					    	
					    } else if (e.getSource() == clearButton) {
					        // do other stuff
					    	 
					             //Clearing Fields
					            
					    	     id_resultatTextField.setText("");
					             etudiantTextField.setText("");
					             pointsTextField.setText("");
					     //        profTextField.setText("");
					             coursTextField.setText("");
					             
					    	
					    	
					    } else if (e.getSource() == quitterButton) {
					    	quitterButton.setToolTipText("Cliquez ici pour fermer le programme.");
					    	
					    	System.exit(0);
					    }
				System.out.println(e.getSource());
				
			}
		
			
		}
		
		

	}  		

