package arcanor.iu.graphique;

import javax.imageio.ImageIO;
import javax.swing.*;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

/**
 * represente une case du plateau
 *
 * @author G.Renault, M.Poiré, S.Bay, M.Racinne-Divet
 */
class Case extends JPanel {

    Case() {
        try {
            setLayout(new FlowLayout(0, 0, 0));
            BufferedImage caseM = ImageIO.read(new File("../doc/caseM.png"));
            add(new JLabel(new ImageIcon(caseM)));
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

}
