package fr.insarouen.asi.prog.asiaventure.elements.vivants;
import fr.insarouen.asi.prog.asiaventure.Monde;

import fr.insarouen.asi.prog.asiaventure.ASIAventureException;

import fr.insarouen.asi.prog.asiaventure.elements.*;

import fr.insarouen.asi.prog.asiaventure.elements.Entite;
import fr.insarouen.asi.prog.asiaventure.NomDEntiteDejaUtiliseDansLeMondeException;
import fr.insarouen.asi.prog.asiaventure.elements.structure.*;

import fr.insarouen.asi.prog.asiaventure.elements.objets.Objet;
import fr.insarouen.asi.prog.asiaventure.elements.ActivationException;
import fr.insarouen.asi.prog.asiaventure.elements.ActivationImpossibleAvecObjetException;
import java.util.*;
import java.lang.reflect.*;


/**
 * Describe class <code>JoueurHumain</code> here.
 *
 * @author <a href="mailto:mathieu.chataigner@insa-rouen.fr">Mathieu CHATAIGNER</a>
 * @version 1.0
 */
public class JoueurHumain extends Vivant
{
    
    private String ordre;
    private List<String> ordreDecoupe;
    
    /**
     * Créer une nouvelle instance de <code>JoueurHumain</code>.
     *
     * @param leNom a <code>String</code> value, le nom du joueur humain.
     * @param leMonde a <code>Monde</code> value, le monde  du joueur humain.
     * @param pointsVie an <code>int</code> value, le nombre de points de vie du joueur humain.
     * @param pointsForce an <code>int</code> value, le nombre de points de force du joueur humain.
     * @param piece a <code>Piece</code> value, la pièce ou se situe le joueur humain.
     * @exception NomDEntiteDejaUtiliseDansLeMondeException lancée si le nom du joueur humain existe déjà dans la monde.
     */
    public JoueurHumain(String leNom, Monde leMonde,int pointsVie,int pointsForce,Piece piece)throws NomDEntiteDejaUtiliseDansLeMondeException
    {
	super(leNom,leMonde,pointsVie,pointsForce,piece);
    }
    
    /**
     * La méthode <code>setOrdre</code> permet de donner un ordre au joueur humain.
     *
     * @param ordre a <code>String</code> value
     */
    public void setOrdre(String ordre)
    {
	this.ordre =ordre;
    }
    
    /**
     * Describe <code>commandeOUVRIR</code> method here.
     *
     * @param nomPorte a <code>String</code> value
     * @exception CommandeImpossiblePourLeVivantException if an error occurs
     */
    public void commandeOUVRIR(String nomPorte)throws CommandeImpossiblePourLeVivantException
    {
    	try
	    {
		Porte laPorte=this.getPiece().getPorte(nomPorte);
		if(laPorte.getEtat()!=Etat.OUVERT)
		    laPorte.activer();
	    }
	catch(ActivationImpossibleException e)
	    {
		throw new CommandeImpossiblePourLeVivantException(e.getMessageASI());
	    }
    }

    /**
     * Describe <code>commandeFERMER</code> method here.
     *
     * @param nomPorte a <code>String</code> value
     * @exception CommandeImpossiblePourLeVivantException if an error occurs
     */
    public void commandeFERMER(String nomPorte)throws CommandeImpossiblePourLeVivantException
    {
    	try
	    {
		Porte laPorte=this.getPiece().getPorte(nomPorte);
		if(laPorte.getEtat()!=Etat.FERME)
		    laPorte.activer();
	    }
	catch(ActivationImpossibleException e)
	    {
		throw new CommandeImpossiblePourLeVivantException(e.getMessageASI());
	    }
    }
    
    
    /**
     * Describe <code>commandeOUVRIR</code> method here.
     *
     * @param nomPorte a <code>String</code> value
     * @param nomObjet a <code>String</code> value
     * @exception CommandeImpossiblePourLeVivantException if an error occurs
     */
    public void commandeOUVRIR(String nomPorte,String nomObjet)throws CommandeImpossiblePourLeVivantException
    {
    	try
	    {
		Porte laPorte=this.getPiece().getPorte(nomPorte);
		if(laPorte.getEtat()==Etat.VERROUILLE)
		    laPorte.activerAvec(getObjet(nomObjet));
	    }
	catch(ActivationImpossibleException e)
	    {
		System.out.println(e);
		throw new CommandeImpossiblePourLeVivantException("commande impossible pour le vivant");
	    }
	
    }

    /**
     * Describe <code>commandeFRANCHIR</code> method here.
     *
     * @param nomPorte a <code>String</code> value
     * @exception CommandeImpossiblePourLeVivantException if an error occurs
     */
    public void commandeFRANCHIR(String nomPorte)throws CommandeImpossiblePourLeVivantException
    {
	try
	    {
		Porte laPorte=this.getPiece().getPorte(nomPorte);
		this.franchir(laPorte);
	    }
	catch(ElementStructurelException e)
	    {
		throw new CommandeImpossiblePourLeVivantException("impossible de franchir "+nomPorte);
	    }
    }

    /**
     * Describe <code>commandePRENDRE</code> method here.
     *
     * @param nomObjet a <code>String</code> value
     * @exception CommandeImpossiblePourLeVivantException if an error occurs
     */
    public void commandePRENDRE(String nomObjet)throws CommandeImpossiblePourLeVivantException
    {
	try
	    {
		this.prendre(nomObjet);
	    }
	catch(PieceException e)
	    {
		System.out.println(e);
		throw new CommandeImpossiblePourLeVivantException("impossible de prendre l'objet");
	    }
    }

    /**
     * Describe <code>commandeDEPOSER</code> method here.
     *
     * @param nomObjet a <code>String</code> value
     * @exception CommandeImpossiblePourLeVivantException if an error occurs
     */
    public void commandeDEPOSER(String nomObjet)throws CommandeImpossiblePourLeVivantException
    {
	try
	    {
		this.deposer(nomObjet);
	    }
	catch(ObjetNonPossedeParLeVivantException e)
	    {
		throw new CommandeImpossiblePourLeVivantException("impossible de déposer l'objet");
	    }
    }
    
    
    
    /**
     * La méthode <code>executer</code> permet d'executer une action sur le joueur humain.
     *
     * @exception CommandeImpossiblePourLeVivantException lancée si la commande est impossible pour le vivant.
     */
    
    public void executer()throws CommandeImpossiblePourLeVivantException
    {	
    	try
	    {
		ordre=ordre.replace("avec ","");
		String[] ordreDecoupe=ordre.split(" +");
		String[] params=new String[ordreDecoupe.length-1];
		System.arraycopy(ordreDecoupe,1,params,0,params.length);
		//String[] params=Arrays.copyOfRange(ordreDecoupe,1,Array.getLength(ordreDecoupe));
		Class[] typesParams=new Class[Array.getLength(params)];
		Arrays.fill(typesParams,String.class);
		Method meth=this.getClass().getMethod("commande"+ordreDecoupe[0].toUpperCase(),typesParams);
		meth.invoke(this,(Object[])params);
	    }
	catch(Throwable e)
	    {
		if(e instanceof CommandeImpossiblePourLeVivantException)
		    throw (CommandeImpossiblePourLeVivantException)e;
		else
		    throw new CommandeImpossiblePourLeVivantException("commande inccorrecte");
	    }

	ordre=null;
	ordreDecoupe=null;
    }
}
