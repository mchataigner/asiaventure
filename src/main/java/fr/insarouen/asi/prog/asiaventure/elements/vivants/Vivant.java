package fr.insarouen.asi.prog.asiaventure.elements.vivants;

import fr.insarouen.asi.prog.asiaventure.Monde;
import fr.insarouen.asi.prog.asiaventure.elements.Entite;
import fr.insarouen.asi.prog.asiaventure.NomDEntiteDejaUtiliseDansLeMondeException;
import fr.insarouen.asi.prog.asiaventure.elements.Activable;
import fr.insarouen.asi.prog.asiaventure.elements.Executable;
import fr.insarouen.asi.prog.asiaventure.elements.Etat;
import fr.insarouen.asi.prog.asiaventure.elements.structure.Piece;
import fr.insarouen.asi.prog.asiaventure.elements.structure.Porte;
import fr.insarouen.asi.prog.asiaventure.elements.structure.PorteFermeException;
import fr.insarouen.asi.prog.asiaventure.elements.structure.ObjetNonDeplacableDeLaPieceException;
import fr.insarouen.asi.prog.asiaventure.elements.structure.ObjetAbsentDeLaPieceException;
import fr.insarouen.asi.prog.asiaventure.elements.structure.PorteInexistanteDansLaPieceException;
import fr.insarouen.asi.prog.asiaventure.elements.structure.VivantAbsentDeLaPieceException;
import fr.insarouen.asi.prog.asiaventure.elements.objets.Objet;
import fr.insarouen.asi.prog.asiaventure.elements.objets.Nourriture;
import fr.insarouen.asi.prog.asiaventure.elements.ActivationException;
import fr.insarouen.asi.prog.asiaventure.elements.ActivationImpossibleAvecObjetException;
import java.util.HashMap;


/**
 * La class <code>Vivant</code> est une classe abstraite représentant tout vivant du jeu.
 *
 * @author <a href="mailto:mathieu.chataigner@insa-rouen.fr">Mathieu CHATAIGNER</a>
 * @version 1.0
 */
public abstract class Vivant extends Entite implements Executable
{
    private int pointsVie;
    private int pointsForce;
    private Piece piece;
    private HashMap<String,Objet> objets;
    
    
    /**
     * Créer une nouvelle instance de <code>Vivant</code>.
     *
     * @param leNom a <code>String</code> value, le nom du vivant.
     * @param leMonde a <code>Monde</code> value, le monde du vivant.
     * @param pointsVie an <code>int</code> value, les points de vie du vivant.
     * @param pointsForce an <code>int</code> value, les points de force du vivant.
     * @param piece a <code>Piece</code> value, la pièce où se situe le vivant dans le monde.
     * @exception NomDEntiteDejaUtiliseDansLeMondeException lancée si le nom du vivant existe déjà dans le monde.
     */
    public Vivant(String leNom, Monde leMonde,int pointsVie,int pointsForce,Piece piece,Objet... objets)throws NomDEntiteDejaUtiliseDansLeMondeException
    {
	super(leNom,leMonde);
	this.pointsVie=pointsVie;
	this.pointsForce=pointsForce;
	this.piece=piece;
	this.objets=new HashMap<String,Objet>();
	for (Objet i:objets)
	    this.objets.put(i.getNom(),i);
	piece.entrer(this);
	
    }

    /**
     * La méthode <code>prendre</code> permet à un vivant de ramasser un objet de la pièce et de le mettre dans son inventaire.
     *
     * @param obj an <code>Objet</code> value, l'objet à ramasser.
     * @exception ObjetAbsentDeLaPieceException lancée si l'objet est absent de la pièce ou le vivant se trouve.
     * @exception ObjetNonDeplacableDeLaPieceException lancée si l'objet n'est pas déplaçable.
     */
    public void prendre(Objet obj)throws ObjetAbsentDeLaPieceException, ObjetNonDeplacableDeLaPieceException
    {
	if(!piece.contientObjet(obj.getNom()))
	    throw new ObjetAbsentDeLaPieceException("Objet absent de la piece");
	else if(!obj.estDeplacable())
	    throw new ObjetNonDeplacableDeLaPieceException("l'objet "+obj.getNom()+" n'est pas déplacable");
	else
	    objets.put(obj.getNom(),piece.retirer(obj));
    }      

    /**
     * La méthode <code>prendre</code> permet à un vivant de ramasser un objet de la pièce et de le mettre dans son inventaire.
     *
     * @param nomObj a <code>java.lang.String</code> value, le nom de l'objet à ramasser.
     * @exception ObjetAbsentDeLaPieceException lancée si l'objet est absent de la pièce ou le vivant se trouve.
     * @exception ObjetNonDeplacableDeLaPieceException lancée si l'objet n'est pas déplaçable.
     */
    public void prendre(java.lang.String nomObj)throws ObjetAbsentDeLaPieceException, ObjetNonDeplacableDeLaPieceException
    {
	prendre((Objet)getMonde().getEntite(nomObj));
    }

    /**
     * La méthode <code>deposer</code> permet de déposer un objet du vivant dans la pièce.
     *
     * @param obj an <code>Objet</code> value, l'objet à déposer
     * @exception ObjetNonPossedeParLeVivantException lancée si l'objet n'est pas possédé par le vivant.
     */
    public void deposer(Objet obj)throws ObjetNonPossedeParLeVivantException
    {
	deposer(obj.getNom());
    }   

