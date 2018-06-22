package arcanor.iu.graphique;

import arcanor.modele.Jeu;

import javax.swing.*;
import java.awt.*;

/** represente graphiquement une barre d'info pour savoir qui à la main sur le jeu
* @author G.Renault, M.Poiré, S.Bay, M.Racinne-Divet */
public class InfoBarre extends JPanel {

    private Jeu jeu;
    private JLabel nomJoueurs;
    private JLabel joueurActuel;

    public InfoBarre (Jeu jeu){
        this.jeu = jeu;
        initComponents();
    }

    private void initComponents (){
        setLayout(new FlowLayout());
        nomJoueurs = new JLabel();
        nomJoueurs.setText("Cette partie oppose " + this.jeu.getJoueur1().getNom() + " a " + this.jeu.getJoueur2().getNom() + ".");
        joueurActuel = new JLabel();
        joueurActuel.setText("C'est au tour de " + this.jeu.getaLaMain().getNom() + " de jouer !");
        add(nomJoueurs);
        add(joueurActuel);
    }
}
