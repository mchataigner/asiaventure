package fr.insarouen.asi.prog.asiaventure.elements;

import fr.insarouen.asi.prog.asiaventure.ASIAventureException;

/**
 * Describe class <code>ActivationException</code> here.
 *
 * @author <a href="mailto:mathieu.chataigner@insa-rouen.fr">Mathieu CHATAIGNER</a>
 * @version 1.0
 */
public class ActivationException extends ASIAventureException
{
    /**
     * Créer une nouvelle instance d' <code>ActivationException</code>.
     *
     */
    public ActivationException()
    {
	super();
	
    }
    
    /**
     * Créer une nouvelle instance d' <code>ActivationException</code> avec un message.
     *
     * @param message a <code>String</code> value, le message.
     */
    public ActivationException(String message)
    {
	super(message);
    }
}
