package fr.insarouen.asi.prog.asiaventure.elements.vivants;

import fr.insarouen.asi.prog.asiaventure.Monde;
import fr.insarouen.asi.prog.asiaventure.elements.Entite;
import fr.insarouen.asi.prog.asiaventure.NomDEntiteDejaUtiliseDansLeMondeException;
import fr.insarouen.asi.prog.asiaventure.elements.Activable;
import fr.insarouen.asi.prog.asiaventure.elements.Executable;
import fr.insarouen.asi.prog.asiaventure.elements.Etat;
import fr.insarouen.asi.prog.asiaventure.elements.structure.Piece;
import fr.insarouen.asi.prog.asiaventure.elements.structure.Porte;
import fr.insarouen.asi.prog.asiaventure.elements.structure.PorteFermeException;
import fr.insarouen.asi.prog.asiaventure.elements.structure.ObjetNonDeplacableDeLaPieceException;
import fr.insarouen.asi.prog.asiaventure.elements.structure.ObjetAbsentDeLaPieceException;
import fr.insarouen.asi.prog.asiaventure.elements.structure.PorteInexistanteDansLaPieceException;
import fr.insarouen.asi.prog.asiaventure.elements.objets.Objet;
import fr.insarouen.asi.prog.asiaventure.elements.objets.Nourriture;
import fr.insarouen.asi.prog.asiaventure.elements.ActivationException;
import fr.insarouen.asi.prog.asiaventure.elements.ActivationImpossibleAvecObjetException;
import java.util.Collection;
import java.util.ArrayList;


/**
 * La classe <code>Monstre</code> est la classe représentant un monstre.
 *
 * @author <a href="mailto:moot@mootEee">Mathieu CHATAIGNER</a>
 * @version 1.0
 */
public class Monstre extends Vivant
{
    
    /**
     * Créer une nouvelle instance de <code>Monstre</code>.
     *
     * @param leNom a <code>String</code> value, le nom du monstre.
     * @param leMonde a <code>Monde</code> value, le monde du monstre.
     * @param pointsVie an <code>int</code> value, le nombre de points de vie du monstre.
     * @param pointsForce an <code>int</code> value, le nombre de points de force du monstre.
     * @param piece a <code>Piece</code> value, la pièce ou se situe le monstre.
     * @exception NomDEntiteDejaUtiliseDansLeMondeException lancée si le nom du monstre existe déjà dans le monde.
     */
    public Monstre(String leNom, Monde leMonde,int pointsVie,int pointsForce,Piece piece,Objet... objets)throws NomDEntiteDejaUtiliseDansLeMondeException
    {
	super(leNom,leMonde,pointsVie,pointsForce,piece,objets);
    }
    
    /**
     * La méthode <code>executer</code> effectue les actions effectuée lorsqu'on l'exécute.
     *
     * @exception Throwable lancée si une erreur apparait.
     */
    public void executer()throws Throwable
    {
	Collection<Porte> lesPortes=getPiece().getPortes();
	ArrayList<Porte> lesPortesPossibles=new ArrayList<Porte>();
	for(Porte i:lesPortes)
	    if(i.getEtat()==Etat.OUVERT || i.getEtat()==Etat.FERME)
		lesPortesPossibles.add(i);
	if(lesPortesPossibles.size()>0)
	    {
		int index=(int)(Math.random()*(lesPortesPossibles.size()));
		Porte laPorteChoisie=lesPortesPossibles.get(index);
		if(laPorteChoisie.getEtat()==Etat.FERME)
		    try
			{
			    laPorteChoisie.activer();
			}
		    catch(ActivationException e)
			{
			    throw new Throwable("Erreur d'activation de la porte aléatoire pour le monstre");
			}
		franchir(laPorteChoisie);
	    }
    }
}
