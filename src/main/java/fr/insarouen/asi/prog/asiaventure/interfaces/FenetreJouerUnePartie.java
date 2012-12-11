package fr.insarouen.asi.prog.asiaventure.interfaces ;

import fr.insarouen.asi.prog.asiaventure.*; 
import fr.insarouen.asi.prog.asiaventure.elements.vivants.*;
import fr.insarouen.asi.prog.asiaventure.elements.objets.*;
import fr.insarouen.asi.prog.asiaventure.elements.structure.*;
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.util.*;

 
public class FenetreJouerUnePartie implements InterfaceHM
{
    private Simulateur s;
    private boolean quitter=false;
    
    
    private JFrame maFenetre = new JFrame("ASI Aventure : jouer");
    private Container contentPane = maFenetre.getContentPane(); 
 
    /*    private JPanel panneauInfo = new JPanel() ; 
          private JPanel panneauHero = new JPanel(); 
          private JLabel point;  
          private JLabel sac ;
          private JPanel panneauPiece = new JPanel(); 
          private JLabel contenu ;
          private JLabel porte ;*/
    private JLabel commentaire ; 
    
    private JPanel panneauInteractif = new JPanel();
    /*    private String [] listeChoix = { " ", "Jouer un tour" , "Enregistrer la partie", "Revenir au menu principal", "Quitter"};
          private JComboBox choix = new JComboBox(listeChoix);*/
    private JButton validation = new JButton ("ok");
    private JTextField ordre =new JTextField("",25); 

    private Simulateur simulateur ;
    private JoueurHumain jh; 
    private String nomAction ="";

    /*    private Collection<Objet> objetsPortes ;
          private Collection<Vivant> vivantsPiece ;
          private Collection<Porte> portesPiece;
    */
    public FenetreJouerUnePartie (Simulateur simulateur)
    {

        this.simulateur = simulateur ; 
        simulateur.addObserver(this);
        
        //hero = simulateur.getHero();
        maFenetre.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        
        /*contentPane.setLayout(new BorderLayout());
          panneauInfo.setLayout(new BorderLayout());
          panneauHero.setLayout(new BorderLayout());
          panneauPiece.setLayout(new BorderLayout());
          panneauHero.setBorder(BorderFactory.createTitledBorder("Héro : "+hero.getNom()));
          panneauPiece.setBorder(BorderFactory.createTitledBorder("Pièce : "+hero.getPiece().getNom()));
    
          point = new JLabel("Point vie : "+hero.getPointVie()+", Point Force :" +hero.getPointForce());
          panneauHero.add(BorderLayout.NORTH,point);
          sac = new JLabel("Sac : ");
          objetsPortes= hero.getObjets().values();
          for (Objet o : objetsPortes)
          sac.setText(sac.getText()+o.getNom()+" ");
          panneauHero.add(BorderLayout.SOUTH,sac); 
          panneauInfo.add(BorderLayout.NORTH,panneauHero);

          contenu = new JLabel("Contenu : ");
          vivantsPiece=hero.getPiece().getVivants().values();
          for (Vivant v : vivantsPiece)
          contenu.setText(contenu.getText()+v.getNom()+" ");
          contenu.setText(contenu.getText()+"\n");
          objetsPortes=hero.getPiece().getObjets().values();
          for (Objet o : objetsPortes)
          contenu.setText(contenu.getText()+o.getNom()+" ");
          panneauPiece.add(BorderLayout.NORTH,contenu);
        

          porte=new JLabel("Portes : ");
          portesPiece=hero.getPiece().getPortes().values();
          for(Porte p : portesPiece)
          porte.setText(porte.getText()+p.getNom()+" ");
          panneauPiece.add(BorderLayout.SOUTH,porte);
          panneauInfo.add(BorderLayout.SOUTH,panneauPiece);
          contentPane.add(BorderLayout.NORTH, panneauInfo);

        
        
          choix.setEnabled(true);
          panneauInteractif.add(choix);
        */
        ordre.setEnabled(true);
        //        ordre.setBackground(java.awt.Color.GRAY);
        panneauInteractif.add(ordre);
        validation.addActionListener(new GereEvt());
        panneauInteractif.add(validation);
        panneauInteractif.setBorder(BorderFactory.createTitledBorder("Que faire?"));
        contentPane.add(BorderLayout.CENTER, panneauInteractif);
    
        commentaire = new JLabel("...............");
        contentPane.add(BorderLayout.SOUTH, commentaire);

        maFenetre.pack();
        //maFenetre.setVisible(true);
    }
    /*  
        public void actionPerformed(ActionEvent e){
        int i = choix.getSelectedIndex();
        switch(i){
        case 1 : activerJouer(); break;
        case 2 : {new FenetreEnregistrerUnePartie(simulateur) ; maFenetre.dispose();}break;
        case 3 : {simulateur.stopperJeu(); new FenetreMenu(); maFenetre.dispose();}break;
        case 4 : {simulateur.stopperJeu(); maFenetre.dispose(); }break;
        }
    
        }
    */
    
