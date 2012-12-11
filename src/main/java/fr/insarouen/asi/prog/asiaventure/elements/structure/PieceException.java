package fr.insarouen.asi.prog.asiaventure.elements.structure;

/**
 * Describe class <code>PieceException</code> here.
 *
 * @author <a href="mailto:mathieu.chataigner@insa-rouen.fr">Mathieu CHATAIGNER</a>
 * @version 1.0
 */
public class PieceException extends ElementStructurelException
{
    /**
     * Créer une  nouvelle instance de <code>PieceException</code>.
     *
     */
    public PieceException()
    {
	super();
    }
    
    /**
     * Créer une nouvelle instance de <code>PieceException</code> avec un message.
     *
     * @param message a <code>String</code> value, le message.
     */
    public PieceException(String message)
    {
	super(message);
    }
}
