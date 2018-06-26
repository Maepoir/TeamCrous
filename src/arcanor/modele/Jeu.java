package arcanor.modele;

import arcanor.Sauvegarde;
import arcanor.iu.console.MenuTxt;
import arcanor.iu.console.PlateauTxt;
import arcanor.iu.graphique.MenuFen;

import java.awt.*;
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

    //Pour la sauvegarde
    private boolean ia;
    private Plateau lePlateau;
    //le premier joueur
    private Joueur joueur1;
    //le deuxième joueur
    private Joueur joueur2;
    // détermine si le jeu doit s'afficher en mode graphique ou console
    private boolean modeGraphique;
    //le joueur qui a la main
    private Joueur aLaMain;

    //Graphique
    //Fenetre de jeu
    private MenuFen fenMenu;
    //Pour le deplacement
    private Pion lePion;
    private int deplacement = -1;
    private boolean etat;


    /**
     * Role : permet de créer un objet Jeu avec des paramètres précis
     *
     * @param joueur1       le premier Joueur
     * @param joueur2       le deuxième joueur
     * @param modeGraphique le mode d'affichage du jeu choisi
     */
    public Jeu(Joueur joueur1, Joueur joueur2, boolean modeGraphique, boolean ia) {
        this.joueur1 = joueur1;
        this.joueur2 = joueur2;
        this.lePlateau = new Plateau(this.joueur1, this.joueur2);
        this.modeGraphique = modeGraphique;
        this.aLaMain = this.joueur1;
        this.ia = ia;
    }

    public Jeu(Joueur joueur1, Joueur joueur2, boolean modeGraphique, boolean ia, MenuFen fenMenu) {
        this.joueur1 = joueur1;
        this.joueur2 = joueur2;
        this.lePlateau = new Plateau(this.joueur1, this.joueur2);
        this.modeGraphique = modeGraphique;
        this.aLaMain = this.joueur1;
        this.fenMenu = fenMenu;
        this.ia = ia;
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
     *
     * @return le fichier chargé
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
     * cette méthode permet de charger une partie en passant le nom en parametre
     *
     * @param chemin le chemin jusqu'à la sauvegarde
     * @return le fichier chargé
     */
    public static Jeu chargerJeu(String chemin) {
        Jeu ret = null;
        if (Sauvegarde.charger(chemin) != null) {
            ret = Sauvegarde.charger(chemin);
        } else {
            EventQueue.invokeLater(() -> new MenuFen().setVisible(true));
        }
        return ret;
    }

    /**
     * Role : Cette methode permet de sauvegarder une partie
     *
     * @param chemin chemin pour la sauvegarde
     */
    public void sauvegarderJeu(String chemin) {
        Sauvegarde.sauvegarder(chemin, this);
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
        String sauvegarder;
        Scanner sc = new Scanner(System.in);
        this.ia = ia;

        if (!this.modeGraphique) {

            tutoriel();

            System.out.println("\n\n== Debut de partie ==");

            PlateauTxt.afficherPlateau(this.lePlateau);
            while (!partieGagne) {
                System.out.println("C'est au tour de " + this.aLaMain.getNom());

                deplacementAFaire(ia, deplacementFait, false);
                Jeu.blanc();
                PlateauTxt.afficherPlateau(this.getLePlateau());
                partieGagne = this.lePlateau.verifVictoire(this.aLaMain);

                if (!partieGagne) {
                    changerMain();
                    System.out.println("\nVoulez vous sauvegarder la partie ? (o/n)");
                    sauvegarder = sc.nextLine();
                    while (!sauvegarder.equals("o") && !sauvegarder.equals("n")) {
                        System.out.println("Veuillez realiser une saisie correcte.");
                        sauvegarder = sc.nextLine();
                    }
                    if (sauvegarder.equals("o")) {
                        System.out.println("\nEntrer le nom de votre fichier");
                        String chemin = sc.nextLine();
                        sauvegarderJeu(chemin);
                        System.out.println("\nPartie sauvegardee avec succes. Nous esperons vous revoir bientot !");
                        System.exit(0);
                    }

                }
                deplacementFait = false;
            }
            System.out.println("\nFin du jeu ! Victoire de " + this.aLaMain.getNom() + " !! :)");
        }
    }

    /**
     * Permet de choisir le pion à jouer pour la méthode debutPartie()
     *
     * @param ia permet de savoir si un joueur est un ia
     * @return le nombre du pion à bouger
     */
    private int choixPion(boolean ia, boolean g) {
        Scanner sc = new Scanner(System.in);
        int ret = -1;
        boolean verif = false;

        if (!ia || aLaMain.equals(joueur1)) {
            System.out.println("\nVeuillez choisir le pion que vous souhaitez deplacer.");
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

        if (!g) {
            System.out.println("Le pion choisi est le " + ret);
        }

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
            System.out.println("\nVoulez vous liberer le pion situe sous celui que vous deplacez ? (o/n)");
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

    public boolean getIAPresente() {
        return ia;
    }

    public void setEtat() {
        this.etat = !etat;
    }

    public void setEtat(boolean etat){
        this.etat = etat;
    }

    public void setLePion(Pion lePion) {
        if (lePion.getLeJoueur().equals(this.aLaMain)) {
            this.lePion = lePion;
        } else {
            System.out.println("Ce n'est pas l'un de vos pions");
        }
    }

    public void setDeplacement(int deplacement) {
        this.deplacement = deplacement;
    }

    public boolean deplacement() {
        boolean ret;
        boolean partieGagne;
        boolean deplacementFait = false;

        if (this.deplacement != -1 && this.lePion != null) {
            ret = this.lePlateau.deplacerPion(this.lePion, this.deplacement, this.etat, true);
            if (ret) {
                partieGagne = this.lePlateau.verifVictoire(this.aLaMain);
                if (partieGagne) {
                    this.fenMenu.getBarreInfo().messageVictoire(aLaMain);
                } else {
                    changerMain();
                    if (ia) {
                        deplacementAFaire(ia, deplacementFait, true);
                        changerMain();
                    }
                    this.fenMenu.getBarreInfo().setText(this.aLaMain);
                    this.fenMenu.repaint();
                    this.fenMenu.revalidate();
                }
            }
        } else {
            ret = false;
        }
        this.deplacement = -1;
        this.lePion = null;

        return ret;
    }

    private void deplacementAFaire(boolean ia, boolean deplacementFait, boolean graphique) {
        int pionChoisi;
        Pion aDeplacer;
        int placement;
        boolean libererPion;

        while (!deplacementFait) {
            pionChoisi = choixPion(ia, graphique);
            aDeplacer = lePlateau.getPion(pionChoisi);
            if(!ia || aLaMain.equals(joueur1)){
                System.out.println("\nVoulez vous reveler ce qui se trouve sous votre pion ? (o/n)");
                Scanner sc = new Scanner(System.in);
                String saisie = sc.nextLine();
                while (!saisie.equals("o") && !saisie.equals("n")){
                    System.out.println("Veuillez realiser une saisie correcte.");
                }
                if(saisie.equals("o")){
                    if(aDeplacer.getAMange() != null){
                        if(aDeplacer.getLeJoueur().equals(aLaMain)) {
                            System.out.println("\nVotre pion contient un autre de vos pion de taille " + aDeplacer.getAMange().getTAILLE() + "\n");
                        }
                        else{
                            System.out.println("\nVotre pion contient un pion adverse de taille " + aDeplacer.getAMange().getTAILLE() + "\n");
                        }
                    }
                    else{
                        System.out.println("\nVotre pion n'a rien a declarer.\n");
                    }
                }
            }
            placement = this.aLaMain.jouer();
            libererPion = libererPion(ia, aDeplacer);
            deplacementFait = this.lePlateau.deplacerPion(aDeplacer, placement, libererPion, graphique);
        }
    }

    /**
     * Accesseur pour récuperer le pion
     * @return le pion choisi en graphique
     */
    public Pion getLePion() {
        return lePion;
    }

}
