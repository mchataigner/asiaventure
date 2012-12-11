package fr.insarouen.asi.prog.asiaventure.elements;

import fr.insarouen.asi.prog.asiaventure.elements.objets.Objet;
/**
 * Activabe est une interface permettant de renseigner si une entite est activable ou non avec ou sans objet, ainsi que de l'activer.
 * @author <a href="mailto:mathieu.chataigner@insa-rouen.fr">Mathieu CHATAIGNER</a>
 * @version 1.0
 */
public interface Activable
{
    /**
     * La méthode <code>actvableAvec</code> renseigne si l'entite est activable avec un objet
     * @param obj an <code>Objet</code> value, l'objet avec lequel on teste.
     * @return a <code>boolean</code> value
     */
    boolean 	activableAvec(Objet obj);
    
    /**
     * La méthode <code>activer</code> active une entité.
     * @exception ActivationException lancée si l'activation échoue.
     */
    void 	activer()throws ActivationException;
    
    /**
     * La méthode <code>activerAvec</code> active une entité avec un objet.
     * @param obj an <code>Objet</code> value, l'objet avec lequel on active l'entité.
     * @exception ActivationException lancée si l'activation échoue.
     */
    void 	activerAvec(Objet obj)throws ActivationException;
	
    /**
     * La méthode <code>getEtat</code> retourne l'etat de l'entite.
     * @return an <code>Etat</code> value
     */
    Etat 	getEtat() ;
}
