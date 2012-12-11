package fr.insarouen.asi.prog.asiaventure.elements.objets.serrurerie;

import fr.insarouen.asi.prog.asiaventure.Monde;
import fr.insarouen.asi.prog.asiaventure.elements.objets.Objet;
import fr.insarouen.asi.prog.asiaventure.NomDEntiteDejaUtiliseDansLeMondeException;

/**
 * La classe <code>Clef</code> est une classe representant une clef
 * @author <a href="mailto:mathieu.chataigner@insa-rouen.fr">Mathieu CHATAIGNER</a>
 * @version 1.0
 */
public class Clef extends Objet
{
    /**
     * Créer une nouvelle instance de <code>Clef</code>. 
     * Une clef ne peut être créée qu'avec une serrure, c'est pour cela que son constructeur est protected.
     * @param leNom a <code>String</code> value, le nom de la clef.
     * @param leMonde a <code>Monde</code> value, le monde de la clef.
     * @exception NomDEntiteDejaUtiliseDansLeMondeException lancée si le nom de la clef existe déjà dans le monde.
     */
    protected Clef(String leNom, Monde leMonde)throws NomDEntiteDejaUtiliseDansLeMondeException
    {
	super(leNom,leMonde);
    }
    
    
    /**
     * La méthode <code>estDeplacable</code> décrit si la clef est déplaçable.
     * retourne <code>true</code> car une clef est déplaçable.
     * @return a <code>boolean</code> value
     */
    public boolean estDeplacable()
    {
	return true;
    }
    
    /**
     * La méthode <code>toString</code> renvoie une chaine de caractère décrivant la clef.
     *
     * @return a <code>String</code> value
     */
    public String toString()
    {
	return getNom();
    }
    
}