package arcanor.modele;

import arcanor.Sauvegarde;
import arcanor.iu.console.MenuTxt;
import arcanor.iu.console.PlateauTxt;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.Serializable;
import java.util.Random;
import java.util.Scanner;

/**
 * Role :  Cette classe permet de modeliser le jeu d'Arcanor
 *
 * @author S.Bay ,M.Racine,M.Poiré G.Renault
 */
public class Jeu implements Serializable {

    //fenêtre de jeu graphique
    //private JeuFen jeuG;
    //Pour la sauvegarde
    boolean ia;
    private Plateau lePlateau;
    //le premier joueur
    private Joueur joueur1;
    //le deuxième joueur
    private Joueur joueur2;
    // détermine si le jeu doit s'afficher en mode graphique ou console
    private boolean modeGraphique;
    //le joueur qui a la main
    private Joueur aLaMain;


    /**
     * Role : permet de créer un objet Jeu avec des paramètres précis
     *
     * @param joueur1       le premier Joueur
     * @param joueur2       le deuxième joueur
     * @param modeGraphique le mode d'affichage du jeu choisi
     */
    public Jeu(Joueur joueur1, Joueur joueur2, boolean modeGraphique) {
        this.joueur1 = joueur1;
        this.joueur2 = joueur2;
        this.lePlateau = new Plateau(this.joueur1, this.joueur2);
        this.modeGraphique = modeGraphique;
        this.aLaMain = this.joueur1;
    }

    /**
     * Permet de passer des lignes pour ne pas que la console soit surchargée
     */
    public static void blanc() {
        StringBuilder blanc = new StringBuilder();
        for (int i = 0; i < 28; i++) {
            blanc.append("\n");
        }
        System.out.println(blanc);
    }

    /**
     * Role : Cette methode permet de charger une partie
     */

    public static Jeu chargerJeu() {
        Jeu ret = null;

        Scanner sc = new Scanner(System.in);
        System.out.println("Veuillez entrer le nom de votre sauvegarde :");
        String sauvegarde = sc.nextLine();

        if (Sauvegarde.charger(sauvegarde) != null) {
            ret = Sauvegarde.charger(sauvegarde);
        } else {
            System.out.println("Fichier introuvable, création d'une nouvelle partie");
            MenuTxt.afficherMenu();
        }

        return ret;
    }

    /**
     * Role : Cette methode permet de sauvegarder une partie
     *
     * @param chemin chemin pour la sauvegarde
     */
    private void sauvegarderJeu(String chemin) {
        Sauvegarde.sauvegarder(chemin, this);
    }

    /**
     * Role : Cette methode permet de changer l'affichage d'un pion (mode triche)
     *
     * @param lePion le pion pour lequel il faut changer l'affichage
     */
    public void changerAffichagePion(Pion lePion, boolean affichage) {
        lePion.setAfficherManger(affichage);
    }

    /**
     * Role : Cette methode permet de changer la main d'un joueur pour la donner à
     * l'autre
     */
    private void changerMain() {
        if (this.aLaMain.equals(joueur1)) {
            this.aLaMain = this.joueur2;
        } else {
            this.aLaMain = this.joueur1;
        }
    }

    /**
     * Role : permet de lancer un tutoriel pour apprendre au joueur à jouer à
     * Arcanor
     */
    private void tutoriel() {
        try {
            Scanner sc = new Scanner(new FileReader("../doc/Tuto.txt"));
            while (sc.hasNextLine()) {
                System.out.println(sc.nextLine());
            }
            sc.close();
            Thread.sleep(30000);
        } catch (FileNotFoundException | InterruptedException e) {
            e.printStackTrace();
        }
        blanc();
    }

