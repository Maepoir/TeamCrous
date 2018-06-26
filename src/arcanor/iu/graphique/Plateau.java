package arcanor.iu.graphique;

import arcanor.controleur.graphique.PlateauEcout;

import javax.swing.*;
import java.awt.*;

/**
 * represente graphiquement le plateau de jeu
 *
 * @author M.Poiré, S.Bay
 */
class Plateau extends JPanel {

    /**
    * Constructeur
    */
    Plateau(arcanor.modele.Plateau plateau, MenuFen menu) {
        initComposants(plateau, menu);
    }

    /**
    * permet d'initialiser les composants du plateau de jeu
    *
    * @param plateau le plateau de jeu du modèle avec le placement des pions
    * @param menu la fenetre qui permettra d'afficher le plateau
    */
    private void initComposants(arcanor.modele.Plateau plateau, MenuFen menu) {
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
                    if(!plateau.getPion(i,j).getEstMange()) {
                        sousPan.add(new Case(plateau.getPion(i, j)));
                        sousPan.addMouseListener(new PlateauEcout(menu, plateau.getPion(i, j)));
                    }
                    else{
                        sousPan.add(new Case());
                    }
                }
                sousPan.setEnabled(true);
                pan.add(sousPan);
            }
            add(pan);
        }
    }


}
