package fr.insarouen.asi.prog.asiaventure.elements.objets;

import fr.insarouen.asi.prog.asiaventure.elements.Entite;
import fr.insarouen.asi.prog.asiaventure.Monde;
import fr.insarouen.asi.prog.asiaventure.NomDEntiteDejaUtiliseDansLeMondeException;

/**
 * La classe <code>Objet</code> est une classe abstraite, mère de toute les entité de type objet dans le jeu.
 * @author <a href="mailto:mathieu.chataigner@insa-rouen.fr">Mathieu CHATAIGNER</a>
 * @version 1.0
 */
public abstract class Objet extends Entite
{
    /**
     * Créer une nouvelle instance d' <code>Objet</code>.
     *
     * @param leNom a <code>String</code> value, le nom de l'objet.
     * @param leMonde a <code>Monde</code> value, le monde de l'objet.
     * @exception NomDEntiteDejaUtiliseDansLeMondeException lancée si le nom existe déjà dans le monde.
     */
    public Objet(String leNom,Monde leMonde)throws NomDEntiteDejaUtiliseDansLeMondeException
    {
	super(leNom,leMonde);
    }    
    /**
     * La méthode <code>estDeplacable</code> décrit si l'objet est déplaçable..
     * @return a <code>boolean</code> value
     */
    public abstract boolean estDeplacable();
}
