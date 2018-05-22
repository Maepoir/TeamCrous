package test;
import static org.junit.Assert.*;
import org.junit.Test;

public class TestJoueur {
  @Test
  public void testNom(){
    // Cas Normal : le nom entré est une chaine remplie
    Color color = new Color(255,255,255);
    Joueur joueur = new Joueur("RENAULT",color,true);
    String nom = joueur.setNom("Pomme");
    this.assertEquals(nom,joueur.getNom());

    // Cas Limite : le nom entré est une chaine remplie
    Color color = new Color(255,255,255);
    Joueur joueur = new Joueur("",color,true);
    String nom = joueur.setNom("Pomme");
    this.assertEquals(nom,joueur.getNom());

  }
  @Test
  public void testColor(){
    // Cas Normal : la couleur est valide
    Color color = new Color(255,255,255);
    Joueur joueur = new Joueur("RENAULT",color,true);
    color = new Color(0,0,0);
    joueur.setColor(color);
    this.assertEquals(color,joueur.getColor());


  }
  @Test
  public void testALaMain(){
    Color color = new Color(255,255,255);
    Joueur joueur = new Joueur("RENAULT",color,true);
    joueur.setAlaMain(true);
    this.assertTrue( joueur.getALaMain() );
    joueur.setAlaMain(false);
    this.assertFalse( joueur.getALaMain() );
  }

}