    /**
     * La méthode <code>deposer</code> permet de déposer un objet du vivant dans la pièce.
     *
     * @param nomObj a <code>String</code> value, le nom de l'objet à déposer.
     * @exception ObjetNonPossedeParLeVivantException lancée si l'objet n'est pas possédé par le vivant.
     */
    public void deposer(String nomObj)throws ObjetNonPossedeParLeVivantException
    {
	Objet obj;
	obj=objets.remove(nomObj);
	if(obj==null)
	    throw new ObjetNonPossedeParLeVivantException("l'objet "+nomObj+" n'est pas possédé par le vivant");
	else
	    piece.deposer(obj);
    }

    /**
     * La méthode <code>franchir</code> permet à un vivant de franchir une porte ouverte et ainsi de se retrouver dans la pièce se trouvant derrière celle-ci.
     *
     * @param porte a <code>Porte</code> value, la porte à franchir.
     * @exception PorteFermeException lancée si la porte est fermée.
     * @exception PorteInexistanteDansLaPieceException lancée si la porte n'existe pas dans la pièce.
     */
    public void franchir(Porte porte)throws PorteFermeException, PorteInexistanteDansLaPieceException
    {
	if(!piece.aLaPorte(porte))
	    throw new PorteInexistanteDansLaPieceException("la piece "+piece.getNom()+" ne contient pas la porte "+porte.getNom());
	if(porte.getEtat()!=Etat.OUVERT)
	    throw new PorteFermeException("la porte "+porte.getNom()+" est fermée");
	else
	    {
		Piece newPiece=porte.getPieceAutreCote(piece);
		try
		    {
			newPiece.entrer(piece.sortir(this));
		    }
		catch(VivantAbsentDeLaPieceException e)
		    {
			throw new RuntimeException("ceci ne derait pas arriver !!!");
		    }
		piece=newPiece;
	    }
    }   
   
    /**
     * La méthode <code>franchir</code> permet à un vivant de franchir une porte ouverte et ainsi de se retrouver dans la pièce se trouvant derrière celle-ci.
     *
     * @param nomPorte a <code>java.lang.String</code> value, le nom de la porte à franchir.
     * @exception PorteFermeException lancée si la porte est fermée.
     * @exception PorteInexistanteDansLaPieceException lancée si la porte n'existe pas dans la pièce.
     */
    public void franchir(java.lang.String nomPorte)throws PorteFermeException, PorteInexistanteDansLaPieceException
    {
	Porte laPorte=(Porte)getMonde().getEntite(nomPorte);
	franchir(laPorte);
    }

    /**
     * La méthode <code>getPiece</code> renvoie la pièce dans laquelle se trouve le vivant.
     *
     * @return a <code>Piece</code> value
     */
    public Piece getPiece()
    {
	return this.piece;
    } 

    /**
     * La méthode <code>activerActivable</code> permet au vivant d'activer un Activable.
     *
     * @param activable an <code>Activable</code> value, l'Activable à activer.
     * @exception ActivationException lancée si l'activation lance une exception.
     */
    public void activerActivable(Activable activable)throws ActivationException
    {
	activable.activer();
    }

    /**
     * La méthode <code>activerActivableAvecObjet</code> permet au vivant d'activer un Activable.
     *
     * @param activable an <code>Activable</code> value, l'Activable à activer.
     * @param objet an <code>Objet</code> value, l'Objet avec lequel activer.
     * @exception ActivationException lancée si l'activation lance une exception.
     */
    public void activerActivableAvecObjet(Activable activable, Objet objet)throws ActivationException
    {
	activable.activerAvec(objet);
    }   
    
    
    /**
     * La méthode <code>getObjets</code> renvie les objets possédés par le vivant.
     * @return a <code>HashMap<String,Objet></code> value
     */
    public HashMap<String,Objet> 	getObjets()
    {
	return objets;
    }     
     
    /**
     * La méthode <code>getObjet</code> renvoie un objet possédé par le vivant à partir de son nom.
     *
     * @param nomObjet a <code>java.lang.String</code> value, le nom de l'objet.
     * @return an <code>Objet</code> value
     */
    public Objet getObjet(java.lang.String nomObjet)
    {
	return objets.get(nomObjet);
    } 

    /**
     * La méthode <code>possede</code> renseigne si le vivant possède un objet.
     *
     * @param obj an <code>Objet</code> value, l'objet à tester.
     * @return a <code>boolean</code> value
     */
    public boolean possede(Objet obj)
    {
	return objets.containsValue(obj);
    } 
    
    /**
     * La méthode <code>getPointVie</code> renvoie le nombre de points de vie du vivant.
     *
     * @return an <code>int</code> value
     */
    public int getPointVie()
    {
	return pointsVie;
    } 

    /**
     * La méthode <code>getPointForce</code> renvoie le nombre de points de force du vivant.
     *
     * @return an <code>int</code> value
     */
    public int getPointForce()
    {
	return pointsForce;
    } 

    /**
     * La méthode <code>estMort</code> renseigne si le vivant est mort.
     *
     * @return a <code>boolean</code> value
     */
    public boolean estMort()
    {
	return (pointsVie<=0);
    }      
    
    /**
     * La méthode <code>toString</code> renvoie une chaine de caractère avec les informations du vivant.
     *
     * @return a <code>String</code> value
     */
    public String toString() 
    {
	if(!estMort())
	    {
		StringBuilder str=new StringBuilder();
		str.append(getNom());
		str.append(" (");
		str.append(getPointForce());
		str.append(" PF, ");
		str.append(getPointVie());
		str.append(" PV) {");
		for(Objet i:objets.values())
		    {		    
			str.append(i.getNom());
			str.append(", ");
		    }
		str.append("}");
		return str.toString().replace(", }","}");
	    }
	else
	    return getNom()+" est mort...";
    }
}
