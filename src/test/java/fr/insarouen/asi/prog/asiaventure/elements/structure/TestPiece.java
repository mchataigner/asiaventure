package fr.insarouen.asi.prog.asiaventure.elements.structure;

import org.junit.*;
import org.hamcrest.core.*;

import org.junit.Before;
import org.junit.After;
import org.junit.Ignore;
import org.junit.Test;

import fr.insarouen.asi.prog.asiaventure.ASIAventureException;
import fr.insarouen.asi.prog.asiaventure.Monde;
import fr.insarouen.asi.prog.asiaventure.elements.structure.Piece;
import fr.insarouen.asi.prog.asiaventure.elements.structure.Porte;
import fr.insarouen.asi.prog.asiaventure.elements.objets.serrurerie.Serrure;
import fr.insarouen.asi.prog.asiaventure.elements.objets.serrurerie.Clef;
import fr.insarouen.asi.prog.asiaventure.elements.vivants.Vivant;
import fr.insarouen.asi.prog.asiaventure.elements.vivants.JoueurHumain;

import fr.insarouen.asi.prog.asiaventure.elements.objets.Objet;

import fr.insarouen.asi.prog.asiaventure.elements.Etat;

import org.hamcrest.core.*;
import static org.junit.Assert.*;

public class TestPiece
{
    public Porte laPorte;
    public Porte laPorteSerrure;
    public Monde leMonde;
    public Piece laPiece;
    public Piece piece2;
    public Serrure laSerrure;
    public Clef laClef;
    public Vivant leVivant;
    
    @Before
    public void avantTest()throws Throwable
    {
        leMonde=new Monde("monde de test");
        laPiece=new Piece("laPieceDeTest",leMonde);
        piece2=new Piece("piece2",leMonde);
        laPorte=new Porte("laPorte",leMonde,laPiece,piece2);
        laSerrure=new Serrure(leMonde);
        laClef=laSerrure.creerClef();
        laPorteSerrure=new Porte("laPorteSerrure",leMonde,laSerrure,laPiece,piece2);
        leVivant=new JoueurHumain("leSuperVivant",leMonde,10,10,laPiece);
    }
    
    @After
    public void apresTest()
    {
        leMonde=null;
        laPiece=null;
        piece2=null;
        laPorte=null;
        laSerrure=null;
        laClef=null;
        laPorteSerrure=null;
        leVivant=null;
    }
    
    @Test
    public void testConstructeurs()
    {
        assertThat(laPiece.contientVivant(leVivant),IsEqual.equalTo(true));
        assertThat(laPiece.contientVivant("leSuperVivant"),IsEqual.equalTo(true));
        assertThat(laPiece.aLaPorte("laPorte"),IsEqual.equalTo(true));
        assertThat(laPiece.aLaPorte("laPorteSerrure"),IsEqual.equalTo(true));
        assertThat(laPiece.aLaPorte(laPorte),IsEqual.equalTo(true));
        assertThat(laPiece.aLaPorte(laPorteSerrure),IsEqual.equalTo(true));
    }
    
    @Test
    public void testDeposer()
    {
        laPiece.deposer(laClef);
        assertThat(laPiece.contientObjet(laClef),IsEqual.equalTo(true));
        assertThat(laPiece.contientObjet(laClef.getNom()),IsEqual.equalTo(true));
    }
    
    @Test
    public void testRetirer()throws Throwable
    {
        Objet lObjetRetire;
        laPiece.deposer(laClef);

        lObjetRetire=laPiece.retirer(laClef);
        assertThat(lObjetRetire,IsEqual.equalTo((Objet)laClef));

        assertThat(laPiece.contientObjet(laClef),IsEqual.equalTo(false));
        assertThat(laPiece.contientObjet(laClef.getNom()),IsEqual.equalTo(false));
        laPiece.deposer(laClef);

        lObjetRetire=laPiece.retirer(laClef);
        assertThat(lObjetRetire,IsEqual.equalTo((Objet)laClef));

        assertThat(laPiece.contientObjet(laClef),IsEqual.equalTo(false));
        assertThat(laPiece.contientObjet(laClef.getNom()),IsEqual.equalTo(false));
        
    }

    @Test(expected=ASIAventureException.class)
    public void testRetirerAbsent()throws Throwable
    {
        Objet lObjetRetire=laPiece.retirer(laClef);
    }
    
    
    
    @Test
    public void testGetPorte()
    {
        assertThat(laPiece.getPorte(laPorte.getNom()),IsEqual.equalTo(laPorte));
        assertThat(laPiece.getPorte(laPorteSerrure.getNom()),IsEqual.equalTo(laPorteSerrure));
    }
    
    @Test
    public void testEntrer()
    {
        laPiece.entrer(leVivant);
        assertThat(laPiece.contientVivant(leVivant.getNom()),IsEqual.equalTo(true));
        assertThat(laPiece.contientVivant(leVivant),IsEqual.equalTo(true));
    }

    @Test
    public void testSortir()throws Throwable
    {
        Vivant leVivantSorti;
        laPiece.entrer(leVivant);

        leVivantSorti=laPiece.sortir(leVivant);
        assertThat(leVivantSorti,IsEqual.equalTo(leVivant));

        assertThat(laPiece.contientVivant(leVivant),IsEqual.equalTo(false));
        assertThat(laPiece.contientVivant(leVivant.getNom()),IsEqual.equalTo(false));
        
        laPiece.entrer(leVivant);

        leVivantSorti=laPiece.sortir(leVivant.getNom());
        assertThat(leVivantSorti,IsEqual.equalTo(leVivant));

        assertThat(laPiece.contientVivant(leVivant),IsEqual.equalTo(false));
        assertThat(laPiece.contientVivant(leVivant.getNom()),IsEqual.equalTo(false));
    }
    
    @Test(expected=ASIAventureException.class)
    public void testSortirAbsent()throws Throwable
    {
        Vivant leVivantSorti=piece2.sortir(leVivant.getNom());
    }
}
