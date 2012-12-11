package fr.insarouen.asi.prog.asiaventure.interfaces ;

import fr.insarouen.asi.prog.asiaventure.Simulateur ; 
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.io.*;

  /**
   * @author Gabriel Wiart et Delphine Soula 
   */
 
public class FenetreReprendreUnePartie implements ActionListener{

  private JFrame maFenetre = new JFrame("ASI Aventure : reprendre une partie");
  private Container contentPane = maFenetre.getContentPane(); 
 
  private JLabel consigne = new JLabel("Nom du fichier : ");
  private JTextField choix = new JTextField("",15);
  private JButton validation = new JButton ("ok");
  private Simulateur simulateur ;
  
  public FenetreReprendreUnePartie (){
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
        simulateur = new Simulateur(new ObjectInputStream(new FileInputStream("./"+nomFichier)));
        new FenetreJouerUnePartie(simulateur);
        maFenetre.dispose();
      }
      catch(IOException ex){consigne.setText("Nom incorrecte ! Nom du fichier : ");maFenetre.pack();maFenetre.setVisible(true);}
      catch(ClassNotFoundException ex){System.out.println("Classe non trouvé");}

    }

  }
}