    /**
     * permet de jouer à Arcanor
     *
     * @param ia permet de savoir si le joueur veut jouer contre une IA
     */
    public void debutPartie(boolean ia) {
        boolean deplacementFait = false;
        boolean partieGagne = false;
        boolean libererPion;
        Pion aDeplacer;
        int placement;
        int choixPion;
        String sauvegarder;
        Scanner sc = new Scanner(System.in);
        this.ia = ia;

        if (!this.modeGraphique) {

//            tutoriel();

            System.out.println("== Debut de partie ==");

            PlateauTxt.afficherPlateau(this.lePlateau);
            System.out.println("Le joueur qui commence est : " + aLaMain.getNom());
            while (!partieGagne) {
                while (!deplacementFait) {
                    choixPion = choixPion(ia);
                    aDeplacer = lePlateau.getPion(choixPion);
                    placement = this.aLaMain.jouer();
                    libererPion = libererPion(ia, aDeplacer);
                    deplacementFait = this.lePlateau.deplacerPion(aDeplacer, placement, libererPion);
                }
                partieGagne = this.lePlateau.verifVictoire(this.aLaMain);

                if (!partieGagne) {
                    changerMain();
                    System.out.println("Voulez vous sauvegarder la partie ? (o/n)");
                    sauvegarder = sc.nextLine();
                    while (!sauvegarder.equals("o") && !sauvegarder.equals("n")) {
                        System.out.println("Veuillez realiser une saise correcte.");
                        sauvegarder = sc.nextLine();
                    }
                    if (sauvegarder.equals("o")) {
                        System.out.println("Entrer le nom de votre fichier");
                        String chemin = sc.nextLine();
                        sauvegarderJeu(chemin);
                        System.out.println("Partie sauvegardee avec succes. Nous esperons vous revoir bientot !");
                        System.exit(0);
                    }
                    System.out.println("C'est au tour de " + this.aLaMain.getNom());
                }
                deplacementFait = false;
            }
            System.out.println("Fin du jeu ! Victoire de " + this.aLaMain.getNom() + " !! :)");
        } else {

            while(!partieGagne){

                while(!deplacementFait){

                    if(!partieGagne){
                        changerMain();
                    }
                }

            }

        }
    }

    /**
     * Permet de choisir le pion à jouer pour la méthode debutPartie()
     *
     * @param ia permet de savoir si un joueur est un ia
     * @return le nombre du pion à bouger
     */
    private int choixPion(boolean ia) {
        Scanner sc = new Scanner(System.in);
        int ret = -1;
        boolean verif = false;

        if (!ia || aLaMain.equals(joueur1)) {
            System.out.println("Veuillez choisir le pion que vous souhaitez deplacer.");
            while (!verif) {
                ret = sc.nextInt();
                if (this.aLaMain.equals(joueur1)) {
                    if (ret > 0 && ret < 13) {
                        if (lePlateau.getPion(ret).getEstMange()) {
                            System.out.println("Vous ne pouvez pas jouer un pion mange.");
                        } else {
                            verif = true;
                        }
                    } else if (ret > 12 && ret <= 24) {
                        System.out.println("Vous ne pouvez pas jouer un pion adverse.");
                    } else {
                        System.out.println("Vous ne pouvez jouer que les pions compris entre 1 et 12.");
                    }
                } else {
                    if (ret > 12 && ret < 25) {
                        if (lePlateau.getPion(ret).getEstMange()) {
                            System.out.println("Vous ne pouvez pas jouer un pion mange.");
                        } else {
                            verif = true;
                        }
                    } else if (ret <= 12 && ret > 0) {
                        System.out.println("Vous ne pouvez pas jouer un pion adverse.");
                    } else {
                        System.out.println("Vous ne pouvez jouer que les pions compris entre 13 et 24.");
                    }
                }
            }
        } else {
            while (!verif) {
                Random r = new Random();
                ret = 24 - r.nextInt(12);
                if (ret > 0 && ret <= 24) {
                    if (!lePlateau.getPion(ret).getEstMange()) {
                        verif = true;
                    }
                }
            }
        }

        System.out.println("Le pion choisi est le " + ret);

        return ret;
    }


    /**
     * Permet de choisir s'il faut libérer le pion ou non
     *
     * @param ia permet de savoir si un joueur est un ia
     */
    private boolean libererPion(boolean ia, Pion aDeplacer) {
        Scanner sc = new Scanner(System.in);
        Random r = new Random();
        String libere;
        boolean libererPion = false;
        int tirageAuSort;

        if ((!ia) || (aLaMain.equals(joueur1))) {
            System.out.println("Voulez vous liberer le pion situe sous celui que vous deplacez ? (o/n)");
            libere = sc.next();

            while (!libere.equals("o") && !libere.equals("n")) {
                System.out.println("Veuillez entrer une saisie correcte");
                libere = sc.nextLine();
            }
        } else {
            tirageAuSort = r.nextInt(2);
            if (tirageAuSort == 0) {
                libere = "o";
            } else {
                libere = "n";
            }
        }


        if ((libere.equals("o")) && (aDeplacer.getAMange() != null)) {
            libererPion = true;
        }

        return libererPion;
    }

    /**
     * permet d'acceder au plateau de jeu
     *
     * @return le plateau de jeu
     */
    public Plateau getLePlateau() {
        return this.lePlateau;
    }

    /**
     * Permet de savoir qui joue
     *
     * @return le joueur qui a la main
     */
    public Joueur getaLaMain() {
        return aLaMain;
    }

    /**
     * Permet d'obtenir le joueur 1
     *
     * @return le joueur 1
     */
    public Joueur getJoueur1() {
        return joueur1;
    }

    /**
     * permet d'obtenir le joueur 2
     *
     * @return le joueur 2
     */
    public Joueur getJoueur2() {
        return joueur2;
    }
}
