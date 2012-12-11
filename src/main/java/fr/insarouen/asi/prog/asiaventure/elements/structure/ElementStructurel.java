package fr.insarouen.asi.prog.asiaventure.elements.structure;

import fr.insarouen.asi.prog.asiaventure.Monde;
import fr.insarouen.asi.prog.asiaventure.elements.Entite;
import fr.insarouen.asi.prog.asiaventure.NomDEntiteDejaUtiliseDansLeMondeException;


/**La classe <code>ElementStructurel</code> est une classe abstraite représentant tout les élements structurels : pièces et portes
 * @author <a href="mailto:mathieu.chataigner@insa-rouen.fr">Mathieu CHATAIGNER</a>
 */
public abstract class ElementStructurel extends Entite
{
    /**Créer une nouvelle instance d'<code>ElementStructurel</code>
     *@param leNom a <code>String</code> value, le nom de l'element structurel
     *@param leMonde a <code>Monde</code> value, le monde de l'element structurel
     */
    public ElementStructurel(String leNom, Monde leMonde)throws NomDEntiteDejaUtiliseDansLeMondeException
    {
	super(leNom,leMonde);
    }
}
