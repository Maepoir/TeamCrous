package arcanor.iu.graphique;

import javax.swing.*;
import java.awt.*;
import java.util.*;
import arcanor.iu.console.MenuTxt;
import arcanor.iu.console.PlateauTxt;
import arcanor.modele.*;

/**
 * represente graphiquement le plateau de jeu
 *
 * @author G.Renault, M.Poiré, S.Bay, M.Racinne-Divet
 */
class Plateau extends JPanel {

    private Pion lePionChoisi;
    private boolean etat = false;

    Plateau(arcanor.modele.Plateau plateau) {
        initComponents(plateau);
    }

    private void initComponents(arcanor.modele.Plateau plateau) {
        setLayout(new GridLayout(8,7));
        for (int i = 0; i < 8; i++) {
            for (int j = 0; j < 7; j++) {
                if (plateau.getPion(i,j) == null) {
                    this.add(new Case(i,j, plateau));
                } else {
                    this.add(new Case(plateau.getPion(i,j), plateau));
                }
            }
        }


    }



}
