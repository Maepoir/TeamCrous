package arcanor.controleur.graphique;

import arcanor.iu.graphique.MenuJoueur;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class NomJoueurEcout implements ActionListener {

    private MenuJoueur menu;
    private int numJoueur;

    public NomJoueurEcout (MenuJoueur menu, int numJoueur){
        this.menu = menu;
    }

    /**
     * Recupere le nom du joueur
     * @param e
     */
    public void actionPerformed(ActionEvent e) {
        if(numJoueur == 1){
            this.menu.setNomJoueur1(this.menu.getJ1().getText());
        }
        else if(numJoueur == 2){
            this.menu.setNomJoueur2(this.menu.getJ2().getText());
        }
    }

}
