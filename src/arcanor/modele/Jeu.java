package arcanor.modele;
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
  private Joueur[] arrayJoueur;
  //correspond au mode de jeu choisi
  private int modeJeu;
  private long tempsJeu;
  /**
   * Role : Cette methode permet de creer un objet Jeu
   */
  public Jeu(){

  }
  /**
   * Role : Cette methode permet de sauvegarder une partie
   * @param path chemin pour la sauvegarde
   */
   public void sauvegarderJeu(String path){

   }
   /**
    * Role : Cette methode permet de charger une partie
    * @param path chemin de la sauvegarde
    */
  public void chargerJeu(String path){

  }
  /**
  * Role : Cette methode permet de changer l'affichage d'un pion
  * @param lePion le pio npour lequel il faut changer l'affichage
  */
  public void changerAffichagePion(Pion lePion){
  }
  /**
  * Role : Cette methode permet de changer la main d'un joueur pour la donner à
  * l'autre
  */

  public void changerMain(){
  }

  /**
  * Role : Cette methode permet de recuperer le temps de jeu
  * @return temps de jeu
  */
  public long getTempsJeu(){
    long ret = 1;
    return ret;
  }
  /**
   * Role : Cette methode permet de modifier le temps de jeu
   * @param tempsJeu le temps de jeu que l'on souhaite modifier
  */
  public void setTempsJeu(long tempsJeu){

  }
  /**
   * Role : Cette methode permet de recuperer le mode de jeu
   * @return le mode de jeu choisi par l'utilisateur
   */
   public int getModeJeu(){
     int ret =0;
     return ret;
   }
   /**
    * Role : Cette methode permet de modifier le mode de jeu
    * @param modeJeu le choix de mode de jeu de l'utilisateur
    */
    public void setModeJeu(int modeJeu){

    }
  /**
  * Role : permet la génération du menu de jeu graphiquement ou via console
  */
   public void menu(){

   }
    /**
    * Role : permet de mettre à jour l'affichage du plateau suite aux déplacements
    * des pions
    */
    public void rafraichirPlateau(){

    }


    /**
     * Role : permet de lancer un tutoriel pour apprendre au joueur à jouer à
     * Arcanor
     */
       public void tutoriel(){

       }
}
