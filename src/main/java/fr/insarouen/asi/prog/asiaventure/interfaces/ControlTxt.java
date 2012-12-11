package fr.insarouen.asi.prog.asiaventure.interfaces;

import fr.insarouen.asi.prog.asiaventure.*;
import fr.insarouen.asi.prog.asiaventure.elements.structure.*;
import fr.insarouen.asi.prog.asiaventure.elements.vivants.*;
import fr.insarouen.asi.prog.asiaventure.elements.objets.*;
import fr.insarouen.asi.prog.asiaventure.elements.objets.serrurerie.*;

import java.io.*;

import java.util.*;

import fr.insarouen.asi.prog.asiaventure.elements.Executable;

public class ControlTxt implements ControlerJava,Runnable
{
    private boolean quitter=false;
    private Simulateur s;
    private static Scanner scn;
    private String ordre;
    public ControlTxt(Simulateur s)
    {
        this.s=s;
        ordre=null;
        //        scn=new Scanner(System.in);
        
        
    }
    
    public void jouer()
    {
	if(s.quitter())
	    return;
	
        while(!quitter)
            {
                ordre=null;
                if(scn==null)
		    scn=new Scanner(System.in);
                System.err.println("Voulez-vous quitter ? \"quitter\"");
                do
                    {
                        ordre=scn.nextLine();
                    }
                while(ordre.trim().length()==0);
                if(ordre.toUpperCase().equals("QUITTER"))
                    {        
                        System.err.println("huhu");
			s.setQuitter();
                        s.reprendre();
			quitter=true;
                        return;
                    }
                else
                    {
                        s.setOrdreJH(ordre.trim());
                        s.reprendre();
                        
                    }
                
		try
                    {
                        Thread.sleep(100);
                    }
                catch(Throwable e)
                    {
                    }
		
            }
    }
    
    public void run()
    {
        jouer();
    }

    public void setQuitter()
    {
        System.err.println("hihi");
        quitter=true;
    }
}
