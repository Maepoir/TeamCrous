package arcanor.iu.graphique;

import arcanor.controleur.graphique.MenuChargerEcout;

import javax.swing.*;
import java.awt.*;

/**
 * permet de gérer graphiquement le chargement d'une partie de jeu
 *
 * @author M.Poiré, S.Bay
 */
public class MenuCharger extends JPanel {

    private JTextField text;
    private MenuFen menu;

    /**
    * Constructeur
    *
    * @param menu la fenetre sur laquelle sera affichée le menu de chargement
    */
    MenuCharger(MenuFen menu) {
        this.menu = menu;
        initComposants();
    }

    /**
    * initialise tous les composants du panel
    */
    private void initComposants() {
        JLabel nomS = new JLabel("Entrer le nom de la sauvegarde :", SwingConstants.CENTER);
        this.text = new JTextField();
        JButton valider = new JButton("Valider");
        JPanel vide = new JPanel();
        JPanel vide2 = new JPanel();
        JPanel demande = new JPanel();
        demande.setLayout(new GridLayout(4, 1, 10, 10));
        demande.add(vide2);
        demande.add(nomS);
        demande.add(text);
        demande.add(vide);

        setLayout(new BorderLayout());
        add(demande, "Center");
        add(valider, "South");

        valider.addActionListener(new MenuChargerEcout(this));
    }

    /**
    * permet d'accéder au nom de la sauvegarde
    *
    * @return le nom de sauvegarde saisi par l'utilisateur
    */
    public JTextField getNomSauv() {
        return this.text;
    }

    /**
    * permet d'accéder à la fenêtre d'affichage
    *
    * @return la fenetre d'affichage
    */
    public MenuFen getMenu (){
        return this.menu;
    }
}
