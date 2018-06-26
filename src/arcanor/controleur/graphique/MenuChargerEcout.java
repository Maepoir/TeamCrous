package arcanor.controleur.graphique;

import arcanor.iu.graphique.MenuCharger;
import arcanor.iu.graphique.MenuFen;
import arcanor.modele.Jeu;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import static arcanor.modele.Jeu.chargerJeu;

/**
 * Ecouteur gérant le chargement d'une partie
 *
 * @author M. POIRE  S. BAY
 */
public class MenuChargerEcout implements ActionListener {

    private MenuCharger menuC;

    /**
     * Constructeur
     *
     * @param menuC le menu a gérer
     */
    public MenuChargerEcout(MenuCharger menuC) {
        this.menuC = menuC;
    }

    /**
     * Gère les différentes actions du menu de chargement
     *
     * @param e l'évènement à gérer
     */
    public void actionPerformed(ActionEvent e) {
        String nomSauv;
        nomSauv = menuC.getNomSauv().getText();
        Jeu jeu = Jeu.chargerJeu(nomSauv);
        menuC.getMenu().actionNouvPartie(jeu.getJoueur1(),jeu.getJoueur2(),jeu.getIAPresente());
    }
}
