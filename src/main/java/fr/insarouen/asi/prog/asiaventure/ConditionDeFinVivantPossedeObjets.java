package fr.insarouen.asi.prog.asiaventure;

import fr.insarouen.asi.prog.asiaventure.elements.vivants.Vivant;
import fr.insarouen.asi.prog.asiaventure.elements.structure.Piece;
import fr.insarouen.asi.prog.asiaventure.elements.objets.Objet;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Iterator;

/**
 * Describe class <code>ConditionDeFinVivantPossedeObjets</code> here.
 *
 * @author <a href="mailto:mathieu.chataigner@insa-rouen.fr">Mathieu CHATAIGNER</a>
 * @version 1.0
 */
public class ConditionDeFinVivantPossedeObjets extends ConditionDeFin 
{
    private Vivant leVivant;
    private ArrayList<Objet> lesObj;
    
    /**
     * Creates a new <code>ConditionDeFinVivantPossedeObjets</code> instance.
     *
     * @param etatDuJeu an <code>EtatDuJeu</code> value
     * @param leVivant a <code>Vivant</code> value
     */
    public ConditionDeFinVivantPossedeObjets(EtatDuJeu etatDuJeu,Vivant leVivant, Objet... _obj)
    {
	super(etatDuJeu);
	this.leVivant =leVivant;
	lesObj.addAll(Arrays.asList(_obj));
    }

    /**
     * Describe <code>verifierCondition</code> method here.
     *
     * @return an <code>EtatDuJeu</code> value
     */
    public EtatDuJeu verifierCondition()
    {
	boolean possede=true;
	Iterator i=lesObj.iterator();
	while(possede&&i.hasNext())
	    {
		if(!leVivant.possede((Objet)i.next()))
		    possede=false;
	    }
	if(possede)
	    return getConditionVerfiee();
	else
	    return EtatDuJeu.ENCOURS;
    }
}
