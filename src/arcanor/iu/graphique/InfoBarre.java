package arcanor.iu.graphique;

import arcanor.modele.Jeu;
import arcanor.modele.Joueur;

import javax.swing.*;
import java.awt.*;

/**
 * represente graphiquement une barre d'info pour savoir qui à la main sur le jeu
 *
 * @author G.Renault, M.Poiré, S.Bay, M.Racinne-Divet
 */
public class InfoBarre extends JPanel {

    private Jeu jeu;
    private JLabel joueurActuel;
    private JLabel nomJoueurs;

    InfoBarre(Jeu jeu) {
        this.jeu = jeu;
        initComponents();
    }

    private void initComponents() {
        setLayout(new GridLayout(2,1));

        nomJoueurs = new JLabel();
        nomJoueurs.setText("Cette partie oppose " + this.jeu.getJoueur1().getNom() + " a " + this.jeu.getJoueur2().getNom() + ".");

        joueurActuel = new JLabel();
        joueurActuel.setText("C'est au tour de " + this.jeu.getaLaMain().getNom() + " de jouer !");
        add(nomJoueurs);
        add(joueurActuel);
    }

    public void setText (Joueur j){
        this.joueurActuel.setText("C'est au tour de " + j.getNom() + "de joueur !");
    }

    public void messageVictoire (Joueur j){
        remove(this.nomJoueurs);
        this.joueurActuel.setText("Victoire de " + j.getNom() + " !");
        this.joueurActuel.setFont(new Font("Arial", Font.PLAIN, 100));
    }

}
