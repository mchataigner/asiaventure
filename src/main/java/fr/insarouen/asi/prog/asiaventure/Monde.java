package fr.insarouen.asi.prog.asiaventure;



import fr.insarouen.asi.prog.asiaventure.elements.Executable;
import fr.insarouen.asi.prog.asiaventure.elements.structure.Piece;

import java.util.*;
import fr.insarouen.asi.prog.asiaventure.elements.Entite;
import java.util.HashMap;

import java.io.Serializable;

/**
 * Description de la classe <code>Monde</code>.
 *
 * @author <a href="mailto:mathieu.chataigner@insa-rouen.fr">Mathieu CHATAIGNER</a>
 * @version 1.0
 */
public class Monde implements Serializable
{
    private String nomMonde;
    private HashMap<String,Entite> mapEntite;
    private HashMap<String,Executable> lesExecutables;

    /**
     * Créer une nouvelle instance de <code>Monde</code>.
     *
     * @param nom a <code>String</code> value, le nom de l'entité.
     */
    public Monde(String nom)
    {
	nomMonde=nom;
	mapEntite=new HashMap<String,Entite>();
	lesExecutables=new HashMap<String,Executable>();
    }
    
    /**
     * La méthode <code>ajouter</code> permet d'ajouter une entité dans le monde.
     *
     * @param entite an <code>Entite</code> value, l'entité à ajouter.
     * @exception NomDEntiteDejaUtiliseDansLeMondeException lancée si le nom est déjà présent dans le monde.
     */
    public void ajouter(Entite entite)throws NomDEntiteDejaUtiliseDansLeMondeException
    {
	if(mapEntite.containsValue(entite))
	    throw new NomDEntiteDejaUtiliseDansLeMondeException("Nom d'entite déja utilise dans le monde exception"+entite.getNom());
	else
	    {
		if(entite instanceof Executable)
		    lesExecutables.put(entite.getNom(),(Executable)entite);
		else
		    mapEntite.put(entite.getNom(),entite);
	    }
    }
    
    /**
     * La méthode <code>getEntite</code> permet d'obtenir une entité présente dans le monde à partir d'un nom d'entité.
     *
     * @param nomEntite a <code>String</code> value, le nom de l'entité à trouver.
     * @return an <code>Entite</code> value, l'entité trouvée
     */
    public Entite getEntite(String nomEntite)
    {
	Entite resultat=mapEntite.get(nomEntite);
	if(resultat!=null)
	    return resultat;
	else
	    return (Entite)lesExecutables.get(nomEntite);
    }

    /**
     * La méthode <code>getExecutables</code> permet d'obtenir la collection des executables du monde.
     *
     * @return an <code>Collection<Executable></code> value, la collection d'entités executables.
     */
    public Collection<Executable> getExecutables()
    {
	return lesExecutables.values();
    }
    
    /**
     * Describe <code>toString</code> method here.
     *
     * @return a <code>String</code> value
     */
    public String toString()
    {
	StringBuilder str=new StringBuilder();
	for(Entite i:mapEntite.values())
	    {
		if(i instanceof Piece)
		    {
			str.append(i);
			str.append("\n");
		    }
	    }
	return str.toString();
    }
}
