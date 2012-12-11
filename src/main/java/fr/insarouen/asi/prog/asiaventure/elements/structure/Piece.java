package fr.insarouen.asi.prog.asiaventure.elements.structure;

import fr.insarouen.asi.prog.asiaventure.Monde;
import fr.insarouen.asi.prog.asiaventure.NomDEntiteDejaUtiliseDansLeMondeException;

import java.util.HashMap;
import java.util.Collection;
import fr.insarouen.asi.prog.asiaventure.elements.vivants.*;
import fr.insarouen.asi.prog.asiaventure.elements.objets.*;
import fr.insarouen.asi.prog.asiaventure.elements.*;


/**
 * la classe <code>Piece</code> représente un piece d'un monde.
 * elle peut etre relie a d'autre piece par des portes
 * et peut contenir des objets (deplacable ou non) ainsi que des vivants.
 * @author <a href="mailto:mathieu.chataigner@insa-rouen.fr">Mathieu CHATAIGNER</a>
 * @version 1.0
 */
public class Piece extends ElementStructurel
{
    private HashMap<String,Porte> portes;
    private HashMap<String,Vivant> vivants;
    private HashMap<String,Objet> objets;
    
    /**
     * Créer une nouvelle instance de <code>piece</code>
     * @param leNom a <code>String</code> value, le nom de la piece
     * @param leMonde a<code>Monde</code> value, le monde de la piece
     * @exception NomDEntiteDejaUtiliseDansLeMondeException if an error occurs
     */
    public Piece(String leNom, Monde leMonde)throws NomDEntiteDejaUtiliseDansLeMondeException
    {
	super(leNom,leMonde);
	portes=new HashMap<String,Porte>();
	vivants=new HashMap<String,Vivant>();
	objets=new HashMap<String,Objet>();
    };
    
    /**
     * La méthode <code>addPorte</code> ajoute une porte a la piece.
     *@param laPorte a <code>Porte</code> value, la porte a ajouter
     */
    protected void addPorte(Porte laPorte)
    {
	portes.put(laPorte.getNom(),laPorte);
    };
    /**
     * La méthode <code>aLaPorte</code> teste si la piece contient une porte
     * @param laPorte  a <code>Porte</code> value, la porte a tester
     * @return TRUE si la piece contient la porte FALSE sinon
     */
    public boolean aLaPorte(Porte laPorte)
    {
	return portes.containsKey(laPorte.getNom());
    };
    /**
     * La méthode <code>aLaPorte</code> teste si la piece contient une porte portant le nom passe en parametre
     * @param nomPorte  a <code>String</code> value, le nom de la porte a tester
     * @return TRUE si la piece contient la porte FALSE sinon
     */
    public boolean aLaPorte(java.lang.String nomPorte)
    {
	return portes.containsKey(nomPorte);
    };
    /**
     * teste si la piece contient un objet
     * @param obj l'objet a tester
     * @return TRUE si la piece contient l'objet FALSE sinon
     */
    public    boolean 	contientObjet(Objet obj)
    {
	return objets.containsKey(obj.getNom());
	
    };
    /**
     * teste si la piece contient un objet a partir de son nom
     * @param nomObj le nom de l'objet a tester
     * @return TRUE si la piece contient l'objet FALSE sinon
     */
    public    boolean 	contientObjet(java.lang.String nomObj)
    {
	return objets.containsKey(nomObj);
    };
    
    
    /**teste si la piece contient un vivant a partir de son nom
     *@return TRUE si la piece contient le vivant FALSE sinon
     *@param nomVivant le nom du vivant a tester
     */
    public    boolean 	contientVivant(java.lang.String nomVivant)
    {
	return vivants.containsKey(nomVivant);
    };

    /**teste si la piece contient un vivant
     *@return TRUE si la piece contient le vivant FALSE sinon
     *@param vivant le vivant a tester
     */
    public    boolean 	contientVivant(Vivant vivant)
    {
	String nomVivant=vivant.getNom();
	return vivants.containsKey(nomVivant);
    };
    /**depose un objet dans la piece
     *@param obj l'objet a deposer
     */
    public    void 	deposer(Objet obj)
    {
	objets.put(obj.getNom(),obj);
    };
    
    
    /**fait entrer un vivant dans la piece
     *param vivant le vivant qui entre
     */
    public    void 	entrer(Vivant vivant)
    {
	vivants.put(vivant.getNom(),vivant);
    };
    
