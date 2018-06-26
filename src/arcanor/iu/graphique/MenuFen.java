package arcanor.iu.graphique;

import arcanor.controleur.graphique.MenuFenEcout;
import arcanor.modele.Jeu;
import arcanor.modele.Joueur;

import javax.swing.*;
import java.awt.*;

/**
 * affiche graphiquement le menu avec les options de jeu disponibles
 *
 * @author G.Renault, M.Poiré, S.Bay, M.Racinne-Divet
 */
public class MenuFen extends JFrame {

    //composants du premier menu
    private JPanel sousPan;
    private JButton nouvPartie;
    private JButton charger;
    private JButton quitter;

    //Composants de la fenetre du chargement
    private MenuCharger menuC;

    //affichage si le joueur va sur nouvelle partie
    private MenuJoueur menuJoueur;
    private JPanel panPropre;

    //composants de la fenêtre de jeu
    private Plateau fenetreJeu;
    private InfoBarre barreInfo;

    //Partie
    private Jeu jeu;

    public MenuFen() {
        initComposantes();
    }

    public static void main(String args[]) {
        EventQueue.invokeLater(() -> new MenuFen().setVisible(true));
    }

    /**
     * affichage du premier menu
     */
    private void initComposantes() {
        setTitle("<3 Arcanor <3");
        setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);

        Font f = new Font("Courier", Font.PLAIN, 60);
        JLabel titreJeu = new JLabel("ARCANOR", SwingConstants.CENTER);
        titreJeu.setFont(f);
        getContentPane().setBackground(new Color(45,80,150));

        this.nouvPartie = new JButton("Nouvelle Partie");
        this.charger = new JButton("Charger");
        this.quitter = new JButton("Quitter :'( ");

        getContentPane().setLayout(new BorderLayout());
        this.sousPan = new JPanel();
        this.sousPan.setLayout(new GridLayout(5, 1, 20, 20));
        this.sousPan.add(new JPanel());
        this.sousPan.add(nouvPartie);
        this.sousPan.add(charger);
        this.sousPan.add(quitter);
        add(titreJeu, "North");
        add(sousPan, "Center");
        add(new JPanel(), "East");
        add(new JPanel(), "West");
        add(new JPanel(), "South");
        setSize(500, 450);

        this.nouvPartie.addActionListener(new MenuFenEcout(this));
        this.charger.addActionListener(new MenuFenEcout(this));
        this.quitter.addActionListener(new MenuFenEcout(this));
    }

    /**
     * s'actionne quand le joueur clique sur nouvelle partie
     */
    public void actionJoueur() {
        remove(this.sousPan);
        this.menuJoueur = new MenuJoueur(this);
        panPropre = new JPanel();
        panPropre.setLayout(new BorderLayout());
        panPropre.add(new JPanel(), "North");
        panPropre.add(this.menuJoueur, "Center");
        add(panPropre, "Center");
        repaint();
        revalidate();
        pack();
    }


    /**
     * s'actionne pour afficher le plateau de jeu
     */
    public void actionNouvPartie(Joueur j1, Joueur j2, boolean ia) {
        this.jeu = new Jeu(j1, j2, true, ia, this);
        this.fenetreJeu = new Plateau(jeu.getLePlateau(), this);
        this.barreInfo = new InfoBarre(jeu);
        MenuBarre menuBarre = new MenuBarre(this.barreInfo, this.jeu, this);
        remove(this.panPropre);
        add(this.barreInfo, "South");
        add(menuBarre, "East");
        add(this.fenetreJeu, "Center");
        repaint();
        revalidate();
        pack();
    }

    public void actionNouvPartie(Jeu jeu){
        this.jeu = jeu;
        this.jeu.setEtat(false);
        this.fenetreJeu = new Plateau(jeu.getLePlateau(), this);
        this.barreInfo = new InfoBarre(jeu);
        MenuBarre menuBarre = new MenuBarre(this.barreInfo, this.jeu, this);
        remove(this.menuC);
        add(this.barreInfo, "South");
        add(menuBarre, "East");
        add(this.fenetreJeu, "Center");
        repaint();
        revalidate();
        pack();
    }

    public InfoBarre getBarreInfo() {
        return this.barreInfo;
    }

    /**
     * permet d'accéder au bouton de nouvelle partie
     */
    public JButton getNouvPartie() {
        return this.nouvPartie;
    }

    /**
     * permet d'accéder au bouton pour l'écouteur
     */
    public JButton getCharger() {
        return this.charger;
    }

    /**
     * permet d'accéder au bouton pour l'écouteur
     */
    public JButton getQuitter() {
        return this.quitter;
    }


    /**
     * s'actionne lorsque l'utilisateur appuie sur charger une partie
     */
    public void actionChargement() {
        remove(this.sousPan);
        //composants du menu si le joueur va sur charger
        menuC = new MenuCharger(this);
        add(menuC, "Center");
        repaint();
        revalidate();
        setSize(400, 300);
    }

    void actualise() {
        remove(this.fenetreJeu);
        this.fenetreJeu = new Plateau(jeu.getLePlateau(), this);
        add(this.fenetreJeu, "Center");
        repaint();
        revalidate();
        pack();
    }

    public Jeu getJeu() {
        return jeu;
    }
}
