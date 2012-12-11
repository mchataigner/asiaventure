package fr.insarouen.asi.prog.asiaventure.interfaces ;

import fr.insarouen.asi.prog.asiaventure.Simulateur ;
import fr.insarouen.asi.prog.asiaventure.NomDEntiteDejaUtiliseDansLeMondeException ;
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.io.*;

  /**
   * @author Gabriel Wiart et Delphine Soula 
   */
 
public class FenetreCreerUnePartie implements ActionListener {

  private JFrame maFenetre = new JFrame("ASI Aventure : créer une partie");
  private Container contentPane = maFenetre.getContentPane(); 
 
  private JLabel consigne = new JLabel("Nom de la partie : "); 
  private String [] listeChoix = { " ", "exemplesimulation1.aa"};
  private JComboBox choix = new JComboBox(listeChoix);
  private JButton validation = new JButton ("ok");
  private Simulateur simulateur ;
   

  public FenetreCreerUnePartie (){
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
    String nomFichier = listeChoix[choix.getSelectedIndex()].trim(); 
    if(!nomFichier.equals("")){
      try{
        simulateur = new Simulateur(new FileReader("./"+nomFichier));
        new FenetreJouerUnePartie(simulateur);
        maFenetre.dispose();
      }
      catch(IOException ex){consigne.setText("Nom incorrecte ! Nom du fichier : ");maFenetre.pack();maFenetre.setVisible(true);}
      catch(NomDEntiteDejaUtiliseDansLeMondeException ex){System.out.println("Entite deja existante !!!");}

    }
  }

}
