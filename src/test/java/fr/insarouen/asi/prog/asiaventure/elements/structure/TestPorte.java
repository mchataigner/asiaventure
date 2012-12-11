package fr.insarouen.asi.prog.asiaventure.elements.structure;

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

import fr.insarouen.asi.prog.asiaventure.elements.Etat;

import org.hamcrest.core.*;
import static org.junit.Assert.*;

public class TestPorte
{
    public Porte laPorte;
    public Porte laPorteSerrure;
    public Monde leMonde;
    public Piece piece1;
    public Piece piece2;
    public Serrure laSerrure;
    public Clef laClef;
    
    @Before
    public void avantTest()throws Throwable
    {
        leMonde=new Monde("monde de test");
        piece1=new Piece("piece1",leMonde);
        piece2=new Piece("piece2",leMonde);
        laPorte=new Porte("laPorteDeTeste",leMonde,piece1,piece2);
        laSerrure=new Serrure(leMonde);
        laClef=laSerrure.creerClef();
        laPorteSerrure=new Porte("laPorteDeTesteSerrure",leMonde,laSerrure,piece1,piece2);
    }

    @After
    public void apresTest()
    {
        leMonde=null;
        piece1=null;
        piece2=null;
        laPorteSerrure=null;
        laSerrure=null;
        laClef=null;
        laPorte=null;
    }
    
    @Test
    public void testConstructeurs()
    {
        assertThat(laPorte.getEtat(),IsEqual.equalTo(Etat.FERME));
        assertThat(laPorteSerrure.getEtat(),IsEqual.equalTo(Etat.VERROUILLE));
    }
    
    @Test
    public void testActiver()throws Throwable
    {
        assertThat(laPorte.activableAvec(laClef),IsEqual.equalTo(false));
        assertThat(laPorteSerrure.activableAvec(laClef),IsEqual.equalTo(true));
        
        laPorte.activer();
        assertThat(laPorte.getEtat(),IsEqual.equalTo(Etat.OUVERT));
        
        laPorteSerrure.activerAvec(laClef);
        assertThat(laPorteSerrure.getEtat(),IsEqual.equalTo(Etat.OUVERT));
        
        laPorte.activer();
        assertThat(laPorte.getEtat(),IsEqual.equalTo(Etat.FERME));

        laPorteSerrure.activerAvec(laClef);
        assertThat(laPorteSerrure.getEtat(),IsEqual.equalTo(Etat.VERROUILLE));
        
        laPorteSerrure.activerAvec(laClef);
        laPorteSerrure.activer();
        assertThat(laPorteSerrure.getEtat(),IsEqual.equalTo(Etat.FERME));
        
        laPorteSerrure.activerAvec(laClef);
        assertThat(laPorteSerrure.getEtat(),IsEqual.equalTo(Etat.VERROUILLE));
    }

    @Test(expected=ASIAventureException.class)
    public void testActivationExceptionPorteSansSerrure()throws Throwable
    {
        laPorte.activerAvec(laClef);
    }
    
    @Test(expected=ASIAventureException.class)
    public void testActivationExceptionPorteSerrure()throws Throwable
    {
        laPorteSerrure.activer();
    }
    
    @Test
    public void testPorteAutreCote()
    {
        assertThat(laPorte.getPieceAutreCote(piece1),IsEqual.equalTo(piece2));
        assertThat(laPorteSerrure.getPieceAutreCote(piece1),IsEqual.equalTo(piece2));
        assertThat(laPorte.getPieceAutreCote(piece2),IsEqual.equalTo(piece1));
        assertThat(laPorteSerrure.getPieceAutreCote(piece2),IsEqual.equalTo(piece1));
    }

    @Test
    public void testGetSerrure()
    {
        assertThat(laPorte.getSerrure(),IsEqual.equalTo(null));
        assertThat(laPorteSerrure.getSerrure(),IsEqual.equalTo(laSerrure));
    }
}
