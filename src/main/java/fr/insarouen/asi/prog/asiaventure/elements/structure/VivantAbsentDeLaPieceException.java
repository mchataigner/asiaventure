package fr.insarouen.asi.prog.asiaventure.elements.structure;

/**
 * Describe class <code>VivantAbsentDeLaPieceException</code> here.
 *
 * @author <a href="mailto:mathieu.chataigner@insa-rouen.fr">Mathieu CHATAIGNER</a>
 * @version 1.0
 */
public class VivantAbsentDeLaPieceException extends PieceException
{
    /**
     * Créer une nouvelle instance de <code>VivantAbsentDeLaPieceException</code>.
     *
     */
    public VivantAbsentDeLaPieceException()
    {
	super();
    }
    
    /**
     * Créer une nouvelle instance de <code>VivantAbsentDeLaPieceException</code> avec un message.
     *
     * @param message a <code>String</code> value, le message.
     */
    public VivantAbsentDeLaPieceException(String message)
    {
	super(message);
    }
}
