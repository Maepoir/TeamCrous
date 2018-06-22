package arcanor.controleur.graphique;

import arcanor.iu.graphique.MenuFen;
import arcanor.iu.graphique.MenuJoueur;
import arcanor.modele.Couleur;
import arcanor.modele.JoueurHumain;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class ValiderJoueursEcout implements ActionListener {

    private MenuFen menu;
    private MenuJoueur joueurs;

    public ValiderJoueursEcout (MenuFen menu,MenuJoueur joueurs){
        this.menu = menu;
        this.joueurs=joueurs;
    }

    public void actionPerformed(ActionEvent e) {
        this.menu.actionNouvPartie(new JoueurHumain(this.joueurs.getNomJoueur1(),Couleur.BLANC), new JoueurHumain("mae",Couleur.NOIR));
    }

}
