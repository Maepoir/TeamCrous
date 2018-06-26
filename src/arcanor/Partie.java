package arcanor;

import arcanor.iu.console.MenuTxt;
import arcanor.iu.graphique.MenuFen;
import arcanor.modele.Jeu;

import java.awt.*;
import java.util.Scanner;

/**
 * Cette classe permet de lancer une partie d'Arcanor
 *
 * @author M.Poiré, S.Bay
 */
public class Partie {


    /**
     * Lance Arcanor
     *
     * @param args tableau de chaine de caractères
     */
    public static void main(String[] args) {
        Jeu.blanc();
        System.out.println("Lancement d'une fantastique partie d'Arcanor !");

        System.out.println("\nVoulez vous jouez avec l'interface graphique active ? (oui/non)");
        Scanner sc = new Scanner(System.in);
        String rep = sc.nextLine();
        boolean mode = false;

        while (!rep.trim().equals("oui") && !rep.trim().equals("non")) {
            System.out.println("saisie incorrecte !");
            rep = sc.nextLine();
        }
        if (rep.trim().equals("oui")) {
            mode = true;
        }

        if (!mode) {
            MenuTxt.afficherMenu();
        } else {
            EventQueue.invokeLater(() -> new MenuFen().setVisible(true));
        }
    }
}
