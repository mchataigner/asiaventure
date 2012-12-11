package fr.insarouen.asi.prog.asiaventure.elements.objets;

import fr.insarouen.asi.prog.asiaventure.Monde;
import fr.insarouen.asi.prog.asiaventure.NomDEntiteDejaUtiliseDansLeMondeException;


/**
 * La classe <code>Nourriture</code> représente l'objet nourriture qui permet à un vivant de regagner des points de vie.
 *
 * @author <a href="mailto:mathieu.chataigner@insa-rouen.fr">Mathieu CHATAIGNER</a>
 * @version 1.0
 */
public class Nourriture extends Objet
{
    /**
     * Créee une nouvelle instance de <code>Nourriture</code>.
     *
     * @param leNom a <code>String</code> value, le nom de la nourriture.
     * @param leMonde a <code>Monde</code> value, le monde de la nourriture.
     * @exception NomDEntiteDejaUtiliseDansLeMondeException lancée si le nom existe déjà dans le monde.
     */
    public Nourriture(String leNom,Monde leMonde)throws NomDEntiteDejaUtiliseDansLeMondeException
    {
	super(leNom,leMonde);
    }

    /**
     * La méthode <code>estDeplacable</code> décrit si la nourriture est déplaçable.
     * retourne <code>true</code> car la nourriture est déplacable.
     * @return a <code>boolean</code> value
     */
    public boolean estDeplacable()
    {
	return true;
    }
}
