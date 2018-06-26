package arcanor.iu.graphique;
import arcanor.controleur.graphique.MenuBarreEcout;
import arcanor.modele.Jeu;

import javax.swing.*;
import java.awt.*;
/** represente la barre de menu permettant de faire des choix de jeu
* @author G.Renault, M.Poiré, S.Bay, M.Racinne-Divet */
public class MenuBarre extends JPanel {

    private JButton sauvegarder;
    private JTextField chemin;
    private JButton quitter;
    private JLabel libere;
    private JCheckBox liberer;
    private InfoBarre infos;
    private Jeu jeu;

    public MenuBarre (InfoBarre infos, Jeu jeu){
        this.infos = infos;
        this.jeu = jeu;
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

        this.libere = new JLabel("Liberer le pion situe sous le votre.");
        this.liberer = new JCheckBox();
        this.liberer.addActionListener(new MenuBarreEcout(this, this.jeu));
        JPanel sousPan2 = new JPanel();
        sousPan2.setLayout(new GridLayout(2,1,0,0));
        sousPan2.add(libere);
        sousPan2.add(liberer);

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
}
