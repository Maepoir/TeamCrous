package arcanor.controleur.graphique;

import arcanor.iu.graphique.Case;
import arcanor.iu.graphique.MenuFen;
import arcanor.modele.Pion;
import arcanor.modele.Plateau;

import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

public class PlateauEcout implements MouseListener {

    private Plateau plateau;
    private boolean aUnPion;
    private Pion lePion;
    private int nextX;
    private int nextY;
    private MenuFen menu;

    public PlateauEcout(Plateau plateau, MenuFen menu) {
        this.plateau = plateau;
        this.menu = menu;
    }

    public void mouseClicked(MouseEvent e) {

    }

    public void mouseEntered(MouseEvent e) {
        setNextX(e.getXOnScreen());
        setNextY(e.getYOnScreen());
    }

    public void mouseExited(MouseEvent e) {
//    System.out.println("mouse exited");
    }

    public void mousePressed(MouseEvent e) {
        Case caseATraiter = ((Case) e.getSource());
        if (this.plateau.getPion(caseATraiter.getLeX(), caseATraiter.getLeY()) != null) {
            this.lePion = this.plateau.getPion(caseATraiter.getLeX(), caseATraiter.getLeY());
            aUnPion = true;
        }
    }

    public void mouseReleased(MouseEvent e) {
        System.out.println("5");
        if (aUnPion) {
            System.out.println("4");
            deplacement();
        }
    }

    private void setNextY(int nextY) {
        if (nextY >= 100 && nextY < 175) {
            this.nextY = 0;
        } else if (nextY >= 175 && nextY < 250) {
            this.nextY = 1;
        } else if (nextY >= 250 && nextY < 325) {
            this.nextY = 2;
        } else if (nextY >= 325 && nextY < 400) {
            this.nextY = 3;
        } else if (nextY >= 400 && nextY < 475) {
            this.nextY = 4;
        } else if (nextY >= 475 && nextY < 550) {
            this.nextY = 5;
        } else if (nextY >= 550 && nextY < 625) {
            this.nextY = 6;
        } else if (nextY >= 625 && nextY < 700) {
            this.nextY = 7;
        }
    }

    private void setNextX(int nextX) {
        if (nextX >= 0 && nextX < 75) {
            this.nextX = 0;
        } else if (nextX >= 75 && nextX < 150) {
            this.nextX = 1;
        } else if (nextX >= 150 && nextX < 225) {
            this.nextX = 2;
        } else if (nextX >= 225 && nextX < 300) {
            this.nextX = 3;
        } else if (nextX >= 300 && nextX < 375) {
            this.nextX = 4;
        } else if (nextX >= 375 && nextX < 450) {
            this.nextX = 5;
        } else if (nextX >= 450 && nextX < 525) {
            this.nextX = 6;
        } else if (nextX >= 525 && nextX < 600) {
            this.nextX = 7;
        }
    }

    private void deplacement() {
        System.out.println("1");
        this.aUnPion = false;
        if (this.lePion.getX() != this.nextX || this.lePion.getY() != this.nextY) {
            System.out.println("2");
            int[][] tab = this.plateau.deplacementPossibles(this.lePion);
            for (int i = 0; i < 8; i++) {
                if (tab[i][0] == this.nextY && tab[i][1] == this.nextX) {
                    this.plateau.deplacerPion(lePion, i, false);
                    this.menu.actualise(this.plateau);
                    break;
                }
            }
        }
    }
}
