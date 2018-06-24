package arcanor.modele;
/**
 * Rôle :  Cette classe permet de modéliser l'intelligence artificielle
 * contre laquelle le joueur peu jouer lorsqu'il est seul.
 * @author G.Renault, M.Poiré, S.Bay, M.Racinne-Divet
 */
public class IA extends Joueur{

   //représente la difficulté de l'ordinateur
   private int difficulte;

   /** construit la classe IA
   * @param  niveau difficulté choisie par le joueur
   * @param nom nom/pseudo  du joueur
   * @param couleur couleur des pions
   */
   public IA (String nom, Couleur couleur, int niveau){
     super(nom,couleur);
     this.difficulte = niveau;
   }

   /** Rôle : permet de lancer une partie contre l'intelligence
   * artificielle du jeu.
   * @return le déplacement choisi*/
   public int jouer(){
     int deplacement = (int)(Math.random() * 8);
     return deplacement;
   }

   /** Rôle : permet d'accéder au niveau de difficulté de l'intelligence
   * artificielle en dehors de la classe IA
   * @return le niveau de difficulté de l'intelligence artificielle*/
   public int getDifficulte(){
     int ret = 0;
     return ret;
   }

   /** Rôle : permet de modifier le niveau de l'IA
   * @param difficulte le nouveau niveau de difficulte */
   public void setDifficulte (int difficulte){
     this.difficulte = difficulte;
   }


 }
