package arcanor.iu.graphique;

import arcanor.controleur.graphique.PlateauEcout;

import javax.swing.*;
import java.awt.*;

/**
 * represente graphiquement le plateau de jeu
 *
 * @author G.Renault, M.Poiré, S.Bay, M.Racinne-Divet
 */
class Plateau extends JPanel {

    Plateau(arcanor.modele.Plateau plateau, MenuFen menu) {
        initComposantes(plateau, menu);
    }

    private void initComposantes(arcanor.modele.Plateau plateau, MenuFen menu) {
        setLayout(new GridLayout(8, 7, 0, 0));
        for (int i = 0; i < 8; i++) {
            JPanel pan = new JPanel();
            pan.setLayout(new FlowLayout(FlowLayout.LEFT, 0, 0));
            for (int j = 0; j < 7; j++) {
                JPanel sousPan = new JPanel();
                sousPan.setLayout(new FlowLayout(FlowLayout.LEFT, 0, 0));
                if (plateau.getPion(i, j) == null) {
                    sousPan.add(new Case());
                } else {
                    sousPan.add(new Case(plateau.getPion(i, j)));
                    sousPan.addMouseListener(new PlateauEcout(menu, plateau.getPion(i, j)));
                }
                sousPan.setEnabled(true);
                pan.add(sousPan);
            }
            add(pan);
        }
    }


}
