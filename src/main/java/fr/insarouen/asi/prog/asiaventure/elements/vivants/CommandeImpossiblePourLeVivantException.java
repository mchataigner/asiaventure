package fr.insarouen.asi.prog.asiaventure.elements.vivants;

/**
 * Describe class <code>CommandeImpossiblePourLeVivantException</code> here.
 *
 * @author <a href="mailto:mathieu.chataigner@insa-rouen.fr">Mathieu CHATAIGNER</a>
 * @version 1.0
 */
public class CommandeImpossiblePourLeVivantException extends VivantException
{
    /**
     * Créer une nouvelle instance de <code>CommandeImpossiblePourLeVivantException</code>.
     *
     */
    public CommandeImpossiblePourLeVivantException()
    {
	super();
    }
    
    /**
     * Créer une nouvelle instance de <code>CommandeImpossiblePourLeVivantException</code> avec un message.
     *
     * @param message a <code>String</code> value, le message.
     */
    public CommandeImpossiblePourLeVivantException(String message)
    {
	super(message);
    }
}
