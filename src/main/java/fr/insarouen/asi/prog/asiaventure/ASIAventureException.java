package fr.insarouen.asi.prog.asiaventure;

/**
 * Describe class <code>ASIAventureException</code> here.
 *
 * @author <a href="mailto:mathieu.chataigner@insa-rouen.fr">Mathieu CHATAIGNER</a>
 * @version 1.0
 */
public class ASIAventureException extends Exception
{
    private String msg;
    /**
     * Creates a new <code>ASIAventureException</code> instance.
     *
     */
    public ASIAventureException()
    {
	super();
	msg=null;
    }
    
    /**
     * Créer une nouvelle instance de <code>ASIAventureException</code> avec un message.
     *
     * @param message a <code>String</code> value, le message.
     */
    public ASIAventureException(String message)
    {
	super(message);
	msg=message;
    }
    
    /**
     * Describe <code>getMessageASI</code> method here.
     *
     * @return a <code>String</code> value
     */
    public String getMessageASI()
    {
	return msg;
    }
}
