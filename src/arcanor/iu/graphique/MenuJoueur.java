package arcanor.iu.graphique;

import arcanor.controleur.graphique.MenuJoueurEcout;

import javax.swing.*;
import java.awt.*;

/**
 * permet d'afficher graphiquement les choix de jeu disponibles lors du lancement
 * du jeu.
 *
 * @author G.Renault, M.Poiré, S.Bay, M.Racinne-Divet
 */
public class MenuJoueur extends JPanel {

    private JTextField j1;
    private JTextField j2;
    private JRadioButton IAoui;
    private JRadioButton IAnon;
    private JButton valider;

    private String nomJoueur1;
    private String nomJoueur2;

    private MenuFen menu;

    MenuJoueur(MenuFen menu) {
        this.menu = menu;
        initComposantes();
    }

    private void initComposantes() {
        MenuJoueurEcout ecouteur = new MenuJoueurEcout(this.menu, this);
        JLabel nomJ1 = new JLabel("Nom du joueur 1 :", SwingConstants.CENTER);
        JLabel nomJ2 = new JLabel("Nom du joueur 2 :", SwingConstants.CENTER);

        this.j1 = new JTextField();
        this.j1.addActionListener(new MenuJoueurEcout(this.menu, this));
        this.j2 = new JTextField();
        this.j2.addActionListener(ecouteur);

        JLabel choixIA = new JLabel("Jouer contre l'IA ?", SwingConstants.CENTER);
        this.IAoui = new JRadioButton("oui");
        this.IAoui.addActionListener(ecouteur);
        this.IAnon = new JRadioButton("non");
        this.IAnon.addActionListener(ecouteur);
        this.IAnon.doClick();

        ButtonGroup bg = new ButtonGroup();
        bg.add(this.IAoui);
        bg.add(this.IAnon);
        JPanel choixBouton = new JPanel();
        choixBouton.add(this.IAoui);
        choixBouton.add(this.IAnon);

        JPanel boutons = new JPanel();
        boutons.setLayout(new GridLayout(3, 2, 10, 10));
        boutons.add(nomJ1);
        boutons.add(this.j1);
        boutons.add(nomJ2);
        boutons.add(this.j2);
        boutons.add(choixIA);
        boutons.add(choixBouton);

        this.valider = new JButton("Valider");
        this.valider.addActionListener(ecouteur);

        setLayout(new BorderLayout());
        add(boutons, "Center");
        add(valider, "South");
    }

    public JTextField getJ1() {
        return this.j1;
    }

    public JTextField getJ2() {
        return this.j2;
    }

    public String getNomJoueur1() {
        return nomJoueur1;
    }

    public void setNomJoueur1(String nomJoueur1) {
        this.nomJoueur1 = nomJoueur1;
    }

    public String getNomJoueur2() {
        return nomJoueur2;
    }

    public void setNomJoueur2(String nomJoueur2) {
        this.nomJoueur2 = nomJoueur2;
    }

    public JButton getValider() {
        return this.valider;
    }

    public JRadioButton getIAoui() {
        return IAoui;
    }

    public JRadioButton getIAnon() {
        return IAnon;
    }

}
