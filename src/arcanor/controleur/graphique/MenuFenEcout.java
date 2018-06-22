package arcanor.controleur.graphique;

import java.awt.event.*;

import arcanor.iu.graphique.*;

/**
 * permet de mettre à l'écoute tous les boutons de l'application
 *
 * @author G.Renault, M.Poiré, S.Bay, M.Racinne-Divet
 */
public class MenuFenEcout implements ActionListener {

    private MenuFen menu;

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
        }
    }
}
