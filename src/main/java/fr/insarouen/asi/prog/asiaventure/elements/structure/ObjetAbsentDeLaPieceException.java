package fr.insarouen.asi.prog.asiaventure.elements.structure;

/**
 * Describe class <code>ObjetAbsentDeLaPieceException</code> here.
 *
 * @author <a href="mailto:mathieu.chataigner@insa-rouen.fr">Mathieu CHATAIGNER</a>
 * @version 1.0
 */
public class ObjetAbsentDeLaPieceException extends PieceException
{
    /**
     * Créer une nouvelle instance d' <code>ObjetAbsentDeLaPieceException</code>.
     *
     */
    public ObjetAbsentDeLaPieceException()
    {
	super();
	
    }
    
    /**
     * Créer une nouvelle instance d'<code>ObjetAbsentDeLaPieceException</code> avec un message.
     *
     * @param message a <code>String</code> value, le message.
     */
    public ObjetAbsentDeLaPieceException(String message)
    {
	super(message);
    }
}
