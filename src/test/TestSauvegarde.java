package test;
import static org.junit.Assert.*;
import org.junit.Test;
import arcanor.modele.*;

public class TestSauvegarde {

    @Test
    public void testSauvegarde() {
        String chemin = "../sauvegarde/save1";
        Joueur j1 = new JoueurHumain("Simon", Couleur.BLANC);
        Joueur j2 = new JoueurHumain("Simon", Couleur.NOIR);
        Jeu jeu = new Jeu(j1,j2,false, false);
        jeu.sauvegarderJeu(chemin);
        Jeu copieJeu = null;
        copieJeu.chargerJeu(chemin);
        assertEquals(copieJeu.getJoueur1().getNom(), jeu.getJoueur1().getNom());
        assertEquals(copieJeu.getLePlateau(), jeu.getLePlateau());
    }

}
