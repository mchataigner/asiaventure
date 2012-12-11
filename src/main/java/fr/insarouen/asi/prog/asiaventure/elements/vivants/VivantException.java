package fr.insarouen.asi.prog.asiaventure.elements.vivants;

import fr.insarouen.asi.prog.asiaventure.ASIAventureException;

/**
 * Describe class <code>VivantException</code> here.
 *
 * @author <a href="mailto:mathieu.chataigner@insa-rouen.fr">Mathieu CHATAIGNER</a>
 * @version 1.0
 */
public class VivantException extends ASIAventureException
{
    /**
     * Créer une nouvelle instance de <code>VivantException</code>.
     *
     */
    public VivantException()
    {
	super();
    }
    
    /**
     * Créer une nouvelle instance de <code>VivantException</code> avec un message.
     *
     * @param message a <code>String</code> value, le message.
     */
    public VivantException(String message)
    {
	super(message);
    }
}
