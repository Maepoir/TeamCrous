package arcanor.iu.graphique;

import arcanor.modele.Jeu;

import javax.swing.*;
import java.awt.*;

/**
 * affiche graphiquement la fenetre de jeu avec le plateau et les pions
 *
 * @author G.Renault, M.Poiré, S.Bay, M.Racinne-Divet
 */
class JeuFen extends JPanel {

    JeuFen(Jeu jeu) {
        Plateau plateau = new Plateau(jeu.getLePlateau());
        setLayout(new BorderLayout());
        add(plateau, "Center");
    }

}
