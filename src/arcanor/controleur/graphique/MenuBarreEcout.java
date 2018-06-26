package arcanor.controleur.graphique;

import arcanor.Sauvegarde;
import arcanor.iu.graphique.MenuBarre;
import arcanor.modele.Jeu;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/**
 * Ecouteur gérant le menu latéral
 *
 * @author M. POIRE S. BAY
 */
public class MenuBarreEcout implements ActionListener {

    private MenuBarre menuBarre;
    private Jeu jeu;

    /**
     * Constructeur
     *
     * @param mB  Le menu latéral à écouter
     * @param jeu
     */
    public MenuBarreEcout(MenuBarre mB, Jeu jeu) {
        this.menuBarre = mB;
        this.jeu = jeu;
    }

    /**
     * Gère les différentes actions possibles dans le menu latéral
     *
     * @param e l'évènement à gérer
     */
    public void actionPerformed(ActionEvent e) {
        if (e.getSource().equals(this.menuBarre.getSauvegarder())) {
            Sauvegarde.sauvegarder(this.menuBarre.getChemin().getText(), this.jeu);
            this.menuBarre.getInfos().setText("Sauvegarde correctement effectuee");
        } else if (e.getSource().equals(this.menuBarre.getQuitter())) {
            System.exit(0);
        } else if (e.getSource().equals(this.menuBarre.getLiberer())) {
            this.jeu.setEtat();
        } else if (e.getSource().equals(this.menuBarre.getHautGauche())) {
            this.jeu.setDeplacement(0);
        } else if (e.getSource().equals(this.menuBarre.getHaut())) {
            this.jeu.setDeplacement(1);
        } else if (e.getSource().equals(this.menuBarre.getHautDroite())) {
            this.jeu.setDeplacement(2);
        } else if (e.getSource().equals(this.menuBarre.getDroite())) {
            this.jeu.setDeplacement(3);
        } else if (e.getSource().equals(this.menuBarre.getBasDroite())) {
            this.jeu.setDeplacement(4);
        } else if (e.getSource().equals(this.menuBarre.getBas())) {
            this.jeu.setDeplacement(5);
        } else if (e.getSource().equals(this.menuBarre.getBasGauche())) {
            this.jeu.setDeplacement(6);
        } else if (e.getSource().equals(this.menuBarre.getGauche())) {
            this.jeu.setDeplacement(7);
        } else if (e.getSource().equals(this.menuBarre.getValider())) {
            this.menuBarre.deplacer();
        }
    }

}
