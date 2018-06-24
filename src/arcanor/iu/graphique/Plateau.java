package arcanor.iu.graphique;

import javax.swing.*;
import java.awt.*;

/** represente graphiquement le plateau de jeu
* @author G.Renault, M.Poiré, S.Bay, M.Racinne-Divet */
public class Plateau extends JPanel {

    public Plateau (arcanor.modele.Plateau plateau){
        initComponents(plateau);
    }

    public void initComponents (arcanor.modele.Plateau plateau) {
        setLayout(new GridLayout(8,7,0,0));
        for(int i = 0; i < 8; i++){
            for(int j = 0; j < 7; j++) {
                if (plateau.getPion(i,j) == null) {
                    add(new Case());
                } else {
                    add(new Pion(plateau.getPion(i,j).getTAILLE(), plateau.getPion(i,j).getLeJoueur().getColor()));
                }
            }
        }
    }

}
