package fr.insarouen.asi.prog.asiaventure.elements.vivants;

/**
 * Describe class <code>ObjetNonPossedeParLeVivantException</code> here.
 *
 * @author <a href="mailto:mathieu.chataigner@insa-rouen.fr">Mathieu CHATAIGNER</a>
 * @version 1.0
 */
public class ObjetNonPossedeParLeVivantException extends VivantException
{
    /**
     * Créer une nouvelle instance d' <code>ObjetNonPossedeParLeVivantException</code>.
     *
     */
    public ObjetNonPossedeParLeVivantException()
    {
	super();
    }
    
    /**
     * Créer une nouvelle instance d' <code>ObjetNonPossedeParLeVivantException</code> avec un message.
     *
     * @param message a <code>String</code> value, le message.
     */
    public ObjetNonPossedeParLeVivantException(String message)
    {
	super(message);
    }
}
