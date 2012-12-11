package fr.insarouen.asi.prog.asiaventure;

import fr.insarouen.asi.prog.asiaventure.elements.vivants.Vivant;
import fr.insarouen.asi.prog.asiaventure.elements.structure.Piece;
import fr.insarouen.asi.prog.asiaventure.elements.objets.Objet;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Iterator;

/**
 * Describe class <code>ConditionDeFinVivantDansPieceEtPossedeObjets</code> here.
 *
 * @author <a href="mailto:mathieu.chataigner@insa-rouen.fr">Mathieu CHATAIGNER</a>
 * @version 1.0
 */
public class ConditionDeFinVivantDansPieceEtPossedeObjets extends ConditionDeFin 
{
    private Vivant leVivant;
    private Piece piece;
    private ArrayList<Objet> lesObj;
    
    /**
     * Creates a new <code>ConditionDeFinVivantDansPieceEtPossedeObjets</code> instance.
     *
     * @param etatDuJeu an <code>EtatDuJeu</code> value
     * @param leVivant a <code>Vivant</code> value
     * @param piece a <code>Piece</code> value
     */
    public ConditionDeFinVivantDansPieceEtPossedeObjets(EtatDuJeu etatDuJeu,Vivant leVivant, Piece piece,Objet... obj)
    {
	super(etatDuJeu);
	this.leVivant =leVivant;
	this.piece =piece;
	lesObj.addAll(Arrays.asList(obj));
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
		if(!leVivant.possede((Objet) i.next()))
		    possede=false;
	    }
	if(possede&&piece.contientVivant(leVivant))
	    return getConditionVerfiee();
	else
	    return EtatDuJeu.ENCOURS;
    }
}
