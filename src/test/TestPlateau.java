package test;

import arcanor.modele.*;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class TestPlateau {

    @Test
    public void testDeplacerPion() {

        Plateau plat = new Plateau(new JoueurHumain("Robert", Couleur.BLANC), new IA("JeanneAuSecours", Couleur.NOIR, 1));
        Pion p = new Pion(2, false, null, 0, 0, null, 1);
        plat.deplacerPion(p, 0, false);
        assertEquals(p, plat.getPion(0, 0));
    }

    @Test
    public void testManger() {

        Pion p1 = new Pion(2, false, null, 0, 0, null, 1);
        Pion p2 = new Pion(2, false, null, 0, 0, null, 2);
        Plateau plat = new Plateau(new JoueurHumain("Robert", Couleur.BLANC), new IA("JeanneAuSecours", Couleur.NOIR, 1));
        plat.manger(p1, p2);
        assertEquals(p2, p1.getAMange());
        assertEquals(p1.getAMange().equals(p2), p2.getEstMange());
    }

    @Test
    public void testDeplacementsPossibles() {
        Pion p = new Pion(2, false, null, 1, 1, null, 1);
        Plateau plat = new Plateau(new JoueurHumain("Robert", Couleur.BLANC), new IA("JeanneAuSecours", Couleur.NOIR, 1));
        plat.deplacerPion(p, 0, false);
        int[][] deplacements;
        int[][] resultat = new int[4][2];
        resultat[0][0] = 3;
        resultat[0][1] = 3;
        resultat[1][0] = 3;
        resultat[1][1] = 2;
        resultat[2][0] = 3;
        resultat[2][1] = 1;
        resultat[3][0] = 2;
        resultat[3][1] = 3;
        deplacements = plat.deplacementPossibles(p);
        assertEquals(resultat[0][0], deplacements[0][0]);
        assertEquals(resultat[0][1], deplacements[0][1]);
        assertEquals(resultat[1][0], deplacements[1][0]);
        assertEquals(resultat[1][1], deplacements[1][1]);
        assertEquals(resultat[2][0], deplacements[2][0]);
        assertEquals(resultat[2][1], deplacements[2][1]);
        assertEquals(resultat[3][0], deplacements[3][0]);
        assertEquals(resultat[3][1], deplacements[3][1]);

        plat.deplacerPion(p, 4, false);
        resultat = new int[4][2];
        resultat[0][0] = 1;
        resultat[0][1] = 1;
        resultat[1][0] = 1;
        resultat[1][1] = 0;
        resultat[2][0] = -1;
        resultat[2][1] = -1;
        resultat[3][0] = 0;
        resultat[3][1] = 1;
        deplacements = plat.deplacementPossibles(p);
        assertEquals(resultat[0][0], deplacements[0][0]);
        assertEquals(resultat[0][1], deplacements[0][1]);
        assertEquals(resultat[1][0], deplacements[1][0]);
        assertEquals(resultat[1][1], deplacements[1][1]);
        assertEquals(resultat[2][0], deplacements[2][0]);
        assertEquals(resultat[2][1], deplacements[2][1]);
        assertEquals(resultat[3][0], deplacements[3][0]);
        assertEquals(resultat[3][1], deplacements[3][1]);

    }
}
