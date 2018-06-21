package arcanor.iu.graphique;
import arcanor.controleur.graphique.*;
import javax.swing.*;
import java.awt.*;
/** affiche graphiquement le menu avec les options de jeu disponibles
* @author G.Renault, M.Poiré, S.Bay, M.Racinne-Divet */
public class MenuFen extends JFrame {

    private JLabel titreJeu;

    //composants du premier menu
    private JPanel souspan;
    private JButton nouvPartie;
    private JButton charger;
    private JButton quitter;

    //affichage si le joueur va sur nouvelle partie
    private MenuNouvPartie menuNouvPartie;

    //composants du menu si le joueur va sur charger
    //private MenuCharger menuCharger;


    public static void main(String args[]){
      java.awt.EventQueue.invokeLater(new Runnable(){
        public void run(){
          new MenuFen().setVisible(true);
        }
      });
    }

    public MenuFen(){
      initComponents();
    }

    /** affichage du premier menu */
    public void initComponents(){
      setTitle("Arcanor");
      setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);

      Font f = new Font("Arial",Font.PLAIN,60);
      this.titreJeu = new JLabel("ARCANOR", SwingConstants.CENTER);
      this.titreJeu.setFont(f);

      this.nouvPartie = new JButton("Nouvelle Partie");
      this.charger = new JButton("Charger");
      this.quitter = new JButton("Quitter :'( ");

      JPanel vide = new JPanel();
      JPanel vide2 = new JPanel();
      getContentPane().setLayout(new BorderLayout());
      this.souspan = new JPanel();
      this.souspan.setLayout(new GridLayout(5,1));
      this.souspan.add(vide);
      this.souspan.add(nouvPartie);
      this.souspan.add(charger);
      this.souspan.add(quitter);
      add(titreJeu, "North");
      add(souspan, "Center");

      setSize(800,800);
      this.nouvPartie.addActionListener(new EcoutMenuFen(this));
    }

    /** s'actionne quand le joueur clique sur nouvelle partie */
    public void actionNouv(){
      this.menuNouvPartie = new MenuNouvPartie();
      setContentPane(this.menuNouvPartie);
      repaint();
      revalidate();
    }

    public JButton getNouvPartie(){return this.nouvPartie;}
}
