package fr.insarouen.asi.prog.asiaventure.interfaces ;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.io.*;

  /**
   * @author Gabriel Wiart et Delphine Soula 
   */
 
public class FenetreMenu implements ActionListener {

  private JFrame maFenetre = new JFrame("ASI Aventure : menu");
  private Container contentPane = maFenetre.getContentPane(); 
 
  private JLabel consigne = new JLabel("Menu Principale : "); 
  private String [] listeChoix = { " ", "Reprendre une partie" , "Créer une partie", "Quitter"};
  private JComboBox choix = new JComboBox(listeChoix);
  private JButton validation = new JButton ("ok");
  // private Simulateur simulateur ;
  // private JoueurHumain hero ; 

  public FenetreMenu (){
    maFenetre.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    
    contentPane.setLayout(new FlowLayout());

    contentPane.add(consigne);
    contentPane.add(choix);
    validation.addActionListener(this);
    contentPane.add(validation);

    maFenetre.pack();
    maFenetre.setVisible(true);
  }


  public void actionPerformed(ActionEvent e){
    int i=choix.getSelectedIndex();

    switch(i) {
      case 1 : {new FenetreReprendreUnePartie();maFenetre.dispose();} break ; 
      case 2 : {new FenetreCreerUnePartie();maFenetre.dispose();}break ;
      case 3 : maFenetre.dispose(); break ;  
    }
  }



}
