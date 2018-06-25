package arcanor.modele;

import arcanor.iu.console.PlateauTxt;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.util.Random;
import java.util.Scanner;

/**
 * Role :  Cette classe permet de modeliser le jeu d'Arcanor
 *
 * @author S.Bay ,M.Racine,M.Poiré G.Renault
 */
public class Jeu {

    private Plateau lePlateau;
    //le premier joueur
    private Joueur joueur1;
    //le deuxième joueur
    private Joueur joueur2;
    //le fichier de sauvegarde de la partie
    //private Sauvegarde sauvegardeur;
    //correspond au mode de jeu choisi
    private ModeJeu modeJeu;
    //permet de sauvegarder le temps de jeu des joueurs
    private long tempsJeu;
    // détermine si le jeu doit s'afficher en mode graphique ou console
    private boolean modeGraphique;
    //le joueur qui a la main
    private Joueur aLaMain;
    //fenêtre de jeu graphique
    //private JeuFen jeuG;


    /**
     * Role : permet de créer un objet Jeu avec des paramètres précis
     *
     * @param joueur1       le premier Joueur
     * @param joueur2       le deuxième joueur
     * @param modeJeu       le mode de jeu choisi
     * @param modeGraphique le mode d'affichage du jeu choisi
     */
    public Jeu(Joueur joueur1, Joueur joueur2, ModeJeu modeJeu, boolean modeGraphique) {
        this.joueur1 = joueur1;
        this.joueur2 = joueur2;
        this.lePlateau = new Plateau(this.joueur1, this.joueur2);
        this.modeJeu = modeJeu;
        this.modeGraphique = modeGraphique;
        this.aLaMain = this.joueur1;
    }

    /**
     * Role : Cette methode permet de sauvegarder une partie
     * @param chemin chemin pour la sauvegarde
     */
    /*public void sauvegarderJeu(String chemin){
     this.sauvegardeur = new Sauvegarde(this.lePlateau, this.arrayJoueur, this.modeJeu, this.tempsJeu, this.modeGraphique);
     this.sauvegardeur.sauvegarder(chemin);
     } */

    /**
     * Role : Cette methode permet de charger une partie
     * @param chemin chemin de la sauvegarde
     */

    /*public void chargerJeu(String chemin){
     ArrayList <Object> list = new ArrayList<Object>();
     if(this.sauvegardeur != null){
     list = this.sauvegardeur.charger(chemin);
     if(list != null){
     this.lePlateau = (Plateau)(list.get(0));
     this.arrayJoueur = (Joueur[])(list.get(1));
     this.modeJeu = (int)(list.get(2));
     this.tempsJeu = (long)(list.get(3));
     this.modeGraphique = (boolean)(list.get(4));
     }
     else{
     System.out.println("fichier introuvable, création d'une nouvelle partie");
     Partie partie = new Partie();
     }
     }
     else{System.out.print("chargement impossible, aucune sauvegarde effectuée.");}
     } */

    /**
     * Permet de passer des lignes pour ne pas que la console soit surchargée
     */
    static void blanc() {
        System.out.println("\n\n\n\n\n\n\n\n\n\n");
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
     * Role : Cette methode permet de recuperer le temps de jeu
     *
     * @return temps de jeu
     */
    public long getTempsJeu() {
        return this.tempsJeu;
    }

    /**
     * Role : Cette methode permet de modifier le temps de jeu
     *
     * @param tempsJeu le temps de jeu que l'on souhaite modifier
     */
    public void setTempsJeu(long tempsJeu) {
        this.tempsJeu = tempsJeu;
    }

    /**
     * Role : Cette methode permet de recuperer le mode de jeu
     *
     * @return le mode de jeu choisi par l'utilisateur
     */
    public ModeJeu getModeJeu() {
        return this.modeJeu;
    }

    /**
     * Role : Cette methode permet de modifier le mode de jeu
     *
     * @param modeJeu le choix de mode de jeu de l'utilisateur
     */
    public void setModeJeu(ModeJeu modeJeu) {
        this.modeJeu = modeJeu;
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

        if (!this.modeGraphique) {

//            tutoriel();

            System.out.println("== Début de partie ==");
            try {
                Thread.sleep(500);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
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
                    System.out.println("C'est au tour de " + this.aLaMain.getNom());
                }
                deplacementFait = false;
            }
            System.out.println("Fin du jeu ! Victoire de " + this.aLaMain.getNom() + " !! :)");
        }
        //mode graphique
        else {
            System.out.println("Non gere pour l'instant");
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
