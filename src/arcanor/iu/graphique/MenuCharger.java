package arcanor.iu.graphique;

import arcanor.controleur.graphique.MenuChargerEcout;

import javax.swing.*;
import java.awt.*;

public class MenuCharger extends JPanel {

    private JTextField text;

    MenuCharger() {
        initComponents();
    }

    private void initComponents() {
        JLabel nomS = new JLabel("Entrer le nom de la sauvegarde :", SwingConstants.CENTER);
        this.text = new JTextField();
        JButton valider = new JButton("Valider");
        JPanel vide = new JPanel();
        JPanel vide2 = new JPanel();
        JPanel demande = new JPanel();
        demande.setLayout(new GridLayout(4, 1, 10, 10));
        demande.add(vide2);
        demande.add(nomS);
        demande.add(text);
        demande.add(vide);

        setLayout(new BorderLayout());
        add(demande, "Center");
        add(valider, "South");

        valider.addActionListener(new MenuChargerEcout(this));
    }

    public JTextField getNomSauv() {
        return this.text;
    }
}
