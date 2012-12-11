package fr.insarouen.asi.prog.asiaventure.elements.objets;

import fr.insarouen.asi.prog.asiaventure.Monde;
import fr.insarouen.asi.prog.asiaventure.elements.structure.Piece;
import fr.insarouen.asi.prog.asiaventure.NomDEntiteDejaUtiliseDansLeMondeException;

import java.util.HashMap;

/**
 * La classe <code>Coffre</code> représente l'objet coffre qui peut contenir d'autres objets.
 *
 * @author <a href="mailto:mathieu.chataigner@insa-rouen.fr">Mathieu CHATAIGNER</a>
 * @version 1.0
 */
public class Coffre extends Objet
{
    private HashMap<String,Objet> objets;
    /**
     * Créer une nouvelle instance de <code>Coffre</code>.
     *
     * @param leNom a <code>String</code> value, le nom du coffre
     * @param leMonde a <code>Monde</code> value, le monde du coffre.
     * @param laPiece a <code>Piece</code> value, la pièce ou se trouve le coffre.
     * @exception NomDEntiteDejaUtiliseDansLeMondeException lancée si le nom est déjà utilisé dans le monde.
     */
    public Coffre(String leNom,Monde leMonde,Piece laPiece)throws NomDEntiteDejaUtiliseDansLeMondeException
    {
	super(leNom,leMonde);
	laPiece.deposer(this);
	objets=new HashMap<String,Objet>();
    };
    
    /**
     * La méthode <code>estDeplacable</code> décrit si le coffre est déplacable.
     * retourne <code>false</code> car un coffre n'est pas déplacable.
     * @return a <code>boolean</code> value
     */
    public boolean estDeplacable()
    {
	return false;
    }
    
}
