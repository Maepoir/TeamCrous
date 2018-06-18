package arcanor.iu.console;

import arcanor.modele.Plateau;
import arcanor.modele.Joueur;

/** permet d'afficher le plateau de jeu sur la console
* @author G.Renault, M.Poiré, S.Bay, M.Racinne-Divet */
public class PlateauTxt {

    private Plateau plateau;
    private Joueur j1;
    private Joueur j2;

    public PlateauTxt (Plateau plateau, Joueur j1, Joueur j2){
        this.plateau = plateau;
        this.j1 = j1;
        this.j2 = j2;
    }

  /**permet d'afficher le plateau et différents éléments de jeu sur la console */
  public void afficherPlateau(){
      int nbPion = 1;
      for(int i = 0; i < this.plateau.lePlateau[0].length; i++){
          for(int j = 0; j < this.plateau.lePlateau.length; j++){
              if (this.plateau.getPion(j,i) == null) {
                  System.out.print("\t|");
              } else if (this.plateau.getPion(j,i).getLeJoueur()== this.j1 ) {
                  System.out.print("t" + this.plateau.getPion(j,i).getTAILLE()+ "j1" + "(" + nbPion +")|");
                  nbPion++;
              } else if (this.plateau.getPion(j,i).getLeJoueur()== this.j2) {
                  System.out.print("t" + this.plateau.getPion(j,i).getTAILLE()+ "j2" + "(" + nbPion +") |");
                  nbPion++;
              }

          }
          System.out.println("\n\n - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - ");
      }
  }

}
