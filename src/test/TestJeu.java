package test;
import static org.junit.Assert.*;
import org.junit.Test;

public class TestJeu {
  @Test
  public void testSauvegarde(){
   String path = "path/to/file";
   Jeu jeu = new Jeu();
   jeu.sauvegarder(path);
   Jeu copieJeu = jeu.charger(path);
   this.assertEquals(copieJeu.getTempsJeu(),jeu.getTempsJeu());
   this.assertEquals(copieJeu.getModeJeu(),jeu.getModeJeu());


  }
  @Test
  public void testModeJeu(){
    Jeu jeu = new Jeu();
    jeu.setModeJeu(0);
    this.assertEquals(0,jeu.getModeJeu());
  }
