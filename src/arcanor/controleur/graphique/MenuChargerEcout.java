package arcanor.controleur.graphique;

import arcanor.iu.graphique.MenuCharger;
import arcanor.iu.graphique.MenuFen;
import arcanor.modele.Jeu;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class MenuChargerEcout implements ActionListener {

    private MenuFen menu;
    private MenuCharger menuC;

    public MenuChargerEcout(MenuFen menu, MenuCharger menuC) {
        this.menu = menu;
        this.menuC = menuC;
    }

    public void actionPerformed(ActionEvent e) {
        String nomSauv;
        nomSauv = menuC.getNomSauv().getText();
        Jeu jeu = Jeu.chargerJeu(nomSauv);
    }
}
