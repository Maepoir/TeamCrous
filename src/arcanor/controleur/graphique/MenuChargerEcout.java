package arcanor.controleur.graphique;

import arcanor.iu.graphique.MenuCharger;
import arcanor.iu.graphique.MenuFen;
import arcanor.modele.Jeu;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class MenuChargerEcout implements ActionListener {

    private MenuCharger menuC;

    public MenuChargerEcout(MenuCharger menuC) {
        this.menuC = menuC;
    }

    public void actionPerformed(ActionEvent e) {
        String nomSauv;
        nomSauv = menuC.getNomSauv().getText();
        Jeu.chargerJeu(nomSauv);
    }
}
