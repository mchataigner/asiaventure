package fr.insarouen.asi.prog.asiaventure.elements.structure;

import fr.insarouen.asi.prog.asiaventure.elements.objets.serrurerie.*;
import fr.insarouen.asi.prog.asiaventure.Monde;
import fr.insarouen.asi.prog.asiaventure.elements.objets.Objet;
import fr.insarouen.asi.prog.asiaventure.elements.Etat;
import fr.insarouen.asi.prog.asiaventure.NomDEntiteDejaUtiliseDansLeMondeException;
import fr.insarouen.asi.prog.asiaventure.elements.ActivationImpossibleException;
import fr.insarouen.asi.prog.asiaventure.elements.ActivationImpossibleAvecObjetException;




/**
 * La classe <code>porte</code> représente une porte.
 *une porte ne peut exister qu'entre deux pièces.
 * @author <a href="mailto:mathieu.chataigner@insa-rouen.fr">Mathieu CHATAIGNER</a>
 * @version 1.0
 */
public class Porte extends ElementStructurel
{
    private Etat etat;
    private Piece pieceA,pieceB;
    private Serrure serrure=null;
    
    /**
     * Créer une nouvelle instance de <code>porte</code>.
     * @param nom a <code>String</code> value, le nom de la porte.
     * @param monde a <code>Monde</code> value, le monde de la porte.
     * @param _pieceA a <code>Piece</code> value, la premiere piece.
     * @param _pieceB a <code>Piece</code> value, la deuxieme piece.
     * @exception NomDEntiteDejaUtiliseDansLeMondeException if an error occurs
     */
    public Porte(String nom, Monde monde, Piece _pieceA, Piece _pieceB)throws NomDEntiteDejaUtiliseDansLeMondeException
    {
	super(nom,monde);
	pieceA=_pieceA;
	pieceB=_pieceB;
	pieceA.addPorte(this);
	pieceB.addPorte(this);
	etat=Etat.FERME;	
    };

    /**
     * Créer une nouvelle instance de <code>porte</code> verrouillée.
     * @param nom a <code>String</code> value, le nom de la porte.
     * @param monde a <code>Monde</code> value, le monde de la porte.
     * @param _serrure a <code>Serrure</code> value, la serrure de la porte.
     * @param _pieceA a <code>Piece</code> value, la premiere piece.
     * @param _pieceB a <code>Piece</code> value, la deuxieme piece.
     * @exception NomDEntiteDejaUtiliseDansLeMondeException if an error occurs
     */
    public Porte(String nom, Monde monde, Serrure _serrure, Piece _pieceA, Piece _pieceB)throws NomDEntiteDejaUtiliseDansLeMondeException
    {
	this(nom,monde,_pieceA,_pieceB);
	serrure=_serrure;
	etat=Etat.VERROUILLE;
    };
    

    /**La méthode <code>activableAvec</code> teste si une porte est activable avec un objet
     *@param obj a <code>Objet</code> value, l'objet a tester
     *@return TRUE si la porte est activable avec l'objet FALSE sinon
     */
    public boolean 	activableAvec(Objet obj)
    {
	if(this.serrure==null)
	    return false;
	else
	    return this.serrure.activableAvec(obj);
    };
    
    /**
     * La méthode <code>activer</code> active une porte en changeant son etat (OUVERT ou FERME)
     * @exception ActivationImpossibleException lancée si l'atvation est impossble.
     */
    public void 	activer()throws ActivationImpossibleException
    {
	if(etat!=Etat.VERROUILLE){
	    switch(etat){
	    case OUVERT:
		etat=Etat.FERME;
		break;
	    case FERME:
		{
		    etat=Etat.OUVERT;
		}
		break;
	    }
	}
	else
	    throw new ActivationImpossibleException("la porte "+this.getNom()+" est vérouillée et ne peut être activée sans une clef");
    };
    
    /**
     * La méthode <code> activerAvec</code> active une porte avec un objet en changeant son etat.
     *Une porte ouverte devient verrouillee, une verrouillee devient ouverte et une fermee devient verrouillee.
     * @param obj an <code>Objet</code> value, l'objet à tester.
     * @exception ActivationImpossibleAvecObjetException lancée si l'activation est impossible avec l'objet.
     */
    public void 	activerAvec(Objet obj)throws ActivationImpossibleAvecObjetException
    {
	if(activableAvec(obj))
	    {
		serrure.activerAvec(obj);
		switch(etat){
		case OUVERT:
		    etat=Etat.VERROUILLE;
		    break;
		case VERROUILLE:
		    etat=Etat.OUVERT;
		    break;
		case FERME:
		    etat=Etat.VERROUILLE;
		    break;
		};
	    }
	else
	    throw new ActivationImpossibleAvecObjetException("la porte "+this.getNom()+" n'est pas activatble avec "+obj.getNom());
    };
    
    /**La méthode <code>getEtat</code> renvoie l'etat de la porte
     *@return etat, l'etat de la porte
     */
    public Etat 	getEtat()
    {
	return etat;
    };
    
    /**La méthode <code>getPieceAutreCote</code> renvoie la piece de l'autre cote de la porte
     *@param piece a <code>Piece</code> value, la piece connue.
     *@return la piece de l'autre cote de la porte
     */
    public Piece 	getPieceAutreCote(Piece piece)
    {
	if(piece==pieceA)
	    return pieceB;
	else
	    if(piece==pieceB)
		return pieceA;
	    else
		return null;
    };
    
    /**La méthode <code>getSerrure</code> renvoie la serrure de la porte
     *@return serrure
     */
    public Serrure 	getSerrure()
    {
	return serrure;
    };
    
    /**La méthode <code>toString</code> renvoie une chaine de caractere contenant le nom de la porte, son etat et les deux piece de chaque cote de la porte
     *@return String
     */
    public String 	toString()
    {
	return "la porte \""+getNom()+"\" ("+getEtat()+") est entre la pièce \""+pieceA.getNom()+"\" et la pièce \""+pieceB.getNom()+"\"";
    };
}
