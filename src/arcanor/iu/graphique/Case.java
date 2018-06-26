package arcanor.iu.graphique;

import arcanor.modele.Couleur;
import arcanor.modele.Plateau;

import javax.imageio.ImageIO;
import javax.swing.*;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

/**
 * represente graphiquement un pion du jeu
 *
 * @author G.Renault, M.Poiré, S.Bay, M.Racinne-Divet
 */
public class Case extends JPanel {

    /**
     * Constructeur pour une case vide
     */
    public Case() {
        try {
            setLayout(new FlowLayout(FlowLayout.CENTER, 0, 0));
            BufferedImage caseM = ImageIO.read(new File("../doc/caseM.png"));
            add(new JLabel(new ImageIcon(caseM)));
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    /**
     * Constructeur pour une case avec un pion
     * @param lePion le pion présent dans la case
     */
    public Case(arcanor.modele.Pion lePion) {
        try {
            setLayout(new FlowLayout(FlowLayout.TRAILING, 0, 0));
            BufferedImage blanc1 = ImageIO.read(new File("../doc/blanc1.png"));
            BufferedImage blanc2 = ImageIO.read(new File("../doc/blanc2.png"));
            BufferedImage blanc3 = ImageIO.read(new File("../doc/blanc3.png"));
            BufferedImage blanc4 = ImageIO.read(new File("../doc/blanc4.png"));
            BufferedImage noir1 = ImageIO.read(new File("../doc/noir1.png"));
            BufferedImage noir2 = ImageIO.read(new File("../doc/noir2.png"));
            BufferedImage noir3 = ImageIO.read(new File("../doc/noir3.png"));
            BufferedImage noir4 = ImageIO.read(new File("../doc/noir4.png"));
            if (lePion.getLeJoueur().getColor().equals(Couleur.BLANC)) {
                switch (lePion.getTAILLE()) {
                    case 1:
                        add(new JLabel(new ImageIcon(blanc1)));
                        break;
                    case 2:
                        add(new JLabel(new ImageIcon(blanc2)));
                        break;
                    case 3:
                        add(new JLabel(new ImageIcon(blanc3)));
                        break;
                    case 4:
                        add(new JLabel(new ImageIcon(blanc4)));
                        break;
                }
            } else {
                switch (lePion.getTAILLE()) {
                    case 1:
                        add(new JLabel(new ImageIcon(noir1)));
                        break;
                    case 2:
                        add(new JLabel(new ImageIcon(noir2)));
                        break;
                    case 3:
                        add(new JLabel(new ImageIcon(noir3)));
                        break;
                    case 4:
                        add(new JLabel(new ImageIcon(noir4)));
                        break;
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
