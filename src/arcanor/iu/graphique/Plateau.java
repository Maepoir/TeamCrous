package arcanor.iu.graphique;

import javax.swing.*;
import java.awt.*;
import java.util.*;
import arcanor.modele.*;

/**
 * represente graphiquement le plateau de jeu
 *
 * @author G.Renault, M.Poiré, S.Bay, M.Racinne-Divet
 */
class Plateau extends JPanel {

    private ArrayList<arcanor.iu.graphique.Pion> pionsGraphique;

    Plateau(arcanor.modele.Plateau plateau) {
        initComponents(plateau);
    }

    private void initComponents(arcanor.modele.Plateau plateau) {
        this.pionsGraphique = new ArrayList<arcanor.iu.graphique.Pion>();
        setLayout(new GridLayout(8, 7, 0, 0));
        for (int i = 0; i < 8; i++) {
            for (int j = 0; j < 7; j++) {
                if (plateau.getPion(i, j) == null) {
                    add(new Pion(i,j));
                    pionsGraphique.add(new Pion(i,j));
                } else {
                    pionsGraphique.add(new Pion(plateau.getPion(i, j).getTAILLE(), plateau.getPion(i, j).getLeJoueur().getColor(),i,j));
                    add(new Pion(plateau.getPion(i, j).getTAILLE(), plateau.getPion(i, j).getLeJoueur().getColor(),i,j));
                }
            }
        }

    }

    /**permet d'accéder à la liste de pions */
    public ArrayList<arcanor.iu.graphique.Pion> getListePion(){return this.pionsGraphique;}

}
