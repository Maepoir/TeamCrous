package arcanor.controleur.graphique;

import arcanor.iu.graphique.MenuFen;
import arcanor.iu.graphique.MenuJoueur;
import arcanor.modele.*;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/**
 * Ecouteur du menu gérant les joueurs
 *
 * @author M. POIRE  S. BAY
 */
public class MenuJoueurEcout implements ActionListener {

    private MenuFen menu;
    private MenuJoueur joueurs;
    private boolean joueurIA;

    /**
    * Constructeur
    *
    * @param menu le menu de lancement du jeu
    * @param joueurs le menu à gérer
    */
    public MenuJoueurEcout(MenuFen menu, MenuJoueur joueurs) {
        this.menu = menu;
        this.joueurs = joueurs;
        this.joueurIA = false;
    }

    /**
    * permet de définir l'action à faire selon le bouton qui a été cliqué
    * @param e la nature de l'action
    */
    public void actionPerformed(ActionEvent e) {
        if (e.getSource().equals(this.joueurs.getIAoui())) {
            this.joueurIA = true;
        } else if (e.getSource().equals(this.joueurs.getIAnon())) {
            this.joueurIA = false;
        } else if (e.getSource().equals(this.joueurs.getValider())) {
            this.joueurs.setNomJoueur1(this.joueurs.getJ1().getText());
            this.joueurs.setNomJoueur2(this.joueurs.getJ2().getText());
            Joueur j1 = new JoueurHumain(this.joueurs.getNomJoueur1(), Couleur.BLANC);
            Joueur j2;
            if (joueurIA) {
                j2 = new IA(this.joueurs.getNomJoueur2(), Couleur.NOIR, 1);
            } else {
                j2 = new JoueurHumain(this.joueurs.getNomJoueur2(), Couleur.NOIR);
            }
            this.menu.actionNouvPartie(j1,j2,joueurIA);
        }
    }

}
