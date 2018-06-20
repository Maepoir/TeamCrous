package arcanor;

import arcanor.iu.console.PlateauTxt;
import arcanor.modele.*;

import java.awt.*;

public class Test {

    public static void main (String [] args){
        Joueur j1 = new Joueur("j1", new Color(255,12,255),true);
        Joueur j2 = new Joueur("j2", new Color(12,255,255), false);
        Plateau p = new Plateau();
        p.initPions(j1,j2);
        PlateauTxt pTxt = new PlateauTxt(p,j1,j2);
        pTxt.afficherPlateau();
    }
}
