package arcanor.iu.graphique;

import javax.swing.*;
import java.awt.*;
import java.util.*;

import arcanor.controleur.graphique.PlateauEcout;
import arcanor.iu.console.MenuTxt;
import arcanor.iu.console.PlateauTxt;
import arcanor.modele.*;

/**
 * represente graphiquement le plateau de jeu
 *
 * @author G.Renault, M.Poiré, S.Bay, M.Racinne-Divet
 */
public class Plateau extends JPanel {

    private Pion lePionChoisi;
    private boolean etat = false;

    Plateau(arcanor.modele.Plateau plateau, MenuFen menu) {
        initComponents(plateau, menu);
    }

    private void initComponents(arcanor.modele.Plateau plateau, MenuFen menu) {
        setLayout(new GridLayout(8,7,0,0));
        for (int i = 0; i < 8; i++) {
            JPanel pan = new JPanel();
            pan.setLayout(new FlowLayout(0,0,0));
            for (int j = 0; j < 7; j++) {
                JPanel sousPan = new JPanel();
                sousPan.setLayout(new FlowLayout(0,0,0));
                if (plateau.getPion(i,j) == null) {
                    sousPan.add(new Case(i,j, plateau));
                } else {
                    sousPan.add(new Case(plateau.getPion(i,j), plateau));
                    sousPan.addMouseListener(new PlateauEcout(plateau, menu, plateau.getPion(i,j)));
                }
                sousPan.setEnabled(true);
                pan.add(sousPan);
            }
            add(pan);
        }
    }



}
