package arcanor.controleur.graphique;

import arcanor.iu.graphique.*;
import arcanor.modele.*;

import java.awt.event.*;
import java.awt.*;

public class MenuChargerEcout implements ActionListener {

    private MenuFen menu;
    private MenuCharger menuC;

    public MenuChargerEcout(MenuFen menu, MenuCharger menuC){
      this.menu = menu;
      this.menuC = menuC;
    }

    public void actionPerformed(ActionEvent e){
      String nomSauv;
      nomSauv = menuC.getNomSauv().getText();
      Jeu jeu = Jeu.chargerJeu(nomSauv);
    }
}
