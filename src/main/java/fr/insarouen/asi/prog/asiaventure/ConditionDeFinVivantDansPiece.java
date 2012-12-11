package fr.insarouen.asi.prog.asiaventure;

import fr.insarouen.asi.prog.asiaventure.elements.vivants.Vivant;
import fr.insarouen.asi.prog.asiaventure.elements.structure.Piece;


/**
 * Describe class <code>ConditionDeFinVivantDansPiece</code> here.
 *
 * @author <a href="mailto:mathieu.chataigner@insa-rouen.fr">Mathieu CHATAIGNER</a>
 * @version 1.0
 */
public class ConditionDeFinVivantDansPiece extends ConditionDeFin 
{
    private Vivant leVivant;
    private Piece piece;
    
    /**
     * Creates a new <code>ConditionDeFinVivantDansPiece</code> instance.
     *
     * @param _etatDuJeu an <code>EtatDuJeu</code> value
     * @param _leVivant a <code>Vivant</code> value
     * @param _piece a <code>Piece</code> value
     */
    public ConditionDeFinVivantDansPiece(EtatDuJeu _etatDuJeu,Vivant _leVivant, Piece _piece)
    {
	super(_etatDuJeu);
	leVivant=_leVivant;
	piece=_piece;
    }

    /**
     * Describe <code>verifierCondition</code> method here.
     *
     * @return an <code>EtatDuJeu</code> value
     */
    public EtatDuJeu verifierCondition()
    {
	

	if(piece.contientVivant(leVivant))
	    return getConditionVerfiee();
	else
	    return EtatDuJeu.ENCOURS;
    }
}