package fr.insarouen.asi.prog.asiaventure;

import java.io.Serializable;


/**
 * Describe class <code>ConditionDeFin</code> here.
 *
 * @author <a href="mailto:mathieu.chataigner@insa-rouen.fr">Mathieu CHATAIGNER</a>
 * @version 1.0
 */
public abstract class ConditionDeFin implements Serializable
{
    private EtatDuJeu etatDuJeu;


    /**
     * Creates a new <code>ConditionDeFin</code> instance.
     *
     * @param etatDuJeu an <code>EtatDuJeu</code> value
     */
    public ConditionDeFin(EtatDuJeu etatDuJeu)
    {
	this.etatDuJeu=etatDuJeu;
    }

    /**
     * Describe <code>getConditionVerfiee</code> method here.
     *
     * @return an <code>EtatDuJeu</code> value
     */
    public EtatDuJeu getConditionVerfiee()
    {
	return etatDuJeu;
    }

    /**
     * Describe <code>verifierCondition</code> method here.
     *
     * @return an <code>EtatDuJeu</code> value
     */
    public abstract EtatDuJeu verifierCondition();
}