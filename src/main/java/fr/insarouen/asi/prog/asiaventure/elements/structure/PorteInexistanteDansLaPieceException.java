package fr.insarouen.asi.prog.asiaventure.elements.structure;

/**
 * Describe class <code>PorteInexistanteDansLaPieceException</code> here.
 *
 * @author <a href="mailto:mathieu.chataigner@insa-rouen.fr">Mathieu CHATAIGNER</a>
 * @version 1.0
 */
public class PorteInexistanteDansLaPieceException extends PieceException
{
    /**
     * Créer une nouvelle instance de <code>PorteInexistanteDansLaPieceException</code>.
     *
     */
    public PorteInexistanteDansLaPieceException()
    {
	super();
    }
    
    /**
     * Créer une nouvelle instance de <code>PorteInexistanteDansLaPieceException</code> avec un message.
     *
     * @param message a <code>String</code> value, le message.
     */
    public PorteInexistanteDansLaPieceException(String message)
    {
	super(message);
    }
}
