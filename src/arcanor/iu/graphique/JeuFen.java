package arcanor.iu.graphique;

import arcanor.modele.Jeu;

import javax.swing.*;
import java.awt.*;
import java.util.*;

/**
 * affiche graphiquement la fenetre de jeu avec le plateau et les pions
 *
 * @author G.Renault, M.Poiré, S.Bay, M.Racinne-Divet
 */
class JeuFen extends JPanel {

    private ArrayList<arcanor.iu.graphique.Pion> listePions;

    JeuFen(Jeu jeu) {
        Plateau plateau = new Plateau(jeu.getLePlateau());
        setLayout(new BorderLayout());
        add(plateau, "Center");
        this.listePions = plateau.getListePion();
    }

    /**permet d'accéder à listePions */
    public ArrayList<Pion> getPions(){return this.listePions;}

}
