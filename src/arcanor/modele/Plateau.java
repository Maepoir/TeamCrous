package arcanor.modele;

import arcanor.iu.console.PlateauTxt;

/**
 * Role : Cette classe modélise le Plateau de jeu de Arcanor
 * @author S.Bay ,M.Racine,M.Poiré G.Renault
 *  *
*/
public class Plateau {

  //la grille de jeu
  public Pion[][] lePlateau;
  private Joueur j1;
  private Joueur j2;

  /**
   * Role : Cette méthode permet de créer un objet Plateau
   */
  public Plateau(Joueur j1, Joueur j2){
      this.lePlateau = new Pion[8][7];
      this.j1 = j1;
      this.j2 = j2;
      initPions();
      PlateauTxt.afficherPlateau(this);
  }

  private void initPions (){

      for(int i = 0; i < this.lePlateau.length; i++){
          for(int j = 0; j < this.lePlateau[0].length;j++){
              this.lePlateau [i] [j] = null;
          }
      }

//    Initialisation des pions du joueur 1
      this.lePlateau[0][0] = new Pion(2, false, new Pion(1, true, null, 0, 0, this.j1,1), 0, 0, this.j1,2);
      this.lePlateau[1][0] = new Pion(4, false, new Pion(3, true, null, 0, 0, this.j1,3), 0, 0, this.j1,4);
      this.lePlateau[3][0] = new Pion(2, false, new Pion(1, true, null, 0, 0, this.j1,5), 0, 0, this.j1,6);
      this.lePlateau[4][0] = new Pion(4, false, new Pion(3, true, null, 0, 0, this.j1,7), 0, 0, this.j1,8);
      this.lePlateau[6][0] = new Pion(2, false, new Pion(1, true, null, 0, 0, this.j1,9), 0, 0, this.j1,10);
      this.lePlateau[7][0] = new Pion(4, false, new Pion(3, true, null, 0, 0, this.j1,11), 0, 0, this.j1,12);

//    Initialisation des pions du joueur 2
      this.lePlateau[0][6] = new Pion(2, false, new Pion(1, true, null, 0, 0, this.j2,13), 0, 0, this.j2,14);
      this.lePlateau[1][6] = new Pion(4, false, new Pion(3, true, null, 0, 0, this.j2,15), 0, 0, this.j2,16);
      this.lePlateau[3][6] = new Pion(2, false, new Pion(1, true, null, 0, 0, this.j2,17), 0, 0, this.j2,18);
      this.lePlateau[4][6] = new Pion(4, false, new Pion(3, true, null, 0, 0, this.j2,19), 0, 0, this.j2,20);
      this.lePlateau[6][6] = new Pion(2, false, new Pion(1, true, null, 0, 0, this.j2,21), 0, 0, this.j2,22);
      this.lePlateau[7][6] = new Pion(4, false, new Pion(3, true, null, 0, 0, this.j2,23), 0, 0, this.j2,24);


  }

  /**
   * Role : Cette méthode permet de deplacer un pion
   * @param lePion le pion que l'on souhaite deplacer
   * @param i le numéro du déplacement a effectuer
   */
  public boolean deplacerPion(Pion lePion , int i){
      boolean ret = false;
      this.lePlateau[lePion.getX()][lePion.getY()] = null;
      int x = deplacementPossibles(lePion)[i][0];
      int y = deplacementPossibles(lePion)[i][1];
      if(x != -1 && y != -1){
          this.lePlateau [x][y] = lePion;
          lePion.setXY(x,y);
          PlateauTxt.afficherPlateau(this);
          ret = true;
      }
      else{
          System.out.println("Déplacement hors des limites");
      }
      return ret;
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
      return ret;
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

  public boolean verifVictoire (Joueur j){
      boolean ret = false;
      int score = 0;
      if(j.equals(j1)){
          for(int i = 0; i < this.lePlateau.length; i ++){
              if(this.lePlateau[i][6].getLeJoueur().equals(j)){
                  score += 5 - this.lePlateau[i][6].getTAILLE();
              }
          }
      }
      else if(j.equals(j2)){
          for(int i = 0; i < this.lePlateau.length; i++){
              if(this.lePlateau[i][0].getLeJoueur().equals(j)){
                  score += 5 - this.lePlateau[i][0].getTAILLE();
              }
          }
      }
      if(score >= 7){ ret = true;}

      return ret;
  }

    /**
     * permet de connaitre le joueur 1
     * @return le joueur 1
     */
  public Joueur getJ1() {
      return this.j1;
  }

    /**
     * permet de connaitre le joueur 2
     * @return le joueur 2
     */
  public Joueur getJ2() {
        return this.j2;
  }

}
