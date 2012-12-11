package fr.insarouen.asi.prog.asiaventure.interfaces ;

import fr.insarouen.asi.prog.asiaventure.Simulateur ; 
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.io.*;


  /**
   * @author Gabriel Wiart et Delphine Soula 
   */
 
public class FenetreEnregistrerUnePartie implements ActionListener {

  private JFrame maFenetre = new JFrame("ASI Aventure : enregistrer une partie");
  private Container contentPane = maFenetre.getContentPane(); 
 
  private JLabel consigne = new JLabel("Nom du fichier : ");
  private JTextField choix = new JTextField("",15);
  private JButton validation = new JButton ("ok");
  private Simulateur simulateur ;

  public FenetreEnregistrerUnePartie (Simulateur s){
    simulateur=s ; 
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
    String nomFichier = choix.getText().trim(); 
    if(!nomFichier.equals("")){
      try{
        simulateur.enregistrer(new ObjectOutputStream(new FileOutputStream("./"+nomFichier)));
        new FenetreMenu();
        maFenetre.dispose();
      }
      catch(IOException ex){consigne.setText("Nom incorrecte ! Nom du fichier : ");maFenetre.pack();maFenetre.setVisible(true);}
    }

  }

}
