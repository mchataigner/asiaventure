package fr.insarouen.asi.prog.asiaventure;

import fr.insarouen.asi.prog.asiaventure.elements.vivants.Vivant;


/**
 * Describe class <code>ConditionDeFinVivantMort</code> here.
 *
 * @author <a href="mailto:mathieu.chataigner@insa-rouen.fr">Mathieu CHATAIGNER</a>
 * @version 1.0
 */
public class ConditionDeFinVivantMort extends ConditionDeFin 
{
    private Vivant leVivant;

    /**
     * Creates a new <code>ConditionDeFin</code> instance.
     *
     * @param etatDuJeu an <code>EtatDuJeu</code> value
     * @param leVivant a <code>Vivant</code> value
     */
    public ConditionDeFinVivantMort(EtatDuJeu etatDuJeu,Vivant leVivant)
    {
	super(etatDuJeu);
	this.leVivant =leVivant;
    }

    /**
     * Describe <code>getConditionVerfiee</code> method here.
     *
     * @return an <code>EtatDuJeu</code> value
     */
    public EtatDuJeu getConditionVerfiee()
    {
	return super.getConditionVerfiee();
    }

    /**
     * Describe <code>verifierCondition</code> method here.
     *
     * @return an <code>EtatDuJeu</code> value
     */
    public EtatDuJeu verifierCondition()
    {
	if(leVivant.estMort())
	    return getConditionVerfiee();
	else
	    return EtatDuJeu.ENCOURS;
    }
}