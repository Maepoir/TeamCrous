package arcanor.iu.console;

import arcanor.modele.*;

import java.util.Scanner;

/**
 * permet d'afficher le menu sur la console
 *
 * @author G.Renault, M.Poiré, S.Bay, M.Racinne-Divet
 */
public class MenuTxt {

    /**
     * permet d'afficher le menu sur la console
     */
    public static void afficherMenu() {
        boolean iaPresente = false;
        String ia ="";
        Scanner sc = new Scanner(System.in);

        System.out.println(" <3 Arcanor <3 ");
        System.out.println("\t(1.) Nouvelle partie");
        System.out.println("\t(2.) Charger");
        System.out.println("\t(3.) Quitter");
        System.out.println("Saisissez votre choix :");
        int choix = sc.nextInt();
        while (choix != 1 && choix != 2 && choix != 3) {
            choix = sc.nextInt();
        }
        if (choix == 1) {
            System.out.println("Saisir nom du joueur 1 :");
            String nom1 = sc.next();
            JoueurHumain j1 = new JoueurHumain(nom1, Couleur.BLANC);
            System.out.println("Jouer contre un IA ?(o/n)");
            Joueur j2;
            ia = sc.nextLine();

            while(!ia.equals("o") && !ia.equals("n")) {
                System.out.println("Veuillez saisir une entree correcte");
                ia = sc.nextLine();
            }

            if (ia.equals("o")) {
                System.out.println("Saisir nom de l'IA : ");
                String nom2 = sc.nextLine();
                j2 = new IA(nom2, Couleur.NOIR, 1);
                iaPresente = true;
            } else {
                System.out.println("Saisir nom du joueur 2 : ");
                String nom2 = sc.nextLine();
                j2 = new JoueurHumain(nom2, Couleur.NOIR);
            }

            boolean modeGraphique = false;
        /*System.out.println("Jouer en mode triche (voir quel pion à déjà mangé un autre) ou en mode normal ? (t/n)");
        String tricheNormal = in.nextLine();*/
            Jeu jeu = new Jeu(j1, j2, ModeJeu.NORMAL, modeGraphique);
        /*if(tricheNormal.equals("t")){
          jeu = new Jeu(j1,j2, ModeJeu.TRICHE,modeGraphique);
        }
        else{
          jeu = new Jeu(j1,j2, ModeJeu.NORMAL,modeGraphique);
        }*/
            jeu.debutPartie(iaPresente);
        }
        //cet condition non codée, uniquement pour la compilation
        else if (choix == 2) {
            Jeu jeu = Jeu.chargerJeu();
            jeu.debutPartie(iaPresente);
        }
        //en cas de saisie incorrecte ou de choix 3
        else {
            System.out.println("Merci d'avoir lancé Arcanor, à bientôt ! <3");
            System.exit(0);
        }
    }

}
