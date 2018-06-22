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
            BufferedImage blanc1 = ImageIO.read(new File("../doc/blanc1.png"));
            BufferedImage blanc2 = ImageIO.read(new File("../doc/blanc2.png"));
            BufferedImage blanc3 = ImageIO.read(new File("../doc/blanc3.png"));
            BufferedImage blanc4 = ImageIO.read(new File("../doc/blanc4.png"));
            BufferedImage noir1 = ImageIO.read(new File("../doc/noir1.png"));
            BufferedImage noir2 = ImageIO.read(new File("../doc/noir2.png"));
            BufferedImage noir3 = ImageIO.read(new File("../doc/noir3.png"));
            BufferedImage noir4 = ImageIO.read(new File("../doc/noir4.png"));
            setLayout(new GridLayout(8,7));
            for(int i = 0; i < plateau.lePlateau.length; i++){
                for(int j = 0; j < plateau.lePlateau[0].length; j++){
                    if(plateau.lePlateau[i][j]==null){
                        add(new JLabel(new ImageIcon(caseM)));
                    }
                    else if(plateau.lePlateau[i][j].getLeJoueur().equals(plateau.getJ1())){
                        switch (plateau.lePlateau[i][j].getTAILLE()){
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
                            default:
                                add(new JLabel(new ImageIcon(caseM)));
                        }
                    }
                    else{
                        switch (plateau.lePlateau[i][j].getTAILLE()){
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
                            default:
                                add(new JLabel(new ImageIcon(caseM)));
                        }
                    }
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        }

    }

}
