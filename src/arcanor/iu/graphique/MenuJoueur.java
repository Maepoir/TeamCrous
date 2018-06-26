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

    private JLabel titreJeu;
    private JLabel nomJ1;
    private JLabel nomJ2;
    private JTextField j1;
    private JTextField j2;
    private JLabel choixIA;
    private JRadioButton IAoui;
    private JRadioButton IAnon;
    private JButton valider;
    private JPanel choixBouton;
    private JPanel boutons;

    private String nomJoueur1;
    private String nomJoueur2;

    private MenuFen menu;

    MenuJoueur(MenuFen menu) {
        this.menu = menu;
        initComponents();
    }

    private void initComponents() {
        this.nomJ1 = new JLabel("Nom du joueur 1 :", SwingConstants.CENTER);
        this.nomJ2 = new JLabel("Nom du joueur 2 :", SwingConstants.CENTER);

        this.j1 = new JTextField();
        this.j1.addActionListener(new MenuJoueurEcout(this.menu, this));
        this.j2 = new JTextField();
        this.j2.addActionListener(new MenuJoueurEcout(this.menu, this));

        this.choixIA = new JLabel("Jouer contre l'IA ?", SwingConstants.CENTER);
        this.IAoui = new JRadioButton("oui");
        this.IAoui.addActionListener(new MenuJoueurEcout(this.menu, this));
        this.IAnon = new JRadioButton("non");
        this.IAnon.addActionListener(new MenuJoueurEcout(this.menu, this));
        this.IAnon.doClick();

        ButtonGroup bg = new ButtonGroup();
        bg.add(this.IAoui);
        bg.add(this.IAnon);
        this.choixBouton = new JPanel();
        this.choixBouton.add(this.IAoui);
        this.choixBouton.add(this.IAnon);

        this.boutons = new JPanel();
        this.boutons.setLayout(new GridLayout(3, 2, 10, 10));
        this.boutons.add(this.nomJ1);
        this.boutons.add(this.j1);
        this.boutons.add(this.nomJ2);
        this.boutons.add(this.j2);
        this.boutons.add(this.choixIA);
        this.boutons.add(this.choixBouton);

        this.valider = new JButton("Valider");
        this.valider.addActionListener(new MenuJoueurEcout(this.menu, this));

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

    public String getNomJoueur2() {
        return nomJoueur2;
    }

    public void setNomJoueur1(String nomJoueur1) {
        this.nomJoueur1 = nomJoueur1;
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
