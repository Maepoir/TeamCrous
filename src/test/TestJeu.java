package test;
import static org.junit.Assert.*;
import org.junit.Test;
import arcanor.modele.*;

public class TestJeu {

    @Test
    public void testSauvegarde() {
        String chemin = "path/to/file";
        Jeu jeu = new Jeu(false);
        jeu.sauvegarderJeu(chemin);
        Jeu copieJeu = null;
        copieJeu.chargerJeu(chemin);
        assertEquals(copieJeu.getTempsJeu(), jeu.getTempsJeu());
        assertEquals(copieJeu.getModeJeu(), jeu.getModeJeu());
    }

    @Test
    public void testModeJeu() {
      JoueurHumain j1 = new JoueurHumain("Maë", Couleur_BLANC);
      JoueurHumain j2 = new JoueurHumain("Sim", Couleur_NOIR);
      Jeu jeu = new Jeu(j1,j2, ModeJeu_NORMAL,false);
      jeu.setModeJeu(ModeJeu_TRICHE);
      assertEquals(ModeJeu_TRICHE,jeu.getModeJeu());
    }

}
