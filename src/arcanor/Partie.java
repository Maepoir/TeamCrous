package arcanor;

import arcanor.iu.console.MenuTxt;

import java.util.Scanner;

/**
 * Rôle :  Cette classe permet de lancer une partie d'Arcanor
 *
 * @author G.Renault, M.Poiré, S.Bay, M.Racinne-Divet
 */
public class Partie {


    /**
     * Rôle : lance Arcanor
     *
     * @param args tableau de chaine de caractères
     */
    public static void main(String[] args) {
        System.out.println("Lancement d'une fantastique partie d'Arcanor !");

        System.out.println("Voulez vous jouez avec l'interface graphique active ? (oui/non)");
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
            MenuTxt menuC = new MenuTxt();
            menuC.afficherMenu();
        } else {
            //mettre ici partie graphique
            System.out.println("non géré pour l'instant");
        }
        //commentaire car méthode non écrite, elle permettra de lancer la partie
        //jeu.start();
    }
}
