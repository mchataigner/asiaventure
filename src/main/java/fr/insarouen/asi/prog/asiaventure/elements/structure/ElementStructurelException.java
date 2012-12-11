package fr.insarouen.asi.prog.asiaventure.elements.structure;

import fr.insarouen.asi.prog.asiaventure.ASIAventureException;

/**
 * Describe class <code>ElementStructurelException</code> here.
 *
 * @author <a href="mailto:mathieu.chataigner@insa-rouen.fr">Mathieu CHATAIGNER</a>
 * @version 1.0
 */
public class ElementStructurelException extends ASIAventureException
{
    /**
     * Créer une nouvelle isntance d'<code>ElementStructurelException</code>.
     *
     */
    public ElementStructurelException()
    {
	super();
	
    }
    
    /**
     * Créer une nouvelle instance d' <code>ElementStructurelException</code> avec un message.
     *
     * @param message a <code>String</code> value, le message.
     */
    public ElementStructurelException(String message)
    {
	super(message);
    }
}
