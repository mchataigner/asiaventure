package fr.insarouen.asi.prog.asiaventure.interfaces;

import fr.insarouen.asi.prog.asiaventure.*;
import fr.insarouen.asi.prog.asiaventure.elements.structure.*;
import fr.insarouen.asi.prog.asiaventure.elements.vivants.*;
import fr.insarouen.asi.prog.asiaventure.elements.objets.*;
import fr.insarouen.asi.prog.asiaventure.elements.objets.serrurerie.*;

import java.io.*;

import java.util.*;

import fr.insarouen.asi.prog.asiaventure.elements.Executable;

public class VueTxt implements Observer
{
    private Simulateur s;
    
    public VueTxt(Simulateur s)
    {
        s.addObserver(this);
        this.s=s;
    }
    
    public void update(Observable o,Object arg)
    {
        System.err.println("hihi ça marche");
        System.out.println((JoueurHumain)arg);
        System.out.println(((JoueurHumain)arg).getPiece());
        System.out.println("Quelle action souhaitez-vous faire ?\n");
        
    }
}