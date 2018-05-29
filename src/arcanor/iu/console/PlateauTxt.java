package arcanor.iu.console;

import arcanor.modele.Plateau;

/** permet d'afficher le plateau de jeu sur la console
* @author G.Renault, M.Poiré, S.Bay, M.Racinne-Divet */
public class PlateauTxt {

  /**permet d'afficher le plateau et différents éléments de jeu sur la console */
  public void afficherPlateau(Plateau plateau){
      for(int i = 0; i < plateau.lePlateau.length; i++){
          for(int j = 0; j < plateau.lePlateau[0].length; j++){
              if (plateau.getPion(i,j) == null) {
                  System.out.println("\t ");
              }
              else (plateau.getPion(i,j).getLeJoueur()){

              }
          }
      }
  }

}
