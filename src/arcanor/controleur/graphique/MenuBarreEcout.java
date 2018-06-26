package arcanor.controleur.graphique;

import arcanor.Sauvegarde;
import arcanor.iu.graphique.MenuBarre;
import arcanor.modele.Jeu;
import com.sun.glass.ui.Menu;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class MenuBarreEcout implements ActionListener {

    private MenuBarre menuBarre;
    private Jeu jeu;

    public MenuBarreEcout (MenuBarre mB, Jeu jeu){
        this.menuBarre = mB;
        this.jeu = jeu;
    }

    public void actionPerformed(ActionEvent e) {
        if(e.getSource().equals(this.menuBarre.getSauvegarder())){
            Sauvegarde.sauvegarder(this.menuBarre.getChemin().getText(),this.jeu);
            this.menuBarre.getInfos().setText("Sauvegarde correctement effectuee");
        }
        else if (e.getSource().equals(this.menuBarre.getQuitter())){
            System.exit(0);
        }
        else if (e.getSource().equals(this.menuBarre.getLiberer())){

        }
    }

}
