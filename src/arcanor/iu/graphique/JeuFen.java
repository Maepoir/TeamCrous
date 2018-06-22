package arcanor.iu.graphique;
import arcanor.modele.Jeu;

import javax.swing.*;
import java.awt.*;
/** affiche graphiquement la fenetre de jeu avec le plateau et les pions
* @author G.Renault, M.Poiré, S.Bay, M.Racinne-Divet */
public class JeuFen extends JFrame {

    private Plateau plateau;

    public JeuFen (Jeu jeu){
        this.plateau = new Plateau(jeu.getLePlateau());
        setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        setTitle("Arcanor <3");
        getContentPane().setLayout(new BorderLayout());
        add(this.plateau,"Center");
        pack();
    }

}
