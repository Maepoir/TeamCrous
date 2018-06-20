package arcanor.modele;
import java.util.*;
import arcanor.Sauvegarde;
import arcanor.*;
import arcanor.iu.console.*;
import arcanor.iu.graphique.*;

/**
 * Role :  Cette classe permet de modeliser le jeu d'Arcanor
 * @author S.Bay ,M.Racine,M.Poiré G.Renault
 *
 */
public class Jeu{

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


  /** Role : permet de créer un objet Jeu avec des paramètres précis
  * @param joueur1 le premier Joueur
  * @param joueur2 le deuxième joueur
  * @param plateau le plateau de jeu
  * @param modeJeu le mode de jeu choisi
  * @param modeGraphique le mode d'affichage du jeu choisi */
  public Jeu(Joueur joueur1, Joueur joueur2, ModeJeu modeJeu, boolean modeGraphique){
    this.joueur1 = joueur1;
    this.joueur2 = joueur2;
    this.lePlateau = new Plateau(this.joueur1, this.joueur2);
    this.modeJeu = modeJeu;
    this.modeGraphique = modeGraphique;
  }

  /**
   * Role : Cette methode permet de sauvegarder une partie
   * @param chemin chemin pour la sauvegarde
   */
   /**public void sauvegarderJeu(String chemin){
     this.sauvegardeur = new Sauvegarde(this.lePlateau, this.arrayJoueur, this.modeJeu, this.tempsJeu, this.modeGraphique);
     this.sauvegardeur.sauvegarder(chemin);
   } */

   /**
    * Role : Cette methode permet de charger une partie
    * @param chemin chemin de la sauvegarde
    */
  /**public void chargerJeu(String chemin){
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
  * Role : Cette methode permet de changer l'affichage d'un pion (mode triche)
  * @param lePion le pion pour lequel il faut changer l'affichage
  */
  public void changerAffichagePion(Pion lePion, boolean affichage){
    lePion.setAfficherManger(affichage);
  }

  /**
  * Role : Cette methode permet de changer la main d'un joueur pour la donner à
  * l'autre
  */
  public void changerMain(){
    if(aLaMain.equals(joueur1)){
      aLaMain = this.joueur2;
    }
    else{
      aLaMain = this.joueur1;
    }
  }

  /**
  * Role : Cette methode permet de recuperer le temps de jeu
  * @return temps de jeu
  */
  public long getTempsJeu(){
    long ret = this.tempsJeu;
    return ret;
  }

  /**
   * Role : Cette methode permet de modifier le temps de jeu
   * @param tempsJeu le temps de jeu que l'on souhaite modifier
  */
  public void setTempsJeu(long tempsJeu){
    this.tempsJeu = tempsJeu;
  }

  /**
   * Role : Cette methode permet de recuperer le mode de jeu
   * @return le mode de jeu choisi par l'utilisateur
   */
   public ModeJeu getModeJeu(){
     return this.modeJeu;
   }

   /**
    * Role : Cette methode permet de modifier le mode de jeu
    * @param modeJeu le choix de mode de jeu de l'utilisateur
    */
    public void setModeJeu(ModeJeu modeJeu){
      this.modeJeu = modeJeu;
    }

    /**
    * Role : permet de mettre à jour l'affichage du plateau suite aux déplacements
    * des pions
    */
    public void rafraichirPlateau(){
      if(!this.modeGraphique){
//        this.jeuC.getPlateauTxt().display();
      }
    }

    /**
     * Role : permet de lancer un tutoriel pour apprendre au joueur à jouer à
     * Arcanor
     */
       public void tutoriel(){
         String tuto = "";
         System.out.println("tuto");
       }

      /** permet de jouer à Arcanor */
      public void debutPartie(){
        boolean partiFini = false;
        boolean deplacementFait = false;
        boolean partieGagne = false;
        Pion aDeplacer;
        int placement;
        int choixPion;
        if(!this.modeGraphique){
          System.out.println("== Début de partie ==");
          while(!partieGagne){
            while(!deplacementFait){
              Scanner sc = new Scanner(System.in);
              System.out.println("choisir le pion que vous souhaitez jouer : ");
              choixPion = sc.nextInt();
              while((choixPion > 24)||(choixPion < 0)){
                System.out.println("Saisie incorrecte ! saisissez un nombre compris entre 0 et 24 : ");
                choixPion = sc.nextInt();
              }
              aDeplacer = lePlateau.getPion(choixPion);
              placement = this.aLaMain.jouer();
              deplacementFait = this.lePlateau.deplacerPion(aDeplacer, placement);
            }
            partieGagne = this.lePlateau.verifVictoire(this.aLaMain);
            if(!partieGagne){
              changerMain();
              System.out.println("C'est au tour de " + this.aLaMain.getNom());
            }
          }
        }
        else{
          System.out.println("non géré pour l'instant");
        }
      }
      /**Pion ret;
      Scanner sc = new Scanner(System.in);
      System.out.println("choisir le pion que vous souhaitez jouer : ");
      int choixPion = sc.nextInt();
      ret = */
}
