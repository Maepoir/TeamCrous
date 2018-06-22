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
  }

  private void initPions (){

      for(int i = 0; i < this.lePlateau.length; i++){
          for(int j = 0; j < this.lePlateau[0].length;j++){
              this.lePlateau [i] [j] = null;
          }
      }

//    Initialisation des pions du joueur 1
      this.lePlateau[0][0] = new Pion(2, false, new Pion(1, true, null, 0, 0, this.j1,1), 0, 0, this.j1,2);
      this.lePlateau[1][0] = new Pion(4, false, new Pion(3, true, null, 1, 0, this.j1,3), 1, 0, this.j1,4);
      this.lePlateau[3][0] = new Pion(2, false, new Pion(1, true, null, 3, 0, this.j1,5), 3, 0, this.j1,6);
      this.lePlateau[4][0] = new Pion(4, false, new Pion(3, true, null, 4, 0, this.j1,7), 4, 0, this.j1,8);
      this.lePlateau[6][0] = new Pion(2, false, new Pion(1, true, null, 6, 0, this.j1,9), 6, 0, this.j1,10);
      this.lePlateau[7][0] = new Pion(4, false, new Pion(3, true, null, 7, 0, this.j1,11), 7, 0, this.j1,12);

//    Initialisation des pions du joueur 2
      this.lePlateau[1][6] = new Pion(2, false, new Pion(1, true, null, 1, 6, this.j2,13), 1, 6, this.j2,14);
      this.lePlateau[0][6] = new Pion(4, false, new Pion(3, true, null, 0, 6, this.j2,15), 0, 6, this.j2,16);
      this.lePlateau[4][6] = new Pion(2, false, new Pion(1, true, null, 4, 6, this.j2,17), 4, 6, this.j2,18);
      this.lePlateau[3][6] = new Pion(4, false, new Pion(3, true, null, 3, 6, this.j2,19), 3, 6, this.j2,20);
      this.lePlateau[7][6] = new Pion(2, false, new Pion(1, true, null, 7, 6, this.j2,21), 7, 6, this.j2,22);
      this.lePlateau[6][6] = new Pion(4, false, new Pion(3, true, null, 6, 6, this.j2,23), 6, 6, this.j2,24);
  }

  /**
   * Role : Cette méthode permet de deplacer un pion
   * @param lePion le pion que l'on souhaite deplacer
   * @param i le numéro du déplacement a effectuer
   * @param libere true si on libère le pion caché, faux sinon
   */
  public boolean deplacerPion(Pion lePion , int i, boolean libere){
      boolean ret = false;
      Pion cache = null;
      int x1 = lePion.getX();
      int y1 = lePion.getY();
      if (libere) {
          cache = lePion.getAMange();
          lePion.setAMange(null);
          cache.setEstMange(false);
          cache.setXY(lePion.getX(), lePion.getY());
      }
      this.lePlateau[lePion.getX()][lePion.getY()] = null;
      int x = deplacementPossibles(lePion)[i][0];
      int y = deplacementPossibles(lePion)[i][1];
      if (x != -1 && y != -1) {
          this.lePlateau[x][y] = lePion;
          lePion.setXY(x, y);
          if (lePion.getAMange() != null) {
              lePion.getAMange().setXY(x, y);
          }
          ret = true;
      } else {
          System.out.println("Déplacement hors des limites, veuillez choisir un autre déplacement s'il vous plait.");
      }
      if (libere) {
          this.lePlateau[x1][y1] = cache;
      }

      Jeu.blanc();
      PlateauTxt.afficherPlateau(this);
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
//      Solution 0
      if(lePion.getX() - 1 >= 0 && lePion.getY() - 1 >= 0) {
          ret[0][0] = lePion.getX() - 1;
          ret[0][1] = lePion.getY() - 1;
      } else {
          ret [0][0] = -1;
          ret [0][1] = -1;
      }

//      Solution 1
      if(lePion.getX()-1>=0) {
          ret[1][0] = lePion.getX() - 1;
          ret[1][1] = lePion.getY();
      } else {
          ret [1][0] = -1;
          ret [1][1] = -1;
      }


//      Solution 2
      if(lePion.getX()-1>=0 && lePion.getY()+1<7) {
          ret[2][0] = lePion.getX() - 1;
          ret[2][1] = lePion.getY() + 1;
      } else {
          ret [2][0] = -1;
          ret [2][1] = -1;
      }

//      Solution 3
      if(lePion.getY()+1<7) {
          ret[3][0] = lePion.getX();
          ret[3][1] = lePion.getY() + 1;
      } else {
          ret [3][0] = -1;
          ret [3][1] = -1;
      }

//      Solution 4
      if(lePion.getX()+1<8 && lePion.getY()+1<7) {
          ret[4][0] = lePion.getX() + 1;
          ret[4][1] = lePion.getY() + 1;
      } else {
          ret [4][0] = -1;
          ret [4][1] = -1;
      }


//      Solution 5
      if(lePion.getX()+1<8) {
          ret[5][0] = lePion.getX() + 1;
          ret[5][1] = lePion.getY();
      } else {
          ret [5][0] = -1;
          ret [5][1] = -1;
      }

//      Solution 6
      if(lePion.getX()+1<8 && lePion.getY()-1>=0) {
          ret[6][0] = lePion.getX() + 1;
          ret[6][1] = lePion.getY() - 1;
      } else {
          ret [6][0] = -1;
          ret [6][1] = -1;
      }

//      Solution 7
      if(lePion.getY()-1>=0) {
          ret[7][0] = lePion.getX();
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
     * @param num le numéro du pion
     * @return le pion correspondant dans la grille
     */
    Pion getPion(int num){
    Pion ret = null;
        for (Pion[] aLePlateau : this.lePlateau) {
            for (int j = 0; j < this.lePlateau[0].length; j++) {
                if ((aLePlateau[j] != null) && (aLePlateau[j].getNum() == num)) {
                    ret = aLePlateau[j];
                }
            }
        }
    return ret;
  }

    /**
     * Recupere un pion en fonction de ses coordonnées
     * @param x coordonnée x
     * @param y coordonnée y
     * @return le pion en coordonnée x y
     */
  public Pion getPion(int x ,int y){
      return this.lePlateau[x][y];
  }

    /**
     * Vérifie si les conditions de victoire du joueur passé en paramtètre sont réunies
     * @param j le joueur a vérifié
     * @return true si le joueur a réuni les conditions de victoire, false sinon
     */
    boolean verifVictoire(Joueur j){
      boolean ret = false;
      int score = 0;
      if(j.equals(j1)){
          for (Pion[] aLePlateau : this.lePlateau) {
              if ((aLePlateau[6] != null) && (aLePlateau[6].getLeJoueur().equals(j))) {
                  score += 5 - aLePlateau[6].getTAILLE();
              }
          }
      }
      else if(j.equals(j2)){
          for (Pion[] aLePlateau : this.lePlateau) {
              if ((aLePlateau[0] != null) && (aLePlateau[0].getLeJoueur().equals(j))) {
                  score += 5 - aLePlateau[0].getTAILLE();
              }
          }
      }
      if(score >= 12){ret = true;}

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
