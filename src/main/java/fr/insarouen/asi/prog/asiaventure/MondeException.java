package fr.insarouen.asi.prog.asiaventure;

/**
 * Describe class <code>MondeException</code> here.
 *
 * @author <a href="mailto:mathieu.chataigner@insa-rouen.fr">Mathieu CHATAIGNER</a>
 * @version 1.0
 */
public class MondeException extends ASIAventureException
{
    /**
     * Créer une nouvelle instance de <code>MondeException</code>.
     *
     */
    public MondeException()
    {
	super();
	
    }
    
    /**
     * Créer une nouvelle instance de <code>MondeException</code> avec un message.
     *
     * @param message a <code>String</code> value, le message.
     */
    public MondeException(String message)
    {
	super(message);
    }
}
