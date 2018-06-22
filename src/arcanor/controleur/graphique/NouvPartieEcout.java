package arcanor.controleur.graphique;

import arcanor.iu.graphique.MenuFen;
import arcanor.modele.Jeu;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class NouvPartieEcout implements ActionListener {

    private MenuFen menu;

    /**
     * Constructeur de l'écouteur
     * @param menu La fenêtre qui utilise cet écouteur
     */
    public NouvPartieEcout (MenuFen menu){
        this.menu = menu;
    }

    /**
     * Ecoute le bouton pour créer une nouvelle partie
     * @param e l'évènement à traiter
     */
    public void actionPerformed(ActionEvent e) {
        this.menu.actionJoueur();
    }

}
