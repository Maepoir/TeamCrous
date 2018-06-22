package arcanor.iu.graphique;

import arcanor.modele.Couleur;
import arcanor.modele.JoueurHumain;

import javax.swing.*;
import java.awt.*;

public class Test {

    public static void main (String [] args){

        EventQueue.invokeLater(() -> {
            arcanor.modele.Plateau p = new arcanor.modele.Plateau(new JoueurHumain("zbb",Couleur.BLANC),new JoueurHumain("bzz",Couleur.NOIR));
            Plateau plat = new Plateau(p);
            JFrame frame = new JFrame();
            frame.getContentPane().setLayout(new FlowLayout());
            frame.add(plat);
            frame.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
            frame.setVisible(true);
            frame.pack();
        });
    }

}
