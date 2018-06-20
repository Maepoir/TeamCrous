package arcanor.modele;
import java.util.Scanner;
/**
 * Rôle :  Cette classe permet de modéliser un joueur humain
 * @author M.Poiré, S.Bay
 */
public class JoueurHumain extends Joueur{

   /** construit la classe IA
   * @param niveau difficulté choisie par le joueur
   * @param nom nom/pseudo  du joueur
   * @param couleur couleur des pions
   * @param aLaMain true si le joueur  a la main
   */
   public JoueurHumain(String nom, Couleur couleur){
     super(nom,couleur);
   }

   /** permet de faire le choix de déplacement du pion
   * @return int le numéro correspondant au déplacement */
   public int jouer(){
     Scanner sc = new Scanner(System.in);
     System.out.println("|\t0|\t1|\t2| \n |\t7|\tPion|\t3| \n |\t6|\t5|\t4");
     System.out.println("saisir le numéro correspondant au déplacement choisi : ");
     int deplacement = sc.nextInt();
     return deplacement;
   }

}
