package test;
import static org.junit.Assert.*;
import org.junit.Test;

public class TestPlateau {
  @Test
  public void testDeplacerPion(){

   Plateau plat = new Plateau();
   Pion p = new Pion(2);
   plat.deplacerPion(p,0,0);
   this.assertEquals(p,plat.getPion(0,0) );
  }
  @Test
  public void testManger(){

    Pion p1 = new Pion(3);
    Pion p2 = new Pion(2);
    Plateau plat = new Plateau();
    plat.mange(p1,p2);
    this.assertEquals(p2 , p1.getAMange() );
    this.assertEquals(p1 , p2.getEstMange() );
  }
  @Test
  public void testDeplacementsPossibles(){
    Pion p = new Pion(3);
    Plateau plat = new Plateau();
    plat.deplacerPion(p,2,2);
    int[][] deplacements;
    int[][] resultat = new int[4][2];
    resultat[0][0] = 3;
    resultat[0][1] = 2;
    resultat[1][0] = 1;
    resultat[1][1] = 2;
    resultat[2][0] = 2;
    resultat[2][1] = 3;
    resultat[3][0] = 2;
    resultat[3][1] = 1;
    deplacements = plat.deplacementPossibles(p);
    this.assertEquals(resultat[0][0] , deplacements[0][0]) ;
    this.assertEquals(resultat[0][1] , deplacements[0][1] );
    this.assertEquals(resultat[1][0] , deplacements[1][0]) ;
    this.assertEquals(resultat[1][1] , deplacements[1][1] );
    this.assertEquals(resultat[2][0] , deplacements[2][0]) ;
    this.assertEquals(resultat[2][1] , deplacements[2][1] );
    this.assertEquals(resultat[3][0] , deplacements[3][0]) ;
    this.assertEquals(resultat[3][1] , deplacements[3][1] );

    plat.deplacerPion(p,0,0);
    resultat = new int[4][2];
    resultat[0][0] = 1;
    resultat[0][1] = 0;
    resultat[1][0] = null;
    resultat[1][1] = null;
    resultat[2][0] = 0;
    resultat[2][1] = 1;
    resultat[3][0] = null;
    resultat[3][1] = null;
    deplacements = plat.deplacementPossibles(p);
    this.assertEquals(resultat[0][0] , deplacements[0][0]) ;
    this.assertEquals(resultat[0][1] , deplacements[0][1] );
    this.assertEquals(resultat[1][0] , deplacements[1][0]) ;
    this.assertEquals(resultat[1][1] , deplacements[1][1] );
    this.assertEquals(resultat[2][0] , deplacements[2][0]) ;
    this.assertEquals(resultat[2][1] , deplacements[2][1] );
    this.assertEquals(resultat[3][0] , deplacements[3][0]) ;
    this.assertEquals(resultat[3][1] , deplacements[3][1] );

    plat.deplacerPion(p,0,6);
    resultat = new int[4][2];
    resultat[0][0] = 1;
    resultat[0][1] = 6;
    resultat[1][0] = null;
    resultat[1][1] = null;
    resultat[2][0] = null;
    resultat[2][1] = null;
    resultat[3][0] = 0;
    resultat[3][1] = 5;
    deplacements = plat.deplacementPossibles(p);
    this.assertEquals(resultat[0][0] , deplacements[0][0]) ;
    this.assertEquals(resultat[0][1] , deplacements[0][1] );
    this.assertEquals(resultat[1][0] , deplacements[1][0]) ;
    this.assertEquals(resultat[1][1] , deplacements[1][1] );
    this.assertEquals(resultat[2][0] , deplacements[2][0]) ;
    this.assertEquals(resultat[2][1] , deplacements[2][1] );
    this.assertEquals(resultat[3][0] , deplacements[3][0]) ;
    this.assertEquals(resultat[3][1] , deplacements[3][1] );
  }
}
