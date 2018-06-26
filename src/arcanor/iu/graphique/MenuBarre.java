package arcanor.iu.graphique;

import arcanor.controleur.graphique.MenuBarreEcout;
import arcanor.modele.Jeu;

import javax.swing.*;
import javax.swing.plaf.basic.BasicArrowButton;
import java.awt.*;

/**
 * represente la barre de menu permettant de faire des choix de jeu
 *
 * @author G.Renault, M.Poiré, S.Bay, M.Racinne-Divet
 */
public class MenuBarre extends JPanel {

    private JButton sauvegarder;
    private JTextField chemin;
    private JButton quitter;
    private InfoBarre infos;
    private Jeu jeu;
    private MenuFen menu;

    private JCheckBox liberer;

    //Boutons de déplacements
    private BasicArrowButton hautGauche;
    private BasicArrowButton haut;
    private BasicArrowButton hautDroite;
    private BasicArrowButton droite;
    private BasicArrowButton basDroite;
    private BasicArrowButton bas;
    private BasicArrowButton basGauche;
    private BasicArrowButton gauche;

    //Validation du mouvement
    private JButton valider;

    //Revelation de ce que contient le pion
    private JButton revelation;

    /**
    * Constructeur
    *
    * @param infos la barre d'info du jeu
    * @param jeu le jeu à jouer sur l'interface
    * @param menu la fenetre permettant d'afficher l'interface
    */
    MenuBarre(InfoBarre infos, Jeu jeu, MenuFen menu) {
        this.infos = infos;
        this.jeu = jeu;
        this.menu = menu;
        initComposants();
    }

    /**
    * permet d'initialiser les composants
    */
    private void initComposants() {

        this.sauvegarder = new JButton("Sauvegarder");
        this.sauvegarder.addActionListener(new MenuBarreEcout(this, this.jeu));
        this.chemin = new JTextField("Chemin de la sauvegarde");
        JPanel sousPan = new JPanel();
        sousPan.setLayout(new GridLayout(1, 2));
        sousPan.add(chemin);
        sousPan.add(sauvegarder);

        this.quitter = new JButton("Quitter");
        this.quitter.addActionListener(new MenuBarreEcout(this, this.jeu));

        JPanel panelDeplacements = new JPanel();
        panelDeplacements.setLayout(new GridLayout(3, 3));
        ButtonGroup deplacements = new ButtonGroup();

        this.hautGauche = new BasicArrowButton(SwingConstants.NORTH_WEST);
        deplacements.add(this.hautGauche);
        panelDeplacements.add(this.hautGauche);
        this.hautGauche.addActionListener(new MenuBarreEcout(this, this.jeu));

        this.haut = new BasicArrowButton(SwingConstants.NORTH);
        deplacements.add(this.haut);
        panelDeplacements.add(this.haut);
        this.haut.addActionListener(new MenuBarreEcout(this, this.jeu));

        this.hautDroite = new BasicArrowButton(SwingConstants.NORTH_EAST);
        deplacements.add(this.hautDroite);
        panelDeplacements.add(this.hautDroite);
        this.hautDroite.addActionListener(new MenuBarreEcout(this, this.jeu));

        this.gauche = new BasicArrowButton(SwingConstants.WEST);
        deplacements.add(this.gauche);
        panelDeplacements.add(this.gauche);
        this.gauche.addActionListener(new MenuBarreEcout(this, this.jeu));

        panelDeplacements.add(new JPanel());

        this.droite = new BasicArrowButton(SwingConstants.EAST);
        deplacements.add(this.droite);
        panelDeplacements.add(this.droite);
        this.droite.addActionListener(new MenuBarreEcout(this, this.jeu));

        this.basGauche = new BasicArrowButton(SwingConstants.SOUTH_EAST);
        deplacements.add(this.basGauche);
        panelDeplacements.add(this.basGauche);
        this.basGauche.addActionListener(new MenuBarreEcout(this, this.jeu));

        this.bas = new BasicArrowButton(SwingConstants.SOUTH);
        deplacements.add(this.bas);
        panelDeplacements.add(this.bas);
        this.bas.addActionListener(new MenuBarreEcout(this, this.jeu));

        this.basDroite = new BasicArrowButton(SwingConstants.SOUTH_WEST);
        deplacements.add(this.basDroite);
        panelDeplacements.add(this.basDroite);
        this.basDroite.addActionListener(new MenuBarreEcout(this, this.jeu));

        //Liberation du pion
        JLabel libere = new JLabel("Liberer un pion ?");
        this.liberer = new JCheckBox();
        this.liberer.addActionListener(new MenuBarreEcout(this, this.jeu));


        JPanel liberation = new JPanel();
        liberation.setLayout(new FlowLayout());

        liberation.add(libere);
        liberation.add(liberer);

        this.valider = new JButton("Valider");
        this.valider.addActionListener(new MenuBarreEcout(this, this.jeu));

        JPanel sousPan2 = new JPanel();
        sousPan2.setLayout(new BorderLayout());
        sousPan2.add(liberation, "Center");
        sousPan2.add(this.valider, "South");

        this.revelation = new JButton("Reveler ce que contient le pion selectionne");
        this.revelation.addActionListener(new MenuBarreEcout(this, this.jeu));

        setLayout(new GridLayout(9, 1));

        add(sousPan);
        add(new JPanel());
        add(panelDeplacements);
        add(new JPanel());
        add(sousPan2);
        add(new JPanel());
        add(this.revelation);
        add(new JPanel());
        add(quitter);
    }

