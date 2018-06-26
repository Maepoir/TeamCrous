package arcanor.controleur.graphique;

import arcanor.iu.graphique.MenuFen;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/**
 * permet de mettre à l'écoute tous les boutons du menu initial
 *
 * @author G.Renault, M.Poiré, S.Bay, M.Racinne-Divet
 */
public class MenuFenEcout implements ActionListener {

    private MenuFen menu;

    /**
     * Constructeur
     *
     * @param menu le menu a gérer
     */
    public MenuFenEcout(MenuFen menu) {
        this.menu = menu;
    }

    /**
     * permet de définir l'action à faire selon le bouton qui a été cliqué
     *
     * @param e la nature de l'action
     */
    public void actionPerformed(ActionEvent e) {
        if (e.getSource().equals(this.menu.getNouvPartie())) {
            this.menu.actionJoueur();
        } else if (e.getSource().equals(this.menu.getCharger())) {
            this.menu.actionChargement();
        } else if (e.getSource().equals(this.menu.getQuitter())) {
            System.exit(0);
        }
    }
}
