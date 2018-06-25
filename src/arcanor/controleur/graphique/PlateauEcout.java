package arcanor.controleur.graphique;

import arcanor.iu.graphique.Case;
import arcanor.modele.Pion;
import arcanor.modele.Plateau;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

public class PlateauEcout implements MouseListener {

    private Plateau plateau;
    private Pion pion;

    public PlateauEcout(Plateau plateau) {
        this.plateau = plateau;
    }

    public PlateauEcout(Plateau plateau, Pion pion) {
        this.plateau = plateau;
        this.pion = pion;
    }

    public void mouseClicked(MouseEvent e) {
        ((Case) e.getSource()).getLeX();
        ((Case) e.getSource()).getLeY();
    }

    public void mouseEntered(MouseEvent e) {
//    System.out.println("mouse entered");
    }

    public void mouseExited(MouseEvent e) {
//    System.out.println("mouse exited");
    }

    public void mousePressed(MouseEvent e) {
//        System.out.println("mouse pressed");
    }

    public void mouseReleased(MouseEvent e) {
//        System.out.println("mouse released");
    }
}