    /**retourne une porte a partir de son nom
     *@param nomPorte le nom de la porte a retourner
     *@return la porte correspondant au nom passe en parametre
     */
    public    Porte 	getPorte(java.lang.String nomPorte)
    {
	return portes.get(nomPorte);
    };
    
    /**
     * retire un objet deplacable de la piece
     * @param obj l'objet a retirer
     * @return l'objet retire
     * @exception ObjetAbsentDeLaPieceException if an error occurs
     * @exception ObjetNonDeplacableDeLaPieceException if an error occurs
     */
    public    Objet 	retirer(Objet obj)throws ObjetAbsentDeLaPieceException, ObjetNonDeplacableDeLaPieceException
    {
	Objet objRetire;
	if(!obj.estDeplacable())
	    throw new ObjetNonDeplacableDeLaPieceException("objet "+obj.getNom()+" non deplacable");
	else
	    {
		objRetire=objets.remove(obj.getNom());
		if(objRetire==null)
		    throw new ObjetAbsentDeLaPieceException("objet "+obj.getNom()+" absent de la piece");
		else
		    return objRetire;
	    }
    };
    
    /**
     * retire un objet deplacable de la piece a partir de son nom
     * @param nomObj le nom de l'objet a retirer
     * @return l'objet retire
     * @exception ObjetAbsentDeLaPieceException if an error occurs
     * @exception ObjetNonDeplacableDeLaPieceException if an error occurs
     */
    public    Objet 	retirer(java.lang.String nomObj)throws ObjetAbsentDeLaPieceException, ObjetNonDeplacableDeLaPieceException
    {
	return retirer((Objet)getMonde().getEntite(nomObj));
    };
    
    /**fait sortir un vivant de la piece a partir de son nom
     *@param nomVivant le nom du vivant qui sort
     *@return le vivant qui sort
     */
    public    Vivant 	sortir(java.lang.String nomVivant)throws VivantAbsentDeLaPieceException
    {
	Vivant leVivant=vivants.remove(nomVivant);
	if(leVivant==null)
	    throw new VivantAbsentDeLaPieceException("le vivant "+nomVivant+" n'est pas dans la piece");
	else return leVivant;
    };
      
    /**fait sortir un vivant de la piece
     *@param vivant le vivant qui sort
     *@return le vivant qui sort
     */
    public    Vivant 	sortir(Vivant vivant)throws VivantAbsentDeLaPieceException
    {
	Vivant leVivant;
	leVivant=vivants.remove(vivant.getNom());
	if(leVivant==null)
	    {
		throw new VivantAbsentDeLaPieceException("le vivant "+vivant.getNom()+" n'est pas dans la piece");
	    }
	else return leVivant;
    };
    
    public Collection<Porte> getPortes()
    {
	return portes.values();
    }

    public Collection<Objet> getObjets()
    {
	return objets.values();
    }

    public Collection<Vivant> getVivants()
    {
	return vivants.values();
    }
    

    /**retourne une String avec toutes les entites presentes dans la piece
     *@return une String avec toutes les entites presentes dans la piece
     */
    public    String 	toString()
    {
	StringBuilder chaine=new StringBuilder();
	chaine.append("la pièce ");
	chaine.append(this.getNom());
	chaine.append(" :\n\t");
	for(Porte k:portes.values())
	    {
		chaine.append(k.getNom());
		chaine.append(" (");
		if(k.getEtat().equals(Etat.OUVERT))
		    chaine.append(k.getPieceAutreCote(this).getNom());
		else
		    chaine.append(k.getEtat());
		chaine.append("), ");
	    }
	chaine.append("\n\t");
	for(Vivant i:vivants.values())
	    {
		chaine.append(i.toString());
		chaine.append(", ");
	    };
	chaine.append("\n\t{");
	for(Objet i:objets.values())
	    {
		chaine.append(i.toString());
		chaine.append(", ");
	    }
	chaine.append("}.");
	return chaine.toString();
    };
}
