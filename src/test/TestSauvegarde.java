package test;

import arcanor.modele.Couleur;
import arcanor.modele.Jeu;
import arcanor.modele.Joueur;
import arcanor.modele.JoueurHumain;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class TestSauvegarde {

    @Test
    public void testSauvegarde() {
        String chemin = "../sauvegarde/save1";
        Joueur j1 = new JoueurHumain("Simon", Couleur.BLANC);
        Joueur j2 = new JoueurHumain("Simon", Couleur.NOIR);
        Jeu jeu = new Jeu(j1, j2, false, false);
        jeu.sauvegarderJeu(chemin);
        Jeu copieJeu;
        copieJeu = Jeu.chargerJeu(chemin);
        assertEquals(copieJeu.getJoueur1().getNom(), jeu.getJoueur1().getNom());
    }

}
