package test;
import static org.junit.Assert.*;
import org.junit.Test;
import arcanor.modele.Jeu;

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
        Jeu jeu = new Jeu(false);
        jeu.setModeJeu(0);
        assertEquals(0, jeu.getModeJeu());
    }

}
