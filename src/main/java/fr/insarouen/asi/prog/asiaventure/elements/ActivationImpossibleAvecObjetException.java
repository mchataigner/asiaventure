package fr.insarouen.asi.prog.asiaventure.elements;

/**
 * Describe class <code>ActivationImpossibleAvecObjetException</code> here.
 *
 * @author <a href="mailto:mathieu.chataigner@insa-rouen.fr">Mathieu CHATAIGNER</a>
 * @version 1.0
 */
public class ActivationImpossibleAvecObjetException extends ActivationImpossibleException
{
    /**
     * Créer une nouvelle instance d'<code>ActivationImpossibleAvecObjetException</code>.
     *
     */
    public ActivationImpossibleAvecObjetException()
    {
	super();
	
    }
    
    /**
     * Créer une nouvelle instance d' <code>ActivationImpossibleAvecObjetException</code> avec un message.
     *
     * @param message a <code>String</code> value, le message.
     */
    public ActivationImpossibleAvecObjetException(String message)
    {
	super(message);
    }
}
