package fr.insarouen.asi.prog.asiaventure;

import fr.insarouen.asi.prog.asiaventure.*;
import fr.insarouen.asi.prog.asiaventure.elements.structure.*;
import fr.insarouen.asi.prog.asiaventure.elements.vivants.*;
import fr.insarouen.asi.prog.asiaventure.elements.objets.*;
import fr.insarouen.asi.prog.asiaventure.elements.objets.serrurerie.*;

import java.io.*;
import java.util.*;

/**
 * Describe class <code>Main</code> here.
 *
 * @author <a href="mailto:mathieu.chataigner@insa-rouen.fr">Mathieu CHATAIGNER</a>
 * @version 1.0
 */
public class Main
{
    /**
     * Describe <code>main</code> method here.
     *
     * @param simulateur a <code>String</code> value
     * @exception Throwable if an error occurs
     */
    public static EtatDuJeu jouer(Simulateur simulateur)throws Throwable
    {
        EtatDuJeu edj=simulateur.executerJusquALaFin();
        switch(edj)
            {
            case SUCCES:
                {
                    System.out.println("Bravo, vous avez gagné!!!");
                }
                break;
            case ECHEC:
                {
                    System.out.println("C'est dommage, vous avez perdu");
                }
                break;
            }
        return edj;
    }
    
    
    public static void main(String[] args)throws Throwable
    {
	Scanner scn=new Scanner(System.in);
        EtatDuJeu edj;
	String ordre,path;
	boolean quitter=false;
	Simulateur s=null;
	
	
	do
	    {
		System.out.println("\nBienvenue sur ASI Aventure\ncodé par Mathieu CHATAIGNER\n\nJouer une nouvelle partie :       \"jouer\"\nReprendre la partie en cours :    \"reprendre\"\nCharger une partie enregistrée :  \"charger\"\nEnregistrer la partie courrante : \"enregistrer\"\nquitter :                         \"quitter\"\n");
		System.out.print("Que souhaitez-vous faire ?\t   ");
		ordre=scn.nextLine().trim();
		if(ordre.toUpperCase().equals("JOUER"))
		    {
			System.out.println("Entrez le nom du fichier de création de jeu :");
			try
			    {
				s=new Simulateur(new FileReader(scn.nextLine().trim()));
                                jouer(s);
			    }
			catch(Throwable e)
			    {
				System.out.println("Erreur dans la création du simulateur");
			    }
			
		    }
		else if(ordre.toUpperCase().equals("REPRENDRE"))
		    {
			try
			    {
				if(s!=null)
                                    jouer(s);
			    }
			catch(Throwable e)
			    {
				System.out.println("Impossible de reprendre");
			    }
			
		    }
		else if(ordre.toUpperCase().equals("CHARGER"))
		    {
			System.out.println("Entrez le nom d'un fichier de sauvegarde de jeu :");
			try
			    {
				
				ObjectInputStream ois=new ObjectInputStream(new FileInputStream(scn.nextLine().trim()));
				s=new Simulateur(ois);
				ois.close();
				jouer(s);
			    }
			catch(Throwable e)
			    {
				System.out.println("Erreur au chargement de la sauvegarde");
			    }
		    }
		else if(ordre.toUpperCase().equals("ENREGISTRER"))
		    {
			System.out.println("Entrez le nom du fichier où sauvegarder le jeu :");
			try
			    {
				ObjectOutputStream oos=new ObjectOutputStream(new FileOutputStream(scn.nextLine().trim()));
				s.enregistrer(oos);
				oos.close();
			    }
			catch(Throwable e)
			    {
				System.out.println("Erreur à l'enregistrement");
			    }



		    }
		else if(ordre.toUpperCase().equals("QUITTER"))
		    quitter=!quitter;
	    }
	while(!quitter);
	
    }
}
