package fr.insarouen.asi.prog.asiaventure;

import fr.insarouen.asi.prog.asiaventure.*;
import fr.insarouen.asi.prog.asiaventure.elements.structure.*;
import fr.insarouen.asi.prog.asiaventure.elements.vivants.*;
import fr.insarouen.asi.prog.asiaventure.elements.objets.*;
import fr.insarouen.asi.prog.asiaventure.elements.objets.serrurerie.*;

import java.io.*;

import java.util.*;

import fr.insarouen.asi.prog.asiaventure.elements.Executable;


/**
 * Describe class <code>Simulateur</code> here.
 *
 * @author <a href="mailto:mathieu.chataigner@insa-rouen.fr">Mathieu CHATAIGNER</a>
 * @version 1.0
 */
public class Simulateur extends Observable
{
    private ArrayList<ConditionDeFin> lesConditions;
    private Monde leMonde;
    private int dureeDeJeu;
    private int tempsPourPrevenirLaFinDuJeu;
    private EtatDuJeu lEtatDuJeu;
    private boolean quitter=false;
    private JoueurHumain jh;
    private boolean attendre=true;
    private String ordre=null;
    /**
     * Creates a new <code>Simulateur</code> instance.
     *
     * @param leMonde a <code>Monde</code> value
     * @param dureeDeJeu an <code>int</code> value
     * @param tempsPourPrevenirLaFinDuJeu an <code>int</code> value
     */
    public Simulateur(Monde leMonde, int dureeDeJeu, int tempsPourPrevenirLaFinDuJeu, ConditionDeFin... conditionsDeFin)
    {
	super();
	this.leMonde=leMonde;
	this.dureeDeJeu=dureeDeJeu;
	this.tempsPourPrevenirLaFinDuJeu=tempsPourPrevenirLaFinDuJeu;
	lesConditions=new ArrayList<ConditionDeFin>();
	lesConditions.addAll(Arrays.asList(conditionsDeFin));
	lEtatDuJeu=EtatDuJeu.ENCOURS;
	quitter=false;
    }
    
    /**
     * Creates a new <code>Simulateur</code> instance.
     *
     * @param ois an <code>ObjectInputStream</code> value
     * @exception IOException if an error occurs
     * @exception NomDEntiteDejaUtiliseDansLeMondeException if an error occurs
     * @exception ClassNotFoundException if an error occurs
     */
    public Simulateur(ObjectInputStream ois)throws IOException,NomDEntiteDejaUtiliseDansLeMondeException,ClassNotFoundException
    {
	super();
	quitter=false;
	leMonde=(Monde)ois.readObject();
	lesConditions=(ArrayList<ConditionDeFin>)ois.readObject();
	lEtatDuJeu=(EtatDuJeu)ois.readObject();
	dureeDeJeu=ois.readInt();
	ois.close();
    }
    
    /**
     * Creates a new <code>Simulateur</code> instance.
     *
     * @param reader a <code>Reader</code> value
     * @exception java.io.IOException if an error occurs
     * @exception NomDEntiteDejaUtiliseDansLeMondeException if an error occurs
     */
    public Simulateur(Reader reader)throws java.io.IOException,NomDEntiteDejaUtiliseDansLeMondeException
    {
	super();
	quitter=false;
	lesConditions=new ArrayList<ConditionDeFin>();
	lEtatDuJeu=EtatDuJeu.ENCOURS;
	dureeDeJeu=20;
	String leType;
	StreamTokenizer tokenReader=new StreamTokenizer(reader);
	//tokenReader.nextToken();
	//dureeDeJeu=(int)tokenReader.nval;
	while(tokenReader.nextToken()!=tokenReader.TT_EOF)
	    {
		construitMonde(tokenReader);
		construitPiece(tokenReader);
		construitPorteSerrure(tokenReader);
		construitPorte(tokenReader);
		construitClef(tokenReader);
		construitJoueurHumain(tokenReader);
		construitConditionDeFinVivantDansPiece(tokenReader);
	    }
    }
    
    private void construitMonde(StreamTokenizer stk)throws java.io.IOException,NomDEntiteDejaUtiliseDansLeMondeException
    {
	if(!stk.sval.equals("Monde"))
	    return;
	stk.nextToken();
	leMonde=new Monde(stk.sval);
    }
    
