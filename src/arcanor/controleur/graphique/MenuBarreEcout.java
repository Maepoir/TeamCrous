package arcanor.controleur.graphique;

import arcanor.iu.graphique.MenuBarre;
import com.sun.glass.ui.Menu;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class MenuBarreEcout implements ActionListener {

    private MenuBarre menuBarre;

    public MenuBarreEcout (MenuBarre mB){
        this.menuBarre = mB;
    }

    public void actionPerformed(ActionEvent e) {
        if(e.getSource().equals(this.menuBarre.getSauvegarder())){

        }
        else if (e.getSource().equals(this.menuBarre.getQuitter())){
            System.exit(0);
        }
        else if (e.getSource().equals(this.menuBarre.getLiberer())){

        }
    }

}
