package fr.insarouen.asi.prog.asiaventure;

import fr.insarouen.asi.prog.asiaventure.*;
import fr.insarouen.asi.prog.asiaventure.elements.structure.*;
import fr.insarouen.asi.prog.asiaventure.elements.vivants.*;
import fr.insarouen.asi.prog.asiaventure.elements.objets.*;
import fr.insarouen.asi.prog.asiaventure.elements.objets.serrurerie.*;

import java.io.*;

import java.util.*;

import fr.insarouen.asi.prog.asiaventure.elements.Executable;

public class EntreeCommandeJH implements InterfaceHM
{
    private Simulateur s;
    private boolean quitter=false;
    private JoueurHumain jh;
    private String ordre=null;
    private Scanner scn=new Scanner(System.in);
	
    public EntreeCommandeJH(Simulateur s)
    {
	this.s=s;
       	s.addObserver(this);
    }
    
    public void update(Observable o,Object arg)
    {
	jh=s.getJH();
	quitter=false;
	ordre=null;
	
	//System.out.println("Voulez-vous quitter ? O/N");
	//ordre=scn.next();
	//scn.nextLine();
	
	
	do
	    {
		ordre=scn.nextLine().trim();
	    }
	while(ordre.length()==0);
            //update(o,arg);//isEmpty());
	if(ordre.toUpperCase().equals("QUITTER"))
	    {
		quitter=true;
		s.setQuitter();
                System.err.println(ordre.toUpperCase());
		
	    }
	else		
	    {
		System.err.println(ordre.toUpperCase().equals("QUITTER"));
		s.setOrdreJH(ordre);
	    }
	
	s.reprendre();
    }
    
    public void run()
    {
	while(!quitter);
    }
}