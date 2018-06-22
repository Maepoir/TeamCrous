package arcanor.iu.graphique;

import arcanor.modele.Jeu;

import javax.swing.*;
import java.awt.*;

/** affiche graphiquement la fenetre de jeu avec le plateau et les pions
* @author G.Renault, M.Poiré, S.Bay, M.Racinne-Divet */
public class JeuFen extends JPanel {

    private Plateau plateau;

    public JeuFen (Jeu jeu){
        this.plateau = new Plateau(jeu.getLePlateau());
        setLayout(new BorderLayout());
        add(this.plateau,"Center");
    }

}