    private void construitPiece(StreamTokenizer stk) throws java.io.IOException,NomDEntiteDejaUtiliseDansLeMondeException
    {
	if(!stk.sval.equals("Piece"))
	    return;
	stk.nextToken();
	new Piece(stk.sval,leMonde);
    }
    
    private void construitPorteSerrure(StreamTokenizer stk)throws java.io.IOException,NomDEntiteDejaUtiliseDansLeMondeException
    {
	if(!stk.sval.equals("PorteSerrure"))
	    return;
	stk.nextToken();
	String nomPorte=stk.sval;
	stk.nextToken();
	Piece piece1=(Piece)leMonde.getEntite(stk.sval);
	stk.nextToken();
	Piece piece2=(Piece)leMonde.getEntite(stk.sval);
	new Porte(nomPorte,leMonde,new Serrure(leMonde),piece1,piece2);
    }

    private void construitPorte(StreamTokenizer stk)throws java.io.IOException,NomDEntiteDejaUtiliseDansLeMondeException
    {
	if(!stk.sval.equals("Porte"))
	    return;
	stk.nextToken();
	String nomPorte=stk.sval;
	stk.nextToken();
	Piece piece1=(Piece)leMonde.getEntite(stk.sval);
	stk.nextToken();
	Piece piece2=(Piece)leMonde.getEntite(stk.sval);
	new Porte(nomPorte,leMonde,piece1,piece2);
    }

    private void construitClef(StreamTokenizer stk)throws java.io.IOException,NomDEntiteDejaUtiliseDansLeMondeException
    {
	if(!stk.sval.equals("Clef"))
	    return;
	stk.nextToken();
	Clef laClef=((Porte)leMonde.getEntite(stk.sval)).getSerrure().creerClef();
	stk.nextToken();
	((Piece)leMonde.getEntite(stk.sval)).deposer(laClef);
    }
    
    private void construitJoueurHumain(StreamTokenizer stk)throws java.io.IOException,NomDEntiteDejaUtiliseDansLeMondeException
    {
	if(!stk.sval.equals("JoueurHumain"))
	    return;
	stk.nextToken();
	String nomJoueurHumain=stk.sval;
	stk.nextToken();
	int pointsVie=(int)stk.nval;
	stk.nextToken();
	int pointsForce=(int)stk.nval;
	stk.nextToken();
	Vivant lj=new JoueurHumain(nomJoueurHumain,leMonde,pointsVie,pointsForce,(Piece)leMonde.getEntite(stk.sval));
	
    }
    
    private void construitConditionDeFinVivantDansPiece(StreamTokenizer stk)throws java.io.IOException,NomDEntiteDejaUtiliseDansLeMondeException
    {
	if(!stk.sval.equals("ConditionDeFinVivantDansPiece"))
	    return;
	stk.nextToken();
	EtatDuJeu edj=Enum.valueOf(EtatDuJeu.class,stk.sval);
	stk.nextToken();
	String nomVivant=stk.sval;
	Vivant leVivant=(Vivant)leMonde.getEntite(nomVivant);
	stk.nextToken();
	String nomPiece=stk.sval;
	this.ajouterConditionDeFin(new ConditionDeFinVivantDansPiece(edj,leVivant,(Piece)leMonde.getEntite(nomPiece)));
    }
    
    /**
     * Describe <code>ajouterConditionDeFin</code> method here.
     *
     * @param condition a <code>ConditionDeFin</code> value
     */
    public void ajouterConditionDeFin(ConditionDeFin condition)
    {
	lesConditions.add(condition);
    }
    
    /**
     * Describe <code>ajouterConditionsDeFin</code> method here.
     *
     */
    public void ajouterConditionsDeFin(Collection<ConditionDeFin> conditions)
    {
	lesConditions.addAll(conditions);
    }
    