    /**
    * permet d'accéder au bouton sauvegarder
    *
    * @return le JButton sauvegarder */
    public JButton getSauvegarder() {
        return sauvegarder;
    }

    /**
    * permet d'accéder au chemin de sauvegarde saisi par l'utilisateur
    *
    * @return le JTextField avec le chemin
    */
    public JTextField getChemin() {
        return chemin;
    }

    /**
    * permet d'accéder au bouton quitter
    *
    * @return le JButton quitter
    */
    public JButton getQuitter() {
        return quitter;
    }

    /**
    * permet d'accéder au choix de l'utilisateur sur la libération d'un pion
    *
    * @return la JCheckBox liberer
    */
    public JCheckBox getLiberer() {
        return liberer;
    }

    /**
    * permet d'accéder à la barre d'informations
    *
    * @return la barre d'informations InfoBarre
    */
    public InfoBarre getInfos() {
        return infos;
    }

    /**
    * permet de savoir si le joueur veut aller à droite
    *
    * @return le bouton de déplacement à droite*/
    public BasicArrowButton getDroite() {
        return droite;
    }

    /**
    * permet de savoir si le joueur veut aller en haut
    *
    * @return le bouton de déplacement en haut*/
    public BasicArrowButton getHaut() {
        return haut;
    }

    /**
    * permet de savoir si le joueur veut aller en haut à droite
    *
    * @return le bouton de déplacement en haut à droite*/
    public BasicArrowButton getHautDroite() {
        return hautDroite;
    }

    /**
    * permet de savoir si le joueur veut aller en haut à gauche
    *
    * @return le bouton de déplacement en haut à gauche*/
    public BasicArrowButton getHautGauche() {
        return hautGauche;
    }

    /**
    * permet de savoir si le joueur veut aller en bas
    *
    * @return le bouton de déplacement en bas
    */
    public BasicArrowButton getBas() {
        return bas;
    }

    /**
    * permet de savoir si le joueur veut aller en bas à droite
    *
    * @return le bouton de déplacement en bas à droite
    */
    public BasicArrowButton getBasDroite() {
        return basDroite;
    }

    /**
    * permet de savoir si le joueur veut aller en bas à gauche
    *
    * @return le bouton de déplacement en bas à gauche
    */
    public BasicArrowButton getBasGauche() {
        return basGauche;
    }

    /**
    * permet de savoir si le joueur veut aller à gauche
    *
    * @return le bouton de déplacement à gauche
    */
    public BasicArrowButton getGauche() {
        return gauche;
    }

    /**
    * permet d'accéder au bouton de validation
    *
    * @return le bouton "valider"
    */
    public JButton getValider() {
        return this.valider;
    }

    /**
    * permet de savoir si le joueur veut voir ce qu'il y a sous ses pions
    *
    * @return le bouton de revelation des pions
    */
    public JButton getRevelation() {
        return this.revelation;
    }

    /**
    * permet de gérer si le joueur choisit un déplacement non valide
    */
    public void deplacer() {
        if (!this.jeu.deplacement()) {
            this.infos.setText("Veuillez jouer un coup correct");
        } else {
            this.menu.actualise();
        }
    }
}
