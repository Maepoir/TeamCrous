package arcanor.iu.graphique;

import arcanor.modele.Jeu;
import arcanor.modele.Joueur;

import javax.swing.*;
import java.awt.*;

/**
 * represente graphiquement une barre d'info pour savoir qui à la main sur le jeu
 *
 * @author M.Poiré, S.Bay
 */
public class InfoBarre extends JPanel {

    private Jeu jeu;
    private JLabel joueurActuel;
    private JLabel nomJoueurs;

    /**
     * Constructeur de la barre d'info présente en bas de la fenetre de jeu
     *
     * @param jeu Le jeu sur lequel la barre donne ses infos
     */
    InfoBarre(Jeu jeu) {
        this.jeu = jeu;
        initComposants();
    }

    /**
    * permet d'initialiser tous les composants du panel graphique
    */
    private void initComposants() {
        setLayout(new GridLayout(2, 1));

        nomJoueurs = new JLabel();
        nomJoueurs.setText("Cette partie oppose " + this.jeu.getJoueur1().getNom() + " a " + this.jeu.getJoueur2().getNom() + ".");

        joueurActuel = new JLabel();
        joueurActuel.setText("C'est au tour de " + this.jeu.getaLaMain().getNom() + " de jouer !");
        add(nomJoueurs);
        add(joueurActuel);
        setBackground(new Color(45,80,150));
    }

    /**
    * permet de modifier le texte de la barre d'état
    *
    * @param j le joueur qui prend la main sur le jeu */
    public void setText(Joueur j) {
        this.joueurActuel.setText("C'est au tour de " + j.getNom() + " de jouer !");
    }

    /**
    * permet de modifier le texte de la barre d'état
    *
    * @param msg le nouveau message à afficher sur la barre */
    public void setText(String msg) {
        this.joueurActuel.setText(msg);
    }

    /**
    * permet d'afficher le message de victoire
    *
    * @param j le joueur qui a gagné */
    public void messageVictoire(Joueur j) {
        remove(this.nomJoueurs);
        this.joueurActuel.setText("Victoire de " + j.getNom() + " !");
        this.joueurActuel.setFont(new Font("Arial", Font.PLAIN, 60));
    }

}
