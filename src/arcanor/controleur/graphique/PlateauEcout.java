package arcanor.controleur.graphique;


import arcanor.iu.graphique.MenuFen;
import arcanor.modele.Pion;
import arcanor.modele.Plateau;

import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;


public class PlateauEcout implements MouseListener {


    private Plateau plateau;

    private MenuFen menu;

    private Pion lePion;


    public PlateauEcout(Plateau plateau, MenuFen menu, Pion lePion) {

        this.plateau = plateau;

        this.menu = menu;

        this.lePion = lePion;

    }


    public void mouseClicked(MouseEvent e) {
        this.menu.getJeu().setLePion(this.lePion);
    }


    public void mouseEntered(MouseEvent e) {

    }


    public void mouseExited(MouseEvent e) {

    }


    public void mousePressed(MouseEvent e) {


    }


    public void mouseReleased(MouseEvent e) {

    }


}