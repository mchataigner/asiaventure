package fr.insarouen.asi.prog.asiaventure.elements;

/**
 * Describe interface <code>Executable</code> here.
 *
 * @author <a href="mailto:mathieu.chataigner@insa-rouen.fr">Mathieu CHATAIGNER</a>
 * @version 1.0
 */
public interface Executable
{
    /**
     * La méthode <code>executer</code> est une méthode abstraite à redéfinir.
     * Elle permet de décrire le comportement d'une entité executable.
     * 
     * @exception Throwable lancée en cas d'erreur.
     */
    public abstract void executer()throws Throwable;
}
