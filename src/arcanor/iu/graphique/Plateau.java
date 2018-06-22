package arcanor.iu.graphique;

import javax.imageio.ImageIO;
import javax.swing.*;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

/** represente graphiquement le plateau de jeu
* @author G.Renault, M.Poiré, S.Bay, M.Racinne-Divet */
public class Plateau extends JPanel {

    public Plateau (arcanor.modele.Plateau plateau){
        initComponents(plateau);
    }

    public void initComponents (arcanor.modele.Plateau plateau) {
        setLayout(new GridLayout(8,7,0,0));
        for(int i = 0; i < plateau.lePlateau.length; i++){
            for(int j = 0; j < plateau.lePlateau[0].length; j++) {
                if (plateau.lePlateau[i][j] == null) {
                    add(new Case());
                } else {
                    add(new Pion(plateau.lePlateau[i][j].getTAILLE(), plateau.lePlateau[i][j].getLeJoueur().getColor()));
                }
            }
        }
    }

}