    /**
     * Describe <code>enregistrer</code> method here.
     *
     * @param oos an <code>ObjectOutputStream</code> value
     * @exception java.io.IOException if an error occurs
     * @exception NomDEntiteDejaUtiliseDansLeMondeException if an error occurs
     */
    public void enregistrer(ObjectOutputStream oos)throws java.io.IOException,NomDEntiteDejaUtiliseDansLeMondeException
    {
	oos.writeObject(leMonde);
	oos.writeObject(lesConditions);
	oos.writeObject(lEtatDuJeu);
	oos.writeInt(dureeDeJeu);
	oos.close();
    }
    
    
    /**
     * Describe <code>executerJusquALaFin</code> method here.
     *
     * @return an <code>EtatDuJeu</code> value
     * @exception Throwable if an error occurs
     */
    public EtatDuJeu executerJusquALaFin()throws Throwable
    {
	quitter=false;
	while(dureeDeJeu>0&&lEtatDuJeu.equals(EtatDuJeu.ENCOURS)&&!quitter)
	    {
		lEtatDuJeu=executerUnTour();
	    }
	return lEtatDuJeu;
    }
    
    public JoueurHumain getJH()
    {
	return this.jh;
    }
    
    
    public boolean attendre()
    {
        return attendre;
    }
    
    public synchronized void reprendre()
    {
        attendre=false;
    }
    
    public boolean getQuitter()
    {
        return this.quitter;
    }
    
    public synchronized void setQuitter()
    {
        quitter=true;
    }
    
    public synchronized void setOrdreJH(String ord)
    {
        ordre=ord;
    }
    
    private void executerUnTourJH(JoueurHumain _jh)throws Throwable
    {
	this.jh=_jh;
	quitter=false;
        boolean commandeValide=false;
        do
            {
                ordre=null;
                attendre=true;
                System.err.println("huhu");
                setChanged();
                System.err.println("huhu");
                notifyObservers((Object)jh);
                System.err.println("huhu");
                //while(attendre());
                System.err.println("huhu");
                if(ordre!=null)
                    {
                        try
                            {
                                jh.setOrdre(ordre);
                                jh.executer();

                                commandeValide=true;
                            }
                        catch(ASIAventureException e)
                            {
                                e.printStackTrace();
                                System.err.println(e.getMessage());
                            }
                        catch(Throwable e)
                            {
                                e.printStackTrace();
                        
                                System.err.println(e.getMessage());
                            }
                    }
            }
        while(!commandeValide);

        //         synchronized(this)
        //             {
        //                 System.out.println("test");
        //                 Thread.currentThread().wait();
        //                 //Thread.currentThread().wait();
        //                 System.err.println("huhu");
        //             }
    }
    
    /*  
        public void reprendre()
        {
	attendre=false;
        }
    */    
    
    /**
     * Describe <code>executerUnTour</code> method here.
     *
     * @return an <code>EtatDuJeu</code> value
     * @exception Throwable if an error occurs
     */
    public EtatDuJeu executerUnTour()throws Throwable
    {
	Scanner scn=new Scanner(System.in);
	String ordre;
	EtatDuJeu etatJeu=EtatDuJeu.ENCOURS;
	if( dureeDeJeu>0 && !quitter)
	    {
		for(Executable exec : leMonde.getExecutables())
		    {
			if(exec instanceof JoueurHumain)
			    {
				executerUnTourJH((JoueurHumain)exec);
                                System.out.println("test");
			    }
			else
			    {
				try
				    {
					exec.executer();
                                        System.out.println("test");
				    }
				catch(ASIAventureException e)
				    {
                                        e.printStackTrace();
					System.out.println(e.getMessage());
				    }
				catch(Throwable e)
				    {
                                        e.printStackTrace();
					throw e;
				    }
			    }

		    }
		dureeDeJeu--;
		Iterator i=lesConditions.iterator();
		ConditionDeFin k;
		while(i.hasNext() && etatJeu==EtatDuJeu.ENCOURS)
		    {
			k=(ConditionDeFin)i.next();
			etatJeu=k.verifierCondition();
		    }
		
	    }
	return etatJeu;
    }
    
    /**
     * Describe <code>getEtatDuJeu</code> method here.
     *
     * @return an <code>EtatDuJeu</code> value
     */
    public EtatDuJeu getEtatDuJeu()
    {
	return lEtatDuJeu;
    }
    
    /*public void stopperJeu()
      {
	
      }*/
}
