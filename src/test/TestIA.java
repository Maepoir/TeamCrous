package test;

import arcanor.modele.Couleur;
import arcanor.modele.IA;
import org.junit.Test;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;

public class TestIA {
    @Test
    public void testNom() {
        // Cas Normal : le nom entré est une chaine remplie
        IA ia = new IA("BAY", Couleur.BLANC, 1);
        String nom = "Pomme";
        ia.setNom("Pomme");
        assertEquals(nom, ia.getNom());

        // Cas Limite : le nom entré est une chaine vide
        ia = new IA("", Couleur.NOIR, 1);
        ia.setNom("Pomme");
        assertEquals(nom, ia.getNom());
    }

    @Test
    public void testColor() {
        // Cas Normal : la couleur est valide
        IA ia = new IA("Poiré", Couleur.BLANC, 1);
        Couleur color = Couleur.NOIR;
        ia.setColor(color);
        assertEquals(color, ia.getColor());
    }

    @Test
    public void testDifficulte() {
        IA ia = new IA("RENAULT", Couleur.BLANC, 0);
        ia.setDifficulte(1);
        assertEquals(1, ia.getDifficulte());
        ia.setDifficulte(-1);
        assertEquals(-1, ia.getDifficulte());
    }
}
