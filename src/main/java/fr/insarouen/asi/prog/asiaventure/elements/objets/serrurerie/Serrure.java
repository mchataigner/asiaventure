package fr.insarouen.asi.prog.asiaventure.elements.objets.serrurerie;

import fr.insarouen.asi.prog.asiaventure.Monde;
import fr.insarouen.asi.prog.asiaventure.elements.objets.Objet;
import fr.insarouen.asi.prog.asiaventure.elements.Etat;
import fr.insarouen.asi.prog.asiaventure.elements.Activable;
import fr.insarouen.asi.prog.asiaventure.NomDEntiteDejaUtiliseDansLeMondeException;
import fr.insarouen.asi.prog.asiaventure.elements.ActivationImpossibleException;
import fr.insarouen.asi.prog.asiaventure.elements.ActivationImpossibleAvecObjetException;


/**
 * Serrure est la classe representant une serrure
 * une serrure est associee a une clef.
 * Cette est sur la serrure quand elle est cree.
 * Elle doit etre recupere et replace dans un endroit du monde.
 * Il ny a qu'une seule clef par serrure.
 * @author <a href="mailto:mathieu.chataigner@insa-rouen.fr">Mathieu CHATAIGNER</a>
 * @version 1.0
 */
public class Serrure extends Objet implements Activable
{
    private static int numSerrure=1;
    private Etat etat;
    private String nomClef=null;
    private int numCle;
    
    /**
     * Créer une nouvelle instance de <code>Serrure</code>.
     * @param leNom a <code>String</code> value, le nom de la serrure.
     * @param leMonde a <code>Monde</code> value, le monde de la serrure.
     * @exception NomDEntiteDejaUtiliseDansLeMondeException si le nom de la serrure est déjà utilisé dans le monde.
     */
    public Serrure(String leNom, Monde leMonde)throws NomDEntiteDejaUtiliseDansLeMondeException
    {
	super(leNom,leMonde);
	etat=Etat.VERROUILLE;
	numCle=numSerrure;
	numSerrure++;
    }
    
    /**
     * Créer une nouvelle instance de <code>serrure</code> avec un nom par defaut
     * @param leMonde a <code>Monde</code> value, le monde de la serrure.
     * @exception NomDEntiteDejaUtiliseDansLeMondeException si le nom de la serrure est déjà utilisé dans le monde.
     */
    public Serrure(Monde leMonde)throws NomDEntiteDejaUtiliseDansLeMondeException
    {
	this("serrure"+numSerrure,leMonde);
    }
    
    /**
     * La méthode <code>creerClef</code> créer la clef associée à la serrure.
     *@return la clef créée
     */
    public Clef creerClef()
    {
	Clef laClef=null;
	int alea=1;
	boolean nomPasCorrect=true,premierNom=true;
	if(nomClef==null){
	    while(nomPasCorrect)
		{
		    try
			{
			    laClef=new Clef("clef"+numSerrure,getMonde());
			    nomClef=laClef.getNom();
			    nomPasCorrect=false;
			}
		    catch(NomDEntiteDejaUtiliseDansLeMondeException e)
			{
			    nomPasCorrect=true;
			    
			}
		}
	}
	else
	    {
		laClef=null;
	    }
	return laClef;
    }
    
    /**
     * La méthode <code>estDeplacable</code> décrit si la serrure est déplaçabe.
     * @return a <code>boolean</code> value
     */
    public boolean estDeplacable()
    {
	return false;
    }
    
    /**
     * La méthode <code>activableAvec</code> renseigne si la serrure est actvable avec un objet.
     * @param obj an <code>Objet</code> value, l'objet que l'on teste.
     * @return a <code>boolean</code> value
     */
    public boolean activableAvec(Objet obj)
    {
	return (obj.getNom()==nomClef);//(obj instanceof Clef)&&obj.getNom()==nomClef);
    }
    
    /**
     * La méthode <code>activerAvec</code> active la serrure avec un objet.
     * Change l'etat de la serrure entre VERROUILLE et DEVERROUILLE
     * @param obj an <code>Objet</code> value, l''objet avec lequel activer la serrure.
     * @exception ActivationImpossibleAvecObjetException lancée si l'activation est impossible avecc l'objet.
     */
    public void activerAvec(Objet obj)throws ActivationImpossibleAvecObjetException
    {
	if(activableAvec(obj)){
	    switch(etat){
	    case DEVERROUILLE:
		etat=Etat.VERROUILLE;
		break;
	    case VERROUILLE:
		etat=Etat.DEVERROUILLE;
		break;
	    }
	}
	else
	    throw new ActivationImpossibleAvecObjetException("la serrure "+this.getNom()+" n'est pas activatble avec "+obj.getNom());
    }
    
    /**
     * La méthode <code>activer</code> active la serrure.
     * Seulement une serrure ne peut pas s'activer toute seule, une exception est donc lancée.
     * @exception ActivationImpossibleException lancée si l'activation est impossible.
     */
    public void activer()throws ActivationImpossibleException
    {
	throw new ActivationImpossibleException("activer une serrure sans une clef est impossible");
    }
    
    /**
     * La méthode <code>getEtat</code> retourne l'etat de la serrure
     * @return an <code>Etat</code> value
     */
    public Etat getEtat()
    {
	return etat;
    }
    
    /**
     * La méthode <code>toString</code> retourne une chaine de caractere avec le nom et l'etat de la serrure
     * @return a <code>String</code> value
     */
    public String toString()
    {
	return "la serrure : "+getNom()+getEtat().toString();
    }
    
}