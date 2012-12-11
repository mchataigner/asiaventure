package fr.insarouen.asi.prog.asiaventure.elements.structure;

/**
 * Describe class <code>ObjetNonDeplacableDeLaPieceException</code> here.
 *
 * @author <a href="mailto:mathieu.chataigner@insa-rouen.fr">Mathieu CHATAIGNER</a>
 * @version 1.0
 */
public class ObjetNonDeplacableDeLaPieceException extends PieceException
{
    /**
     * Créer une nouvelle instance d' <code>ObjetNonDeplacableDeLaPieceException</code>.
     *
     */
    public ObjetNonDeplacableDeLaPieceException()
    {
	super();
	
    }
    
    /**
     * Créer une nouvelle instance d' <code>ObjetNonDeplacableDeLaPieceException</code> avec un message.
     *
     * @param message a <code>String</code> value, le message.
     */
    public ObjetNonDeplacableDeLaPieceException(String message)
    {
	super(message);
    }
}
