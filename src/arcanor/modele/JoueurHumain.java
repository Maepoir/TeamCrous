package arcanor.modele;
/**
 * Rôle :  Cette classe permet de modéliser un joueur humain
 * @author M.Poiré, S.Bay
 */
public class JoueurHumain extends Joueur{

   /** construit la classe IA
   * @param  niveau difficulté choisie par le joueur
   * @param nom nom/pseudo  du joueur
   * @param couleur couleur des pions
   * @param aLaMain true si le joueur  a la main
   */
   public JoueurHumain(String nom, Couleur couleur){
     super(nom,couleur);
   }

   public void jouer(){
     System.out.println("jouer Humain");
   }
}
