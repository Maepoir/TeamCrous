package arcanor.controleur.graphique;


import arcanor.iu.graphique.MenuFen;
import arcanor.modele.Pion;

import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

/**
 * Ecouteur permettant de gérer le plateau
 *
 * @author POIRE M.  BAY S.
 */
public class PlateauEcout implements MouseListener {

    private MenuFen menu;

    private Pion lePion;

    /**
     * Constructeur
     *
     * @param menu   le menu associé au plateau
     * @param lePion le pion qui va être ecouté
     */
    public PlateauEcout(MenuFen menu, Pion lePion) {

        this.menu = menu;

        this.lePion = lePion;

    }

    /**
     * Permet de sélectionner un pion
     *
     * @param e l'évènement à gérer
     */
    public void mouseClicked(MouseEvent e) {
        this.menu.getJeu().setLePion(this.lePion);
    }

    /**
     * Non utilisé
     *
     * @param e non utilisé
     */
    public void mouseEntered(MouseEvent e) {

    }

    /**
     * Non utilisé
     *
     * @param e non utilisé
     */
    public void mouseExited(MouseEvent e) {

    }

    /**
     * Non utilisé
     *
     * @param e non utiisé
     */
    public void mousePressed(MouseEvent e) {


    }

    /**
     * Non utilisé
     *
     * @param e non utilisé
     */
    public void mouseReleased(MouseEvent e) {

    }


}