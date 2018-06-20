package arcanor;

import arcanor.iu.console.PlateauTxt;
import arcanor.modele.*;

import java.awt.*;

public class Test {

    public static void main (String [] args){
        Joueur j1 = new JoueurHumain("j1", Couleur.BLANC);
        Joueur j2 = new IA("j2", Couleur.NOIR, 0);
        Plateau p = new Plateau();
        p.initPions(j1,j2);
        PlateauTxt pTxt = new PlateauTxt(p,j1,j2);
        pTxt.afficherPlateau();
    }
}
