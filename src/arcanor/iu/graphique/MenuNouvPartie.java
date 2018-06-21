package arcanor.iu.graphique;
import javax.swing.*;
import java.awt.*;

/** permet d'afficher graphiquement les choix de jeu disponibles lors du lancement
* du jeu.
* @author G.Renault, M.Poiré, S.Bay, M.Racinne-Divet */
public class MenuNouvPartie extends JPanel {

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

  public MenuNouvPartie(){
    initComponents();
  }

  public void initComponents(){
    Font f = new Font("Arial",Font.PLAIN,60);
    this.titreJeu = new JLabel("ARCANOR", SwingConstants.CENTER);
    this.titreJeu.setFont(f);

    this.nomJ1 = new JLabel("nom joueur 1 :",SwingConstants.CENTER);
    this.nomJ2 = new JLabel("nom joueur 2 :",SwingConstants.CENTER);
    this.j1 = new JTextField();
    this.j2 = new JTextField();
    this.choixIA = new JLabel("Jouer contre l'IA ?",SwingConstants.CENTER);
    this.IAoui = new JRadioButton("oui");
    this.IAnon = new JRadioButton("non");

    ButtonGroup bg = new ButtonGroup();
    bg.add(this.IAoui);
    bg.add(this.IAnon);
    this.choixBouton = new JPanel();
    this.choixBouton.add(this.IAoui);
    this.choixBouton.add(this.IAnon);

    this.boutons = new JPanel();
    this.boutons.setLayout(new GridLayout(3,2));
    this.boutons.add(this.nomJ1);
    this.boutons.add(this.j1);
    this.boutons.add(this.nomJ2);
    this.boutons.add(this.j2);
    this.boutons.add(this.choixIA);
    this.boutons.add(this.choixBouton);

    this.valider = new JButton("Valider");
    setLayout(new BorderLayout());
    add(titreJeu,"North");
    add(boutons,"Center");
    add(valider,"South");
  }

}
