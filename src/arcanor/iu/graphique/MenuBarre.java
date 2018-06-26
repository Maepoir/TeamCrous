package arcanor.iu.graphique;
import arcanor.controleur.graphique.MenuBarreEcout;
import arcanor.modele.Jeu;

import javax.swing.*;
import javax.swing.plaf.basic.BasicArrowButton;
import java.awt.*;
/** represente la barre de menu permettant de faire des choix de jeu
* @author G.Renault, M.Poiré, S.Bay, M.Racinne-Divet */
public class MenuBarre extends JPanel {

    private JButton sauvegarder;
    private JTextField chemin;
    private JButton quitter;
    private InfoBarre infos;
    private Jeu jeu;
    private MenuFen menu;

    //Liberation du pion
    private JLabel libere;
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
    private ButtonGroup deplacements;

    //Validation du mouvement
    private JButton valider;

    public MenuBarre (InfoBarre infos, Jeu jeu, MenuFen menu){
        this.infos = infos;
        this.jeu = jeu;
        this.menu = menu;
        initComposants();
    }

    public void initComposants (){
        setLayout(new GridLayout(5,1));

        this.sauvegarder = new JButton("Sauvegarder");
        this.sauvegarder.addActionListener(new MenuBarreEcout(this, this.jeu));
        this.chemin = new JTextField("Chemin de la sauvegarde");
        JPanel sousPan = new JPanel();
        sousPan.setLayout(new GridLayout(1,2));
        sousPan.add(chemin);
        sousPan.add(sauvegarder);

        this.quitter = new JButton("Quitter");
        this.quitter.addActionListener(new MenuBarreEcout(this, this.jeu));

        JPanel panelDeplacements = new JPanel();
        panelDeplacements.setLayout(new GridLayout(3,3));
        this.deplacements = new ButtonGroup();

        this.hautGauche = new BasicArrowButton(SwingConstants.NORTH_WEST);
        this.deplacements.add(this.hautGauche);
        panelDeplacements.add(this.hautGauche);
        this.hautGauche.addActionListener(new MenuBarreEcout(this, this.jeu));

        this.haut = new BasicArrowButton(SwingConstants.NORTH);
        this.deplacements.add(this.haut);
        panelDeplacements.add(this.haut);
        this.haut.addActionListener(new MenuBarreEcout(this, this.jeu));

        this.hautDroite = new BasicArrowButton(SwingConstants.NORTH_EAST);
        this.deplacements.add(this.hautDroite);
        panelDeplacements.add(this.hautDroite);
        this.hautDroite.addActionListener(new MenuBarreEcout(this, this.jeu));

        this.gauche = new BasicArrowButton(SwingConstants.WEST);
        this.deplacements.add(this.gauche);
        panelDeplacements.add(this.gauche);
        this.gauche.addActionListener(new MenuBarreEcout(this, this.jeu));

        panelDeplacements.add(new JPanel());

        this.droite = new BasicArrowButton(SwingConstants.EAST);
        this.deplacements.add(this.droite);
        panelDeplacements.add(this.droite);
        this.droite.addActionListener(new MenuBarreEcout(this, this.jeu));

        this.basGauche = new BasicArrowButton(SwingConstants.SOUTH_EAST);
        this.deplacements.add(this.basGauche);
        panelDeplacements.add(this.basGauche);
        this.basGauche.addActionListener(new MenuBarreEcout(this, this.jeu));

        this.bas = new BasicArrowButton(SwingConstants.SOUTH);
        this.deplacements.add(this.bas);
        panelDeplacements.add(this.bas);
        this.bas.addActionListener(new MenuBarreEcout(this, this.jeu));

        this.basDroite = new BasicArrowButton(SwingConstants.SOUTH_WEST);
        this.deplacements.add(this.basDroite);
        panelDeplacements.add(this.basDroite);
        this.basDroite.addActionListener(new MenuBarreEcout(this, this.jeu));


        this.libere = new JLabel("Liberer un pion ?");
        this.liberer = new JCheckBox();
        this.liberer.addActionListener(new MenuBarreEcout(this, this.jeu));


        JPanel liberation = new JPanel();
        liberation.setLayout(new FlowLayout());

        liberation.add(libere);
        liberation.add(liberer);

        this.valider = new JButton("Valider");
        this.valider.addActionListener(new MenuBarreEcout(this, this.jeu));

        JPanel sousPan2 = new JPanel();
        sousPan2.setLayout(new FlowLayout());
        sousPan2.add(panelDeplacements);
        sousPan2.add(liberation);
        sousPan2.add(this.valider);


        add(sousPan);
        add(new JPanel());
        add(sousPan2);
        add(new JPanel());
        add(quitter);
    }

    public JButton getSauvegarder() {
        return sauvegarder;
    }

    public JTextField getChemin() {
        return chemin;
    }

    public JButton getQuitter() {
        return quitter;
    }

    public JCheckBox getLiberer() {
        return liberer;
    }

    public InfoBarre getInfos() {
        return infos;
    }

    public BasicArrowButton getDroite() {
        return droite;
    }

    public BasicArrowButton getHaut() {
        return haut;
    }

    public BasicArrowButton getHautDroite() {
        return hautDroite;
    }

    public BasicArrowButton getHautGauche() {
        return hautGauche;
    }

    public BasicArrowButton getBas() {
        return bas;
    }

    public BasicArrowButton getBasDroite() {
        return basDroite;
    }

    public BasicArrowButton getBasGauche() {
        return basGauche;
    }

    public BasicArrowButton getGauche() {
        return gauche;
    }

    public JButton getValider (){
        return this.valider;
    }

    public void deplacer (){
        if(!this.jeu.deplacement()){
            this.infos.setText("Veuillez jouer un coup correct");
        }
        else{
            this.menu.actualise(this.jeu.getLePlateau());
        }
    }
}
