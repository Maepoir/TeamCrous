package arcanor.iu.console;

import arcanor.modele.Plateau;
import arcanor.modele.Joueur;

/** permet d'afficher le plateau de jeu sur la console
* @author G.Renault, M.Poiré, S.Bay, M.Racinne-Divet */
public class PlateauTxt {

    private Plateau plateau;
    private Joueur j1;
    private Joueur j2;

  /**permet d'afficher le plateau et différents éléments de jeu sur la console */
  public static void afficherPlateau(Plateau plateau){
      System.out.println("Le joueur 1 dispose des pions 1 a 12 et le joueur 2 des pions 13 a 24.");
      for(int i = 0; i < 8; i++){
          for(int j = 0; j < 7; j++){
              if (plateau.getPion(i,j) == null) {
                  System.out.print("\t|");
              } else {
                  System.out.print("t" + plateau.getPion(i,j).getTAILLE()+ plateau.getPion(i,j).getLeJoueur().getNom() + "(" + plateau.getPion(i,j).getNum() +")|");
              }
          }
          System.out.println("\n\n - - - - - - - - - - - - - - - - - - - - - - - - - - - - - ");
      }
  }

}
