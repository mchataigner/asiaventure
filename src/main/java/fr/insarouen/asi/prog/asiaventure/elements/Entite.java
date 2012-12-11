package fr.insarouen.asi.prog.asiaventure.elements;

import fr.insarouen.asi.prog.asiaventure.Monde;
import fr.insarouen.asi.prog.asiaventure.NomDEntiteDejaUtiliseDansLeMondeException;

import java.io.Serializable;

/**
 * La classe <code>Entite</code> est la classe mère de toute entité du jeu.
 *
 * @author <a href="mailto:mathieu.chataigner@insa-rouen.fr">Mathieu CHATAIGNER</a>
 * @version 1.0
 */
public abstract class Entite implements Serializable
{
    private String nomEntite;
    private Monde mondeEntite;

    /**
     * Créer une nouvelle instance d' <code>Entite</code>.
     *
     * @param leNom a <code>String</code> value, le nom de l'entité.
     * @param leMonde a <code>Monde</code> value, le monde de l'entité.
     * @exception NomDEntiteDejaUtiliseDansLeMondeException lancée si le nom de l'entité existe déjà dans le monde.
     */
    public Entite(String leNom,Monde leMonde)throws NomDEntiteDejaUtiliseDansLeMondeException
    {
	nomEntite=leNom;
	mondeEntite=leMonde;
	leMonde.ajouter(this);
    }
    /**
     * La méthode <code>getMonde</code> retourne le monde de l'entité.
     *
     * @return a <code>Monde</code> value, le monde de l'entité.
     */
    protected Monde getMonde()
    {
	return mondeEntite;
    }
    
    
    /**
     * La méthode <code>equals</code> teste l'égalité de deux entités en comparant leurs noms.
     *
     * @param e an <code>Entite</code> value, l'entité à tester.
     * @return a <code>boolean</code> value, le résultat.
     */
    public boolean equals(Entite e)
    {
	return e.getNom().equals(this.getNom());
    }

    /**
     * La méthode <code>getNom</code> retourne le nom de l'entité.
     *
     * @return a <code>String</code> value, le nom de l'entité.
     */
    public String getNom()
    {
	return nomEntite;
    }
    /**
     * La méthode <code>toString</code> retourne par défaut le nom de l'entité.
     *
     * @return a <code>String</code> value, le nom de l'entité.
     */
    public String toString()
    {
	return getNom();
    }
}
