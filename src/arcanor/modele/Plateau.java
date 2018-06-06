package arcanor.modele;
/**
 * Role : Cette classe modélise le Plateau de jeu de Arcanor
 * @author S.Bay ,M.Racine,M.Poiré G.Renault
 *  *
*/
public class Plateau {

  //la grille de jeu
  public Pion[][] lePlateau;

  /**
   * Role : Cette méthode permet de créer un objet Plateau
   */
  public Plateau(){
      this.lePlateau = new Pion[8][7];
  }

  public void initializePions (Joueur j1, Joueur j2){

//    Initialisation des pions du joueur 1
      this.lePlateau[0][0] = new Pion(2, false, new Pion(1, true, null, 0, 0, j1), 0, 0, j1);
      this.lePlateau[1][0] = new Pion(4, false, new Pion(3, true, null, 0, 0, j1), 0, 0, j1);
      this.lePlateau[3][0] = new Pion(2, false, new Pion(1, true, null, 0, 0, j1), 0, 0, j1);
      this.lePlateau[4][0] = new Pion(4, false, new Pion(3, true, null, 0, 0, j1), 0, 0, j1);
      this.lePlateau[6][0] = new Pion(2, false, new Pion(1, true, null, 0, 0, j1), 0, 0, j1);
      this.lePlateau[7][0] = new Pion(4, false, new Pion(3, true, null, 0, 0, j1), 0, 0, j1);

//    Initialisation des pions du joueur 2
      this.lePlateau[0][6] = new Pion(2, false, new Pion(1, true, null, 0, 0, j2), 0, 0, j2);
      this.lePlateau[1][6] = new Pion(4, false, new Pion(3, true, null, 0, 0, j2), 0, 0, j2);
      this.lePlateau[3][6] = new Pion(2, false, new Pion(1, true, null, 0, 0, j2), 0, 0, j2);
      this.lePlateau[4][6] = new Pion(4, false, new Pion(3, true, null, 0, 0, j2), 0, 0, j2);
      this.lePlateau[6][6] = new Pion(2, false, new Pion(1, true, null, 0, 0, j2), 0, 0, j2);
      this.lePlateau[7][6] = new Pion(4, false, new Pion(3, true, null, 0, 0, j2), 0, 0, j2);
  }

  /**
   * Role : Cette méthode permet de deplacer un pion
   * @param lePion le pion que l'on souhaite deplacer
   * @param x la coordonnée en abscisse
   * @param y La coordonnée en coordonnée
   */
  public void deplacerPion(Pion lePion , int x, int y){
    this.lePlateau [x][y] = lePion;
    lePion.setXY(x,y);
  }

  /**
   * Role : Cette méthode permet de manger un pion
   * @param mangeur le pion qui mange
   * @param mange le pion qui est mangé
   */
  public void manger(Pion mangeur,Pion mange){
    mangeur.setAMange(mange);
    mange.setEstMange(true);
  }

  /**
   * Role : Cette méthode permet de connaitre les deplacements possible d'un pion
   * @param lePion le pion que l'on veut deplacer
   * @return les coordonnées de déplacements possibles
  */
  public int[][] deplacementPossibles(Pion lePion){
      int [][] ret = new int[8][2];
//      Solution 1
      if(lePion.getX()+1<8 && lePion.getY()+1<7) {
          ret[0][0] = lePion.getX() + 1;
          ret[0][1] = lePion.getY() + 1;
      } else {
          ret [0][0] = -1;
          ret [0][1] = -1;
      }

//      Solution 2
      if(lePion.getX()+1<8) {
          ret[1][0] = lePion.getX() + 1;
          ret[1][1] = lePion.getY();
      } else {
          ret [1][0] = -1;
          ret [1][1] = -1;
      }

//      Solution 3
      if(lePion.getX()+1<8 && lePion.getY()-1>=0) {
          ret[2][0] = lePion.getX() + 1;
          ret[2][1] = lePion.getY() - 1;
      } else {
          ret [2][0] = -1;
          ret [2][1] = -1;
      }

//      Solution 4
      if(lePion.getY()+1<7) {
          ret[3][0] = lePion.getX();
          ret[3][1] = lePion.getY() + 1;
      } else {
          ret [3][0] = -1;
          ret [3][1] = -1;
      }

//      Solution 5
      if(lePion.getY()-1>=0) {
          ret[4][0] = lePion.getX();
          ret[4][1] = lePion.getY() - 1;
      } else {
          ret [4][0] = -1;
          ret [4][1] = -1;
      }

//      Solution 6
      if(lePion.getX()-1>=0 && lePion.getY()+1<7) {
          ret[5][0] = lePion.getX() - 1;
          ret[5][1] = lePion.getY() + 1;
      } else {
          ret [5][0] = -1;
          ret [5][1] = -1;
      }

//      Solution 7
      if(lePion.getX()-1>=0) {
          ret[6][0] = lePion.getX() - 1;
          ret[6][1] = lePion.getY();
      } else {
          ret [6][0] = -1;
          ret [6][1] = -1;
      }

//      Solution 8
      if(lePion.getX()-1>=0 && lePion.getY()-1>=0) {
          ret[7][0] = lePion.getX() - 1;
          ret[7][1] = lePion.getY() - 1;
      } else {
          ret [7][0] = -1;
          ret [7][1] = -1;
      }

//      Return -1 dans le tableau si le pion ne peut pas aller dans cette direction
      return ret ;
  }

    /**
     * Role : Cette méthode permet de recuperer un pion
     * @param x la coordonnée en abscisse
     * @param y La coordonnée en coordonnée
     * @return le pion correspondant dans la grille
     */
  public Pion getPion(int x ,int y){
    return this.lePlateau[x][y];
  }
}
