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
        try {
            BufferedImage caseM = ImageIO.read(new File("../doc/caseM.png"));
            setLayout(new GridLayout(8,7));
            for(int i = 0; i < 56; i++){
                add(new JLabel(new ImageIcon(caseM)));
            }
        } catch (IOException e) {
            e.printStackTrace();
        }

    }

}