    /*
      private void metterAJourLesInfos(String mot){
      point.setText("Point vie : "+hero.getPointVie()+", Point Force :" +hero.getPointForce());
      sac.setText("Sac : ");
      objetsPortes= hero.getObjets().values();
      for (Objet o : objetsPortes)
      sac.setText(sac.getText()+o.getNom()+" ");
      contenu.setText("Contenu : ");
      vivantsPiece=hero.getPiece().getVivants().values();
      for (Vivant v : vivantsPiece)
      contenu.setText(contenu.getText()+v.getNom()+" ");
      contenu.setText(contenu.getText()+"\n");
      objetsPortes=hero.getPiece().getObjets().values();
      for (Objet o : objetsPortes)
      contenu.setText(contenu.getText()+o.getNom()+" ");
      panneauPiece.add(BorderLayout.NORTH,contenu);
      porte.setText("Portes : ");
      portesPiece=hero.getPiece().getPortes().values();
      for(Porte p : portesPiece)
      porte.setText(porte.getText()+p.getNom()+" ");
    
      commentaire.setText(mot);

      maFenetre.pack(); 
      maFenetre.setVisible(true);
      }
    */
    /*
      private void activerJouer(){
      if(!ordre.isEnabled()){    
      ordre.setEnabled(true);
      choix.setEnabled(false);
      ordre.setText("Entrez ici votre ordre ");
      ordre.setBackground(java.awt.Color.WHITE);
      }
      else {
      jouer();
      ordre.setEnabled(false);
      choix.setEnabled(true);
      ordre.setBackground(java.awt.Color.GRAY);
      ordre.setText("");
      }
      }
    */
    
    public void update(Observable o,Object arg)
    {
        if(!maFenetre.isShowing())
            maFenetre.setVisible(true);
        ordre.setText("");
        this.jh=simulateur.getJH();
        
        commentaire.setText(jh.toString()+"\n"+jh.getPiece().toString());
        
        //System.out.println(jh);
        maFenetre.setVisible(true);
        //maFenetre.repaint();
    }
    class GereEvt implements ActionListener
    {
        
        public void actionPerformed(ActionEvent evt)
        {
            //System.out.println("Voulez-vous quitter ? O/N");
            String ordr=ordre.getText().trim();
            //System.out.println(ordr);
            if(simulateur.attendre())
                {
                    //                     if(ordr.toUpperCase().equals("O"))
                    //                         {
                    //                             quitter=true;
                    //                             simulateur.setQuitter();
                    //                         }
                    //                     else
                    //                         {
                    if(ordr.length()!=0)
                        {
                            //System.out.println(jh);
                                    
                            simulateur.setOrdreJH(ordr);
                            ordre.setText("");
                            //this.jh=null;
                            //simulateur.reprendre();
                                    
                        }
                    else if(ordr.toUpperCase().equals("QUITTER"))
                        {
                            maFenetre.setVisible(false);
                            simulateur.setQuitter();
                        }
                    simulateur.reprendre();

                    //}
                }
        }
    }
    
    public void run()
    {
	//while(!quitter);
    }
    /*
      private void jouer(){
      nomAction = ordre.getText().trim(); 
      String motCommentaire =" "; // COMMENTAIRE A AFFICHER 
      if(!nomAction.equals("")){
      hero.setOrdre(nomAction);
      try{
      simulateur.executerUnTour();
      }catch(java.lang.Throwable e) {} //A MODIFIER
      metterAJourLesInfos(motCommentaire);
      }
      }*/

}
