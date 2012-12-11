package fr.insarouen.asi.prog.asiaventure;

/**
 * Describe class <code>NomDEntiteDejaUtiliseDansLeMondeException</code> here.
 *
 * @author <a href="mailto:mathieu.chataigner@insa-rouen.fr">Mathieu CHATAIGNER</a>
 * @version 1.0
 */
public class NomDEntiteDejaUtiliseDansLeMondeException extends ASIAventureException
{
    /**
     * Créer une nouvelle instance de <code>NomDEntiteDejaUtiliseDansLeMondeException</code>.
     * 
     */
    public NomDEntiteDejaUtiliseDansLeMondeException()
    {
	super();
	
    }
    
    /**
     * Créer une nouvelle instance <code>NomDEntiteDejaUtiliseDansLeMondeException</code> avec un message.
     *
     * @param message a <code>String</code> value, le message.
     */
    public NomDEntiteDejaUtiliseDansLeMondeException(String message)
    {
	super(message);
    }
}
