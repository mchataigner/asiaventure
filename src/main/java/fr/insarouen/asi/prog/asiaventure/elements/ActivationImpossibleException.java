package fr.insarouen.asi.prog.asiaventure.elements;

/**
 * Describe class <code>ActivationImpossibleException</code> here.
 *
 * @author <a href="mailto:mathieu.chataigner@insa-rouen.fr">Mathieu CHATAIGNER</a>
 * @version 1.0
 */
public class ActivationImpossibleException extends ActivationException
{
    /**
     * Créer une nouvelle instance d' <code>ActivationImpossibleException</code>.
     *
     */
    public ActivationImpossibleException()
    {
	super();
	
    }
    
    /**
     * Créer une nouvelle instance d'<code>ActivationImpossibleException</code> avec un message.
     *
     * @param message a <code>String</code> value, le message.
     */
    public ActivationImpossibleException(String message)
    {
	super(message);
    }
}
