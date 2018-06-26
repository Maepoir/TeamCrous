package arcanor.iu.graphique;

import arcanor.controleur.graphique.*;
import arcanor.modele.Jeu;
import arcanor.modele.Joueur;
import javax.swing.*;
import java.awt.*;
import java.util.*;

/**
 * affiche graphiquement le menu avec les options de jeu disponibles
 *
 * @author G.Renault, M.Poiré, S.Bay, M.Racinne-Divet
 */
public class MenuFen extends JFrame {

    private JLabel titreJeu;

    //composants du premier menu
    private JPanel sousPan;
    private JButton nouvPartie;
    private JButton charger;
    private JButton quitter;

    //affichage si le joueur va sur nouvelle partie
    private MenuJoueur menuJoueur;

    //composants du menu si le joueur va sur charger
    private MenuCharger menuCharger;

    //composants de la fenêtre de jeu
    private Plateau fenetreJeu;
    private InfoBarre barreInfo;
    private MenuBarre menuBarre;

    //Partie
    private Jeu jeu;

    public static void main(String args[]) {
        EventQueue.invokeLater(() -> new MenuFen().setVisible(true));
    }

    public MenuFen() {
        initComponents();
    }

    /**
     * affichage du premier menu
     */
    private void initComponents() {
        setTitle("<3 Arcanor <3");
        setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);

        Font f = new Font("Courier", Font.PLAIN, 60);
        this.titreJeu = new JLabel("ARCANOR", SwingConstants.CENTER);
        this.titreJeu.setFont(f);

        this.nouvPartie = new JButton("Nouvelle Partie");
        this.charger = new JButton("Charger");
        this.quitter = new JButton("Quitter :'( ");

        JPanel vide = new JPanel();
        JPanel vide2 = new JPanel();
        JPanel vide3 = new JPanel();
        getContentPane().setLayout(new BorderLayout());
        this.sousPan = new JPanel();
        this.sousPan.setLayout(new GridLayout(5, 1, 20, 20));
        this.sousPan.add(vide);
        this.sousPan.add(nouvPartie);
        this.sousPan.add(charger);
        this.sousPan.add(quitter);
        add(titreJeu, "North");
        add(sousPan, "Center");
        add(vide, "East");
        add(vide2, "West");
        add(vide3, "South");
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
        add(this.menuJoueur, "Center");
        repaint();
        revalidate();
        pack();
    }


    /** s'actionne pour afficher le plateau de jeu */
    public void actionNouvPartie(Joueur j1, Joueur j2) {
        this.jeu = new Jeu(j1, j2, true, this);
        this.fenetreJeu = new Plateau(jeu.getLePlateau(), this);
        this.barreInfo = new InfoBarre(jeu);
        this.menuBarre = new MenuBarre(this.barreInfo, this.jeu);
        remove(this.menuJoueur);
        add(this.fenetreJeu, "Center");
        add(this.barreInfo, "South");
        repaint();
        revalidate();
        pack();
    }

    public InfoBarre getBarreInfo (){
        return this.barreInfo;
    }

    public void deplacerPion (){
        this.jeu.getaLaMain();
    }

    public Plateau getFenetreJeu () {
        return this.fenetreJeu;
    }

    public void actualise (arcanor.modele.Plateau plateau){
        remove(this.fenetreJeu);
        this.fenetreJeu = new Plateau(jeu.getLePlateau(), this);
        add(this.fenetreJeu,"Center");
        repaint();
        revalidate();
        pack();
    }

}
