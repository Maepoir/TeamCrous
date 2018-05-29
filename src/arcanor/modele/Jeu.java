package arcanor.modele;
import arcanor.*;
import java.util.*;
/**
 * Role :  Cette classe permet de modeliser le jeu d'Arcanor
 * @author S.Bay ,M.Racine,M.Poiré G.Renault
 *
 */
public class Jeu{

  //les différents mode de jeu
  public final int MODEFACILE = 0;
  public final int MODENORMAL = 1;
  public final int MODEDIFFICILE =2;

  private Plateau lePlateau;
  //la liste de joueurs
  private Joueur[] arrayJoueur;

  //le fichier de sauvegarde de la partie
  private Sauvegarde sauvegardeur;
  //correspond au mode de jeu choisi
  private int modeJeu;
  //permet de sauvegarder le temps de jeu des joueurs
  private long tempsJeu;
  // détermine si le jeu doit s'afficher en mode graphique ou console
  private boolean modeGraphique;

  //fenêtre de jeu graphique
  //private JeuFen jeuG;
  //affichage du jeu sur console
  //private JeuTxt jeuC;

  /**
   * Role : Cette methode permet de creer un objet Jeu
   */
  public Jeu(boolean modeGraphique){
    this.modeGraphique = modeGraphique;
  }

  /**
   * Role : Cette methode permet de sauvegarder une partie
   * @param path chemin pour la sauvegarde
   */
   public void sauvegarderJeu(String chemin){
     this.sauvegardeur = new Sauvegarde(this.lePlateau, this.arrayJoueur, this.modeJeu, this.tempsJeu, this.modeGraphique);
     this.sauvegardeur.sauvegarder(chemin);
   }

   /**
    * Role : Cette methode permet de charger une partie
    * @param path chemin de la sauvegarde
    */
  public void chargerJeu(String chemin){
    ArrayList chargement;
    if(this.sauvegardeur != null){
      chargement = this.sauvegardeur.charger(chemin);
      this.lePlateau = (Plateau)(chargement.get(0));
      this.arrayJoueur = (Joueur[])chargement.get(1);
      this.modeJeu = (int)(chargement.get(2));
      this.tempsJeu = (long)(chargement.get(3));
      this.modeGraphique = (boolean)(chargement.get(4));
    }
    else{System.out.print("chargement impossible, aucune sauvegarde effectuée.");}
  }

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
    if(this.arrayJoueur[0].getALaMain()){
      this.arrayJoueur[1].setALaMain(true);
      this.arrayJoueur[0].setALaMain(false);
    }
    else{
      this.arrayJoueur[0].setALaMain(true);
      this.arrayJoueur[1].setALaMain(false);
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
   public int getModeJeu(){
     int ret = this.modeJeu;
     return ret;
   }

   /**
    * Role : Cette methode permet de modifier le mode de jeu
    * @param modeJeu le choix de mode de jeu de l'utilisateur
    */
    public void setModeJeu(int modeJeu){
      this.modeJeu = modeJeu;
    }

  /**
  * Role : permet la génération du menu de jeu graphiquement ou via console
  */
   public void menu(){
     if(!this.modeGraphique){
       //this.jeuC.getMenuTxt().display();
     }
   }

    /**
    * Role : permet de mettre à jour l'affichage du plateau suite aux déplacements
    * des pions
    */
    public void rafraichirPlateau(){
      if(!this.modeGraphique){
        //this.jeuC.getPlateauTxt().display();
      }
    }

    /**
     * Role : permet de lancer un tutoriel pour apprendre au joueur à jouer à
     * Arcanor
     */
       public void tutoriel(){
         String tuto = "";
         System.out.println(tuto);
       }
}
