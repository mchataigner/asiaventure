package fr.insarouen.asi.prog.asiaventure;

import fr.insarouen.asi.prog.asiaventure.elements.vivants.Vivant;
import fr.insarouen.asi.prog.asiaventure.elements.structure.Piece;
import fr.insarouen.asi.prog.asiaventure.elements.objets.Objet;

import java.util.ArrayList;

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
     * @param _leVivant a <code>Vivant</code> value
     * @param _piece a <code>Piece</code> value
     */
    public ConditionDeFinVivantDansPieceEtPossedeObjets(EtatDuJeu etatDuJeu,Vivant _leVivant, Piece _piece,Objet... _obj)
    {
	super(_etatDuJeu);
	leVivant=_leVivant;
	piece=_piece;
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
		if(!leVivant.contientObjet((Objet)i.next))
		    possede=false;
	    }
	if(possede&&piece.contientVivant(leVivant))
	    return getConditionVerfiee();
	else
	    return EtatDuJeu.ENCOURS;
    }
}
